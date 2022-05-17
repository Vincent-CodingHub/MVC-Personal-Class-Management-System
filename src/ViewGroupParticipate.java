import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JPanel;

public class ViewGroupParticipate extends JFrame {
	private JTable table = new JTable();
	private JLabel lbl_frameTitle;
	private JScrollPane scrollPane;
	private JButton btn_return;
	private JButton btn_join;
	private DefaultTableModel model;
	private JLabel lblNewLabel;
	private JPanel panel;
	public String group_name, owner;
	private int idx;

	public ViewGroupParticipate(ControllerGroup controller) {
		super();
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set close by pressing x
		setBounds(100, 100, 843, 517);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lbl_frameTitle = new JLabel("Participate Group");
		lbl_frameTitle.setForeground(Color.WHITE);
		lbl_frameTitle.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_frameTitle.setBounds(246, 11, 353, 63);
		getContentPane().add(lbl_frameTitle);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 138, 780, 290);
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);

		model = (DefaultTableModel) table.getModel();
		String col[] = { "Group Name", "Owner" };
		getModel().setColumnIdentifiers(col);
		table.setFillsViewportHeight(true);

		btn_return = new JButton("Return");
		btn_return.setBackground(Color.RED);
		btn_return.setForeground(Color.WHITE);
		btn_return.setFont(new Font("Arial", Font.BOLD, 13));
		btn_return.setBounds(26, 11, 99, 40);
		btn_return.addActionListener((listener) -> {
			controller.closeParticipate();
			controller.showMain();
		});
		getContentPane().add(btn_return);

		btn_join = new JButton("Join");
		btn_join.setBackground(Color.GREEN);
		btn_join.setForeground(Color.WHITE);
		btn_join.setFont(new Font("Arial", Font.BOLD, 13));
		btn_join.setBounds(843 - 20 - 99 - 26, 11, 99, 40);
		btn_join.addActionListener((listener) -> {
			idx = table.getSelectedRow();
			if (idx != -1) {
				group_name = table.getModel().getValueAt(idx, 0).toString();
				controller.showGroupRoom();
				controller.closeParticipate();
			} else {
				JOptionPane.showMessageDialog(this, "No discussion group is selected.");
			}
		});
		getContentPane().add(btn_join);

		lblNewLabel = new JLabel("Available Group :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(26, 113, 131, 14);
		getContentPane().add(lblNewLabel);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 99, 807, 352);
		getContentPane().add(panel);
	}

	public DefaultTableModel getModel() {
		return model;
	}
	
	public int getIndex() {
		return idx;
	}
}
