import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.GroupLayout.Alignment;

public class ViewMeetRoom extends JFrame {
	private JPanel contentPane;
	private JTable table = new JTable();
	private JLabel lbl_frameTitle;
	private JScrollPane scrollPane;
	private JButton btn_return;
	private DefaultTableModel model;
	private JPanel panel_1;
	private JPanel panel;
	private JLabel PictureLabel;
	private JPanel panel_2;

	public ViewMeetRoom(ControllerMeeting controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 540);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbl_frameTitle = new JLabel("Meeting Room");
		lbl_frameTitle.setForeground(Color.WHITE);
		lbl_frameTitle.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_frameTitle.setBounds(378, 11, 336, 63);
		contentPane.add(lbl_frameTitle);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(871, 125, 132, 347);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();
		String col[] = { "Participant :" };
		model.setColumnIdentifiers(col);
		table.setFillsViewportHeight(true);
		String temp[][] = { { "Kent" }, { "Jian Hui" }, { "YJ" }, { "Alan" }, { "Xiao Li" }, { "Da Li" }, { "Da Tiao" },
				{ "Xiao Tiao" }, { "Da Diao" }, { "Xiao Diao" }, { "Fei Ji" }, { "Xiao Niao" }, { "Da Ben Xiang" },
				{ "Xixi" }, { "Ali" }, { "Abu" }, { "Siti" }, { "Muhammad" }, { "Aqil" }, { "Ke Ai" }, { "Kong" },
				{ "God" }, { "Alex" }, { "Edmund" }, { "Bryan" } };

		for (int i = 0; i < temp.length; i++) {
			model.addRow(temp[i]);
		}

		btn_return = new JButton("Return");
		btn_return.setBackground(Color.RED);
		btn_return.setForeground(Color.WHITE);
		btn_return.setFont(new Font("Arial", Font.BOLD, 13));
		btn_return.addActionListener((listener) -> {
			controller.closeMeetRoom();
			controller.showMain();
		});
		btn_return.setBounds(10, 11, 99, 40);
		contentPane.add(btn_return);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(854, 114, 166, 376);
		contentPane.add(panel_1);

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(46, 125, 774, 347);
		contentPane.add(panel);

		PictureLabel = new JLabel("New label");
		PictureLabel.setIcon(new ImageIcon("Picture\\New.JPG"));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(PictureLabel, GroupLayout.PREFERRED_SIZE, 752, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(PictureLabel,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE));
		panel.setLayout(gl_panel);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(21, 114, 823, 376);
		contentPane.add(panel_2);
	}

	public DefaultTableModel getModel() {
		return model;
	}

}
