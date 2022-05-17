import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class ViewCourseRegister extends JFrame {
	private JPanel contentPane;
	private JTable table = new JTable();
	private JLabel lbl_frameTitle, lbl_existingCourse, lbl_courseCode, lbl_courseName, lbl_creditHour, lbl_set,
			lbl_timeSlot;
	private JScrollPane scrollPane;
	public JTextField txt_courseCode, txt_courseName, txt_creditHour, txt_set, txt_timeSlot;
	private JButton btn_join, btn_return;
	private DefaultTableModel model;
	private JPanel panel;
	private JPanel panel_1;

	public ViewCourseRegister(ControllerCourse controller) {
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
		lbl_courseCode.setBounds(32, 138, 183, 14);
		contentPane.add(lbl_courseCode);

		txt_courseCode = new JTextField();
		txt_courseCode.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_courseCode.setBounds(32, 161, 183, 20);
		txt_courseCode.setColumns(10);
		txt_courseCode.setEditable(false);
		contentPane.add(txt_courseCode);

		lbl_courseName = new JLabel("COURSE NAME:");
		lbl_courseName.setForeground(Color.WHITE);
		lbl_courseName.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_courseName.setBounds(32, 192, 183, 14);
		contentPane.add(lbl_courseName);

		txt_courseName = new JTextField();
		txt_courseName.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_courseName.setColumns(10);
		txt_courseName.setBounds(32, 215, 183, 20);
		txt_courseName.setEditable(false);
		contentPane.add(txt_courseName);

		lbl_creditHour = new JLabel("CREDIT HOUR:");
		lbl_creditHour.setForeground(Color.WHITE);
		lbl_creditHour.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_creditHour.setBounds(32, 257, 183, 14);
		contentPane.add(lbl_creditHour);

		txt_creditHour = new JTextField();
		txt_creditHour.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_creditHour.setColumns(10);
		txt_creditHour.setBounds(32, 280, 183, 20);
		txt_creditHour.setEditable(false);
		contentPane.add(txt_creditHour);

		lbl_set = new JLabel("SET:");
		lbl_set.setForeground(Color.WHITE);
		lbl_set.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_set.setBounds(32, 311, 183, 14);
		contentPane.add(lbl_set);

		txt_set = new JTextField();
		txt_set.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_set.setColumns(10);
		txt_set.setBounds(32, 334, 183, 20);
		txt_set.setEditable(false);
		contentPane.add(txt_set);

		lbl_timeSlot = new JLabel("TIME SLOT:");
		lbl_timeSlot.setForeground(Color.WHITE);
		lbl_timeSlot.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_timeSlot.setBounds(32, 365, 183, 14);
		contentPane.add(lbl_timeSlot);

		txt_timeSlot = new JTextField();
		txt_timeSlot.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_timeSlot.setColumns(10);
		txt_timeSlot.setBounds(32, 388, 183, 20);
		txt_timeSlot.setEditable(false);
		contentPane.add(txt_timeSlot);

		lbl_existingCourse = new JLabel("Available Courses :");
		lbl_existingCourse.setForeground(Color.WHITE);
		lbl_existingCourse.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_existingCourse.setBackground(Color.WHITE);
		lbl_existingCourse.setBounds(271, 125, 177, 14);
		contentPane.add(lbl_existingCourse);

		lbl_frameTitle = new JLabel("Course Registration");
		lbl_frameTitle.setForeground(Color.WHITE);
		lbl_frameTitle.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_frameTitle.setBounds(342, 11, 390, 63);
		contentPane.add(lbl_frameTitle);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 161, 733, 311);
		contentPane.add(scrollPane);
		table.setFont(new Font("Arial", Font.PLAIN, 12));

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
					JOptionPane.showMessageDialog(null, "Please select the course that you want to register.");
				}
			}
		});

		btn_join = new JButton("Register");
		btn_join.setBackground(Color.GREEN);
		btn_join.setForeground(Color.WHITE);
		btn_join.setFont(new Font("Arial", Font.BOLD, 13));
		btn_join.addActionListener((listener) -> {
			if (!txt_courseCode.getText().isEmpty() && !txt_courseName.getText().isEmpty()
					&& !txt_creditHour.getText().isEmpty() && !txt_set.getText().isEmpty()
					&& !txt_timeSlot.getText().isEmpty()) {
				if (controller.checkDuplicateCourse()) {
					controller.addCourse();
					JOptionPane.showMessageDialog(null, "Register course successfully.");
				} else {
					JOptionPane.showMessageDialog(null, "You have registered this course.");
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Please select the courses in the table until the system shows the information of the course in the text box.");
			}
		});

		btn_join.setBounds(68, 432, 114, 40);
		contentPane.add(btn_join);

		btn_return = new JButton("Return");
		btn_return.setBackground(Color.RED);
		btn_return.setForeground(Color.WHITE);
		btn_return.setFont(new Font("Arial", Font.BOLD, 13));
		btn_return.addActionListener((listener) -> {
			controller.closeRegisterCourse();
			controller.showMain();
		});
		btn_return.setBounds(10, 11, 99, 40);
		contentPane.add(btn_return);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 117, 232, 374);
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(251, 116, 769, 375);
		contentPane.add(panel_1);

	}

	public DefaultTableModel getModel() {
		return model;
	}
}
