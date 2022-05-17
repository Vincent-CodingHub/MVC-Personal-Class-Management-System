import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ViewAssignmentList extends JFrame {
	private JPanel contentPane, panel;
	public JTextField txt_title, txt_date, txt_courseName, txt_courseCode;
	private final JFileChooser openFileChooser = new JFileChooser();
	public JLabel lbl_header, lbl_title, lbl_date, lbl_courseCode, lbl_courseName, lbl_addFile;
	private JButton btn_addFile, btn_save, btn_cancel;

	public ViewAssignmentList(ControllerAssignment controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 476);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(45, 93, 636, 270);
		contentPane.add(panel);
		panel.setLayout(null);

		lbl_header = new JLabel("Upload Assignment");
		lbl_header.setForeground(Color.WHITE);
		lbl_header.setFont(new Font("Verdana", Font.BOLD, 30));
		lbl_header.setBounds(46, 33, 380, 49);
		contentPane.add(lbl_header);

		lbl_title = new JLabel("Assignment Title");
		lbl_title.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setBounds(24, 127, 179, 41);
		panel.add(lbl_title);

		lbl_date = new JLabel("Due Date");
		lbl_date.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_date.setForeground(Color.WHITE);
		lbl_date.setBounds(24, 183, 179, 33);
		panel.add(lbl_date);

		lbl_courseCode = new JLabel("Course Code");
		lbl_courseCode.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_courseCode.setForeground(Color.WHITE);
		lbl_courseCode.setBounds(24, 15, 179, 41);
		panel.add(lbl_courseCode);

		lbl_courseName = new JLabel("Course Name");
		lbl_courseName.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_courseName.setForeground(Color.WHITE);
		lbl_courseName.setBounds(24, 71, 179, 41);
		panel.add(lbl_courseName);

		lbl_addFile = new JLabel("No file");
		lbl_addFile.setForeground(new Color(255, 255, 255));
		lbl_addFile.setFont(new Font("Arial", Font.PLAIN, 12));
		lbl_addFile.setBounds(213, 235, 242, 13);
		panel.add(lbl_addFile);

		txt_title = new JTextField();
		txt_title.setFont(new Font("Arial", Font.BOLD, 13));
		txt_title.setBounds(213, 137, 242, 19);
		panel.add(txt_title);
		txt_title.setColumns(10);

		txt_date = new JTextField();
		txt_date.setFont(new Font("Arial", Font.BOLD, 13));
		txt_date.setBounds(213, 189, 242, 19);
		panel.add(txt_date);
		txt_date.setColumns(10);

		txt_courseName = new JTextField();
		txt_courseName.setFont(new Font("Arial", Font.BOLD, 13));
		txt_courseName.setColumns(10);
		txt_courseName.setBounds(213, 79, 242, 19);
		panel.add(txt_courseName);

		txt_courseCode = new JTextField();
		txt_courseCode.setFont(new Font("Arial", Font.BOLD, 13));
		txt_courseCode.setColumns(10);
		txt_courseCode.setBounds(213, 25, 242, 19);
		panel.add(txt_courseCode);

		btn_addFile = new JButton("Add File");
		btn_addFile.setFont(new Font("Arial", Font.BOLD, 13));
		btn_addFile.setBounds(24, 231, 115, 21);

		btn_addFile.addActionListener((listener) -> {
			openFileChooser.setCurrentDirectory(new File("/"));
			int val = openFileChooser.showOpenDialog(panel);
			if (val == JFileChooser.APPROVE_OPTION) {
				try {
					lbl_addFile.setText(openFileChooser.getSelectedFile().getName());
				} catch (Exception e1) {
					lbl_addFile.setText(e1.toString());
				}
			} else {
				lbl_addFile.setText("No file");
			}
		});
		panel.add(btn_addFile);

		btn_save = new JButton("Save");
		btn_save.setFont(new Font("Arial", Font.BOLD, 13));
		btn_save.setForeground(Color.WHITE);
		btn_save.setBackground(new Color(0, 255, 0));
		btn_save.setOpaque(true);
		btn_save.setBounds(188, 374, 91, 35);
		btn_save.addActionListener((listener) -> {
			if (!(txt_courseCode.getText().equals(null) || txt_courseName.getText().equals(null)
					|| txt_title.getText().equals(null) || txt_date.getText().equals(null)
					|| lbl_addFile.getText().equals("No file"))) {
				controller.uploadAssignment();
				JOptionPane.showMessageDialog(panel, "Upload successful!");
				txt_courseCode.setText(null);
				txt_courseName.setText(null);
				txt_title.setText(null);
				txt_date.setText(null);
				lbl_addFile.setText("No file");
			} else {
				JOptionPane.showMessageDialog(null,
						"Please fill in all the information of the assignment and upload the attachedment file.");
			}
		});
		contentPane.add(btn_save);

		btn_cancel = new JButton("Cancel");
		btn_cancel.setBackground(Color.RED);
		btn_cancel.setForeground(Color.WHITE);
		btn_cancel.setFont(new Font("Arial", Font.BOLD, 13));
		btn_cancel.setBounds(446, 374, 91, 35);
		btn_cancel.addActionListener((listener) -> {
			controller.closeAssignment();
			controller.controllerMain.showMain();
		});
		contentPane.add(btn_cancel);

	}
}
