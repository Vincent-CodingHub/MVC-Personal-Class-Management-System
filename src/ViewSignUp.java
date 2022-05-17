import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

public class ViewSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField txt_password;
	private JPasswordField txt_cfmPass;

	public ViewSignUp(ControllerMain controller) {
		super("signUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 465);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lbl_title = new JLabel("Sign Up");
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_title.setBounds(215, 11, 163, 46);
		contentPane.add(lbl_title);

		JLabel lbl_username = new JLabel("Username");
		lbl_username.setForeground(Color.WHITE);
		lbl_username.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_username.setBounds(71, 111, 120, 13);
		contentPane.add(lbl_username);

		txt_username = new JTextField();
		txt_username.setFont(new Font("Arial", Font.PLAIN, 15));
		txt_username.setBounds(247, 108, 253, 19);
		contentPane.add(txt_username);
		txt_username.setColumns(10);

		JLabel lbl_position = new JLabel("Position");
		lbl_position.setForeground(Color.WHITE);
		lbl_position.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_position.setBounds(71, 162, 120, 13);
		contentPane.add(lbl_position);

		String list[] = { "Student", "Instructor" };
		JComboBox cmb_position = new JComboBox(list);
		cmb_position.setFont(new Font("Arial", Font.PLAIN, 15));
		cmb_position.setBounds(247, 162, 253, 19);
		contentPane.add(cmb_position);

		JLabel lbl_password = new JLabel("Password");
		lbl_password.setForeground(Color.WHITE);
		lbl_password.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_password.setBounds(71, 216, 120, 13);
		contentPane.add(lbl_password);

		txt_password = new JPasswordField();
		txt_password.setFont(new Font("Arial", Font.PLAIN, 15));
		txt_password.setBounds(247, 213, 253, 19);
		contentPane.add(txt_password);
		txt_password.setColumns(10);

		JLabel lbl_cfmPass = new JLabel("Confirm Password");
		lbl_cfmPass.setForeground(Color.WHITE);
		lbl_cfmPass.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_cfmPass.setBounds(71, 270, 148, 13);
		contentPane.add(lbl_cfmPass);

		txt_cfmPass = new JPasswordField();
		txt_cfmPass.setFont(new Font("Arial", Font.PLAIN, 15));
		txt_cfmPass.setBounds(247, 267, 253, 19);
		contentPane.add(txt_cfmPass);
		txt_cfmPass.setColumns(10);

		JButton btn_signup = new JButton("Sign Up");
		btn_signup.setBackground(Color.GREEN);
		btn_signup.setForeground(Color.WHITE);
		btn_signup.setFont(new Font("Arial", Font.BOLD, 13));
		btn_signup.addActionListener((listener) -> {
			if (!txt_username.getText().isEmpty() && txt_password.getPassword().length != 0
					&& txt_cfmPass.getPassword().length != 0) {
				if (controller.createUser(txt_username.getText(), new String(txt_cfmPass.getPassword()),
						cmb_position.getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(null, "Sign up successful!");
					txt_username.setText("");
					txt_password.setText("");
					txt_cfmPass.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Username existed!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Please do not leave any blank.");
			}
		});
		btn_signup.setBounds(122, 343, 96, 46);
		contentPane.add(btn_signup);

		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.setBackground(Color.RED);
		btn_cancel.setForeground(Color.WHITE);
		btn_cancel.setFont(new Font("Arial", Font.BOLD, 13));
		btn_cancel.addActionListener((listener) -> {
			controller.closeSignup();
			controller.showLogin();
		});
		btn_cancel.setBounds(368, 343, 96, 46);
		contentPane.add(btn_cancel);

		getContentPane().add(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 85, 538, 235);
		contentPane.add(panel);

	}
}
