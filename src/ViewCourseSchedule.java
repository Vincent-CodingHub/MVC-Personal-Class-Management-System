import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class ViewCourseSchedule extends JFrame {
	private JPanel contentPane;
	private JTable table = new JTable();
	private JLabel lbl_frameTitle;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JPanel panel;

	public ViewCourseSchedule(ControllerCourse controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 367);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 138, 848, 135);
		contentPane.add(scrollPane);

		model = (DefaultTableModel) table.getModel();
		String[] time_col = { "", "0800-1000", "1000-1200", "1200-1400", "1400-1600", "1600-1800" };
		model.setColumnIdentifiers(time_col);

		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setLocation(69, 0);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);

		lbl_frameTitle = new JLabel("Schedule/Timetable");
		lbl_frameTitle.setForeground(Color.WHITE);
		lbl_frameTitle.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_frameTitle.setBounds(244, 11, 444, 63);
		contentPane.add(lbl_frameTitle);

		JButton btn_return = new JButton("Return");
		btn_return.setBackground(Color.RED);
		btn_return.setForeground(Color.WHITE);
		btn_return.setFont(new Font("Arial", Font.BOLD, 13));
		btn_return.addActionListener((listener) -> {
			controller.closeCourseSchedule();
			controller.showMain();
		});
		btn_return.setBounds(26, 11, 99, 40);
		contentPane.add(btn_return);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 110, 883, 186);
		contentPane.add(panel);

	}

	public DefaultTableModel getModel() {
		return model;
	}

}
