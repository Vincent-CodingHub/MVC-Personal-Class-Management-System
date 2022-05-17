import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class ViewMeetList extends JFrame {
	private JPanel contentPane;
	private JLabel lbl_frameTitle, lbl_meetingTitle, lbl_meetingDate, lbl_meetingTime;
	private JTextField txt_meetingTitle, txt_meetingTime, txt_meetingDate;
	private JScrollPane scrollPane;
	private JButton btn_join, btn_return;
	private JTable table = new JTable();
	private DefaultTableModel model;
	private JPanel panel;
	private JPanel panel_1;

	public ViewMeetList(ControllerMeeting controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 572);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 113, 740, 247);
		contentPane.add(scrollPane);

		String col[] = { "Meeting Title", "Meeting Time", "Meeting Date" };
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setLocation(80, 0);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);

		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(col);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					int i = table.getSelectedRow();
					txt_meetingTitle.setText(model.getValueAt(i, 0).toString());
					txt_meetingTime.setText(model.getValueAt(i, 1).toString());
					txt_meetingDate.setText(model.getValueAt(i, 2).toString());
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, "Please select the row in the list that you want to join");
				}
			}
		});

		lbl_frameTitle = new JLabel("Meeting List");
		lbl_frameTitle.setForeground(Color.WHITE);
		lbl_frameTitle.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_frameTitle.setBounds(294, 35, 260, 63);
		contentPane.add(lbl_frameTitle);

		lbl_meetingTitle = new JLabel("Meeting Title:");
		lbl_meetingTitle.setForeground(Color.WHITE);
		lbl_meetingTitle.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_meetingTitle.setBounds(52, 394, 106, 13);
		contentPane.add(lbl_meetingTitle);

		lbl_meetingTime = new JLabel("Meeting Time:");
		lbl_meetingTime.setForeground(Color.WHITE);
		lbl_meetingTime.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_meetingTime.setBounds(313, 394, 107, 13);
		contentPane.add(lbl_meetingTime);

		lbl_meetingDate = new JLabel("Meeting Date:");
		lbl_meetingDate.setForeground(Color.WHITE);
		lbl_meetingDate.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_meetingDate.setBounds(577, 394, 124, 13);
		contentPane.add(lbl_meetingDate);
		
		txt_meetingTitle = new JTextField();
		txt_meetingTitle.setBounds(52, 417, 214, 19);
		txt_meetingTitle.setColumns(10);
		txt_meetingTitle.setEditable(false);
		contentPane.add(txt_meetingTitle);

		txt_meetingTime = new JTextField();
		txt_meetingTime.setBounds(313, 417, 222, 19);
		txt_meetingTime.setColumns(10);
		txt_meetingTime.setEditable(false);
		contentPane.add(txt_meetingTime);

		txt_meetingDate = new JTextField();
		txt_meetingDate.setBounds(577, 417, 203, 19);
		txt_meetingDate.setColumns(10);
		txt_meetingDate.setEditable(false);
		contentPane.add(txt_meetingDate);

		btn_join = new JButton("Join");
		btn_join.setBackground(Color.GREEN);
		btn_join.setForeground(Color.WHITE);
		btn_join.setFont(new Font("Arial", Font.BOLD, 13));
		btn_join.addActionListener((listener) -> {
			if (txt_meetingTitle.getText().isEmpty() && txt_meetingTime.getText().isEmpty()
					&& txt_meetingDate.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please select a meeting to join");
			} else {
				controller.closeListMeet();
				controller.joinMeeting();
			}
		});

		btn_join.setBounds(368, 482, 113, 40);
		contentPane.add(btn_join);

		btn_return = new JButton("Return");
		btn_return.setForeground(Color.WHITE);
		btn_return.setFont(new Font("Arial", Font.BOLD, 13));
		btn_return.setBackground(Color.RED);
		btn_return.addActionListener((listener) -> {
			controller.closeListMeet();
			controller.showMain();
		});
		btn_return.setBounds(26, 11, 99, 40);
		contentPane.add(btn_return);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 102, 796, 271);
		contentPane.add(panel);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(10, 375, 796, 83);
		contentPane.add(panel_1);
	}

	public DefaultTableModel getModel() {
		return model;
	}
}
