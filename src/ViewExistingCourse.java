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

public class ViewExistingCourse extends JFrame {
	private JPanel contentPane;
	private JTable table = new JTable();
	private JLabel lbl_frameTitle;
	private JScrollPane scrollPane;
	private JButton btn_return;
	private DefaultTableModel model;
	private JPanel panel;

	public ViewExistingCourse(ControllerCourse controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 517);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbl_frameTitle = new JLabel("Registered Course");
		lbl_frameTitle.setForeground(Color.WHITE);
		lbl_frameTitle.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_frameTitle.setBounds(236, 11, 381, 63);
		contentPane.add(lbl_frameTitle);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 138, 780, 290);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);

		model = (DefaultTableModel) table.getModel();
		String col[] = { "CourseCode", "CourseName", "CreditHour", "Set", "TimeSlot" };
		model.setColumnIdentifiers(col);
		table.setFillsViewportHeight(true);

		btn_return = new JButton("Return");
		btn_return.setBackground(Color.RED);
		btn_return.setFont(new Font("Arial", Font.BOLD, 13));
		btn_return.setForeground(Color.WHITE);
		btn_return.addActionListener((listener) -> {
			controller.closeExistCourse();
			controller.showMain();
		});

		btn_return.setBounds(26, 11, 99, 40);
		contentPane.add(btn_return);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 113, 807, 337);
		contentPane.add(panel);
	}

	public DefaultTableModel getModel() {
		return model;
	}
}
