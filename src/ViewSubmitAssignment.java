import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.JFileChooser;

public class ViewSubmitAssignment extends JFrame {
	private JPanel contentPane;
	private JTable table = new JTable();
	private JLabel lbl_frameTitle, lbl_addFile, lbl_courseCode;
	private JScrollPane scrollPane;
	private JTextField txt_assignment;
	private JButton btn_join, btn_addFile, btn_return;
	private final JFileChooser openFileChooser = new JFileChooser();
	private DefaultTableModel model;
	private int i;
	private JPanel panel;
	private JPanel panel_1;

	public ViewSubmitAssignment(ControllerAssignment controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 515);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbl_frameTitle = new JLabel("Submit Assignment");
		lbl_frameTitle.setForeground(Color.WHITE);
		lbl_frameTitle.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_frameTitle.setBounds(210, 11, 399, 63);
		contentPane.add(lbl_frameTitle);

		lbl_addFile = new JLabel("No File");
		lbl_addFile.setForeground(Color.WHITE);
		lbl_addFile.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_addFile.setBounds(135, 379, 657, 14);
		contentPane.add(lbl_addFile);

		lbl_courseCode = new JLabel("Assignment:");
		lbl_courseCode.setForeground(Color.WHITE);
		lbl_courseCode.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_courseCode.setBounds(24, 315, 99, 28);
		contentPane.add(lbl_courseCode);

		txt_assignment = new JTextField();
		txt_assignment.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_assignment.setBounds(24, 343, 768, 20);
		txt_assignment.setEditable(false);
		contentPane.add(txt_assignment);
		txt_assignment.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 85, 766, 208);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);

		model = (DefaultTableModel) table.getModel();
		String col[] = { "Course code", "Course name", "Title", "Attachment file", "Due date", "Status" };
		model.setColumnIdentifiers(col);
		table.setFillsViewportHeight(true);
		table.setLocation(69, 0);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(78);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.getColumnModel().getColumn(4).setPreferredWidth(99);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					i = table.getSelectedRow();
					txt_assignment.setText(model.getValueAt(i, 0).toString() + " " + model.getValueAt(i, 1).toString()
							+ " " + model.getValueAt(i, 2).toString());
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, "Please select the assignment task.");
				}
			}
		});

		btn_join = new JButton("Submit");
		btn_join.setBackground(Color.GREEN);
		btn_join.setForeground(Color.WHITE);
		btn_join.setFont(new Font("Arial", Font.BOLD, 13));
		btn_join.addActionListener((listener) -> {
			if ((txt_assignment.getText().equals(null) && lbl_addFile.getText().equals("No File"))
					|| (txt_assignment.getText().equals(null) || lbl_addFile.getText().equals("No File"))) {
				JOptionPane.showMessageDialog(null, "Please select your work.");
			} else {
				i = table.getSelectedRow();
				controller.submitAssignment();
				JOptionPane.showMessageDialog(null, "Submitted successsfully.");
			}
		});

		btn_join.setBounds(350, 425, 114, 40);
		contentPane.add(btn_join);

		btn_addFile = new JButton("ADD FILE");
		btn_addFile.setFont(new Font("Arial", Font.BOLD, 13));
		btn_addFile.addActionListener((listener) -> {
			openFileChooser.setCurrentDirectory(new File("/"));
			int val = openFileChooser.showOpenDialog(contentPane);
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
		btn_addFile.setBounds(26, 375, 99, 23);
		contentPane.add(btn_addFile);

		btn_return = new JButton("Return");
		btn_return.setBackground(Color.RED);
		btn_return.setForeground(Color.WHITE);
		btn_return.setFont(new Font("Arial", Font.BOLD, 13));
		btn_return.addActionListener((listener) -> {
			controller.closeSubmit();
			controller.controllerMain.showMain();
		});
		btn_return.setBounds(26, 11, 99, 40);
		contentPane.add(btn_return);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 64, 803, 251);
		contentPane.add(panel);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(10, 315, 803, 95);
		contentPane.add(panel_1);
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public Integer getSelectedRowNo() {
		return i;
	}

}
