import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class ViewCourseDrop extends JFrame {
	private JPanel contentPane;
	private JTable table = new JTable();
	private JLabel lbl_frameTitle, lbl_existingcourse, lbl_courseCode, lbl_courseName, lbl_creditHour, lbl_set,
			lbl_timeSlot;
	private JScrollPane scrollPane;
	public JTextField txt_courseCode, txt_courseName, txt_creditHour, txt_set, txt_timeSlot;
	private JButton btn_join, btn_return;
	private DefaultTableModel model;
	private JPanel panel;
	private JPanel panel_1;

	public ViewCourseDrop(ControllerCourse controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 540);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbl_courseCode = new JLabel("COURSE CODE:");
		lbl_courseCode.setForeground(Color.WHITE);
		lbl_courseCode.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_courseCode.setBounds(26, 138, 183, 14);
		contentPane.add(lbl_courseCode);

		txt_courseCode = new JTextField();
		txt_courseCode.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_courseCode.setBounds(26, 161, 183, 20);
		txt_courseCode.setColumns(10);
		txt_courseCode.setEditable(false);
		contentPane.add(txt_courseCode);

		lbl_courseName = new JLabel("COURSE NAME:");
		lbl_courseName.setForeground(Color.WHITE);
		lbl_courseName.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_courseName.setBounds(26, 192, 183, 14);
		contentPane.add(lbl_courseName);

		txt_courseName = new JTextField();
		txt_courseName.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_courseName.setColumns(10);
		txt_courseName.setBounds(26, 215, 183, 20);
		txt_courseName.setEditable(false);
		contentPane.add(txt_courseName);

		lbl_creditHour = new JLabel("CREDIT HOUR:");
		lbl_creditHour.setForeground(Color.WHITE);
		lbl_creditHour.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_creditHour.setBounds(26, 257, 183, 14);
		contentPane.add(lbl_creditHour);

		txt_creditHour = new JTextField();
		txt_creditHour.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_creditHour.setColumns(10);
		txt_creditHour.setBounds(26, 280, 183, 20);
		txt_creditHour.setEditable(false);
		contentPane.add(txt_creditHour);

		lbl_set = new JLabel("SET:");
		lbl_set.setForeground(Color.WHITE);
		lbl_set.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_set.setBounds(26, 311, 183, 14);
		contentPane.add(lbl_set);

		txt_set = new JTextField();
		txt_set.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_set.setColumns(10);
		txt_set.setBounds(26, 334, 183, 20);
		txt_set.setEditable(false);
		contentPane.add(txt_set);

		lbl_timeSlot = new JLabel("TIME SLOT:");
		lbl_timeSlot.setForeground(Color.WHITE);
		lbl_timeSlot.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_timeSlot.setBounds(26, 365, 183, 14);
		contentPane.add(lbl_timeSlot);

		txt_timeSlot = new JTextField();
		txt_timeSlot.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_timeSlot.setColumns(10);
		txt_timeSlot.setBounds(26, 388, 183, 20);
		txt_timeSlot.setEditable(false);
		contentPane.add(txt_timeSlot);

		lbl_existingcourse = new JLabel("Available Courses :");
		lbl_existingcourse.setForeground(Color.WHITE);
		lbl_existingcourse.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_existingcourse.setBackground(Color.WHITE);
		lbl_existingcourse.setBounds(271, 125, 177, 14);
		contentPane.add(lbl_existingcourse);

		lbl_frameTitle = new JLabel("Course Drop/Withdrawal");
		lbl_frameTitle.setForeground(Color.WHITE);
		lbl_frameTitle.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_frameTitle.setBounds(256, 11, 549, 63);
		contentPane.add(lbl_frameTitle);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 161, 733, 311);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();
		String col[] = { "CourseCode", "CourseName", "CreditHour", "Set", "TimeSlot" };
		model.setColumnIdentifiers(col);
		table.setFillsViewportHeight(true);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					int i = table.getSelectedRow();
					txt_courseCode.setText(model.getValueAt(i, 0).toString());
					txt_courseName.setText(model.getValueAt(i, 1).toString());
					txt_creditHour.setText(model.getValueAt(i, 2).toString());
					txt_set.setText(model.getValueAt(i, 3).toString());
					txt_timeSlot.setText(model.getValueAt(i, 4).toString());
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, "Please select the course that you want to drop.");
				}
			}
		});

		btn_join = new JButton("Drop ");
		btn_join.setBackground(Color.GREEN);
		btn_join.setForeground(Color.WHITE);
		btn_join.setFont(new Font("Arial", Font.BOLD, 13));
		btn_join.addActionListener((listener) -> {
			if (!txt_courseCode.getText().isEmpty() && !txt_courseName.getText().isEmpty()
					&& !txt_creditHour.getText().isEmpty() && !txt_set.getText().isEmpty()
					&& !txt_timeSlot.getText().isEmpty()) {
				controller.dropCourse();
				JOptionPane.showMessageDialog(null, "You have dropped the course successfully.");
			} else {
				JOptionPane.showMessageDialog(null, "Please choose the course to drop.");
			}
		});

		btn_join.setBounds(54, 431, 114, 40);
		contentPane.add(btn_join);

		btn_return = new JButton("Return");
		btn_return.setBackground(Color.RED);
		btn_return.setForeground(Color.WHITE);
		btn_return.setFont(new Font("Arial", Font.BOLD, 13));
		btn_return.addActionListener((listener) -> {
			controller.closeDropCourse();
			controller.showMain();
		});
		btn_return.setBounds(10, 11, 99, 40);
		contentPane.add(btn_return);

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 114, 226, 376);
		contentPane.add(panel);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(256, 114, 764, 376);
		contentPane.add(panel_1);

	}

	public DefaultTableModel getModel() {
		return model;
	}

}
