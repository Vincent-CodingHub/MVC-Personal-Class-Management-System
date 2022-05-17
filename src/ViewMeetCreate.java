import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class ViewMeetCreate extends JFrame {
	private JPanel contentPane, panel;
	private JTable table = new JTable();
	public JTextField txt_title, txt_startDate, txt_startTime;
	private JLabel lbl_title, lbl_startDate, lbl_startTime, lbl_frameTitle;
	private JButton btn_schedule, btn_return;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JPanel panel_1;

	public ViewMeetCreate(ControllerMeeting controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 506);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(24, 123, 320, 312);
		contentPane.add(panel);
		panel.setLayout(null);

		lbl_title = new JLabel("Meeting Title");
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_title.setBounds(10, 28, 103, 35);
		txt_title = new JTextField();
		txt_title.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_title.setBounds(115, 35, 183, 19);
		panel.add(lbl_title);
		panel.add(txt_title);

		lbl_startTime = new JLabel("Meeting Time");
		lbl_startTime.setForeground(Color.WHITE);
		lbl_startTime.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_startTime.setBounds(10, 87, 103, 35);
		txt_startTime = new JTextField();
		txt_startTime.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_startTime.setBounds(115, 94, 183, 19);
		panel.add(lbl_startTime);
		panel.add(txt_startTime);

		lbl_startDate = new JLabel("Meeting Date");
		lbl_startDate.setForeground(Color.WHITE);
		lbl_startDate.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_startDate.setBounds(10, 151, 103, 27);
		txt_startDate = new JTextField();
		txt_startDate.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_startDate.setBounds(115, 154, 183, 19);
		panel.add(lbl_startDate);
		panel.add(txt_startDate);

		JLabel lbl_timeFormat = new JLabel("*Example: 0800-1000 *");
		lbl_timeFormat.setForeground(new Color(0, 0, 0));
		lbl_timeFormat.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_timeFormat.setBounds(115, 124, 183, 14);
		panel.add(lbl_timeFormat);
		
		JLabel lbl_dateFormat = new JLabel("*Example: 31-12-2021*");
		lbl_dateFormat.setForeground(new Color(0, 0, 0));
		lbl_dateFormat.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_dateFormat.setBounds(115, 189, 183, 14);
		panel.add(lbl_dateFormat);
		
		btn_schedule = new JButton("Schedule");
		btn_schedule.setBackground(Color.GREEN);
		btn_schedule.setBounds(100, 230, 116, 41);
		panel.add(btn_schedule);
		btn_schedule.setForeground(Color.WHITE);
		btn_schedule.setFont(new Font("Arial", Font.BOLD, 13));
		btn_schedule.addActionListener((listener) -> {
			if (!txt_title.getText().equals("") && !txt_startTime.getText().equals("")
					&& !txt_startDate.getText().equals("")) {
				controller.addMeeting();
				JOptionPane.showMessageDialog(null, "You have sceduled the meeting successfully.");
				txt_title.setText(null);
				txt_startTime.setText(null);
				txt_startDate.setText(null);
				controller.showNotification();
			} else {
				JOptionPane.showMessageDialog(null, "Please fill in all the text box.");
			}
		});

		String col[] = { "Meeting Title", "Meeting Time", "Meeting Date" };
		scrollPane = new JScrollPane();
		scrollPane.setBounds(374, 138, 417, 282);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(col);
		table.setFillsViewportHeight(true);

		lbl_frameTitle = new JLabel("Schedule Meeting");
		lbl_frameTitle.setForeground(Color.WHITE);
		lbl_frameTitle.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_frameTitle.setBounds(254, 11, 360, 63);
		contentPane.add(lbl_frameTitle);

		btn_return = new JButton("Return");
		btn_return.setBackground(Color.RED);
		btn_return.setForeground(Color.WHITE);
		btn_return.setFont(new Font("Arial", Font.BOLD, 13));
		btn_return.setBounds(10, 11, 116, 41);
		btn_return.addActionListener((listener) -> {
			controller.closeCreateMeet();
			controller.showMain();
		});
		contentPane.add(btn_return);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(356, 123, 450, 312);
		contentPane.add(panel_1);
	}

	public DefaultTableModel getModel() {
		return model;
	}

}
