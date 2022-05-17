import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class ViewGroupCreate extends JFrame {

	private JPanel contentPane;
	public JLabel lbl_name;
	public JFormattedTextField txt_name;
	public JComboBox cmb_owner;
	public JButton btn_return;
	private JLabel lblNewLabel;
	private JPanel panel;

	public ViewGroupCreate(ControllerGroup controller) {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 368);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbl_name = new JLabel("GROUP NAME");
		lbl_name.setForeground(Color.WHITE);
		lbl_name.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_name.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_name.setBounds(61, 111, 120, 29);
		contentPane.add(lbl_name);

		txt_name = new JFormattedTextField();
		txt_name.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_name.setBounds(208, 111, 404, 29);
		contentPane.add(txt_name);

		cmb_owner = new JComboBox(controller.getUsersKey());
		cmb_owner.setFont(new Font("Arial", Font.PLAIN, 13));
		cmb_owner.setBounds(208, 187, 404, 29);
		contentPane.add(cmb_owner);

		JLabel lbl_owner = new JLabel("OWNER");
		lbl_owner.setForeground(Color.WHITE);
		lbl_owner.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_owner.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_owner.setBounds(61, 192, 120, 29);
		contentPane.add(lbl_owner);

		btn_return = new JButton("Return");
		btn_return.setBackground(Color.RED);
		btn_return.setForeground(Color.WHITE);
		btn_return.setFont(new Font("Arial", Font.BOLD, 13));
		btn_return.setBounds(10, 11, 101, 45);
		btn_return.addActionListener((listener) -> {
			controller.closeCreate();
			controller.showMain();
		});
		contentPane.add(btn_return);

		JButton btn_create = new JButton("Create");
		btn_create.setBackground(Color.GREEN);
		btn_create.setForeground(Color.WHITE);
		btn_create.setFont(new Font("Arial", Font.BOLD, 13));
		btn_create.setBounds(302, 273, 101, 45);
		btn_create.addActionListener((listener) -> {
			if (txt_name.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Name field is blank! Please type something.");
			} else {
				controller.addGroup(txt_name.getText(), cmb_owner.getSelectedItem().toString());
				JOptionPane.showMessageDialog(this, "Insert (" + txt_name.getText() + ")successfully!");
				txt_name.setText("");
				controller.showNotification();
			}
		});
		contentPane.add(btn_create);

		lblNewLabel = new JLabel("Create Group");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setBounds(224, 11, 259, 47);
		contentPane.add(lblNewLabel);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(26, 94, 654, 153);
		contentPane.add(panel);
	}

}
