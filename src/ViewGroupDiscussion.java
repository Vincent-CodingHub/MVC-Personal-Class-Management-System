import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class ViewGroupDiscussion extends JFrame {
	private JPanel contentPane;
	private JLabel lbl_frameTitle;
	private JButton btn_return;
	private DefaultTableModel model;
	public JTextField textBox;
	public JTextPane textPane;
	public String owner;
	public int index;
	private JLabel lbl_title;

	public ViewGroupDiscussion(ControllerGroup controller, String group_name, int index) {
		this.index = index;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 572);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbl_frameTitle = new JLabel(group_name);
		lbl_frameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_frameTitle.setForeground(Color.WHITE);
		lbl_frameTitle.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_frameTitle.setBounds(135, 35, 582, 63);
		contentPane.add(lbl_frameTitle);

		btn_return = new JButton("Return");
		btn_return.setForeground(Color.WHITE);
		btn_return.setFont(new Font("Arial", Font.BOLD, 13));
		btn_return.setBackground(Color.RED);
		btn_return.addActionListener((listener) -> {
			controller.closeGroupRoom();
			controller.showParticipate();
		});
		btn_return.setBounds(26, 11, 99, 40);
		contentPane.add(btn_return);

		textPane = new JTextPane();
		textPane.setBounds(58, 122, 696, 297);
		textPane.setEditable(false);
		contentPane.add(textPane);

		textBox = new JTextField();
		textBox.setText("type something here and post");
		textBox.setBounds(58, 443, 696, 20);
		contentPane.add(textBox);
		textBox.setColumns(10);

		JButton btn_post = new JButton("Post");
		btn_post.addActionListener((listener) -> {
			textPane.setText(controller.appendText());
			textBox.setText("");
		});
		btn_post.setBackground(Color.GREEN);
		btn_post.setForeground(Color.WHITE);
		btn_post.setFont(new Font("Arial", Font.BOLD, 13));
		btn_post.setBounds(359, 482, 99, 40);
		contentPane.add(btn_post);
		
		lbl_title = new JLabel("Discussion :");
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_title.setBounds(58, 97, 133, 14);
		contentPane.add(lbl_title);
	}

	public DefaultTableModel getModel() {
		return model;
	}
}
