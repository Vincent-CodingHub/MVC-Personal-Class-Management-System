import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class ViewGroupList extends JFrame {
	private JTable table = new JTable();
	private JLabel lbl_frameTitle;
	private JScrollPane scrollPane;
	private JButton btn_return;
	private JButton btn_join;
	static Timer timer;
	private DefaultTableModel model;
	private JPanel panel;

	public ViewGroupList(ControllerGroup controller) {
		super();
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set close by pressing x
		setBounds(100, 100, 843, 517);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lbl_frameTitle = new JLabel("Group Discussion List");
		lbl_frameTitle.setForeground(Color.WHITE);
		lbl_frameTitle.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_frameTitle.setBounds(200, 40, 523, 63);
		getContentPane().add(lbl_frameTitle);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 138, 780, 290);
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);

		model = (DefaultTableModel) table.getModel();
		String col[] = { "Name", "Owner" };
		model.setColumnIdentifiers(col);
		table.setFillsViewportHeight(true);

		btn_return = new JButton("Return");
		btn_return.setForeground(Color.WHITE);
		btn_return.setFont(new Font("Arial", Font.BOLD, 13));
		btn_return.setBackground(Color.RED);
		btn_return.setBounds(26, 11, 99, 40);
		btn_return.addActionListener((listener) -> {
			controller.closeList();
			controller.showMain();
		});
		getContentPane().add(btn_return);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 120, 807, 323);
		getContentPane().add(panel);
	}

	public DefaultTableModel getModel() {
		return model;
	}
}
