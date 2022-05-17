import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Font;
import java.awt.Color;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField txt_password;
	private JLabel lbl_clock;

	public ViewLogin(ControllerMain controller) {
		super("studentUnite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 427);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lbl_clock = new JLabel("Clock");
		lbl_clock.setForeground(Color.WHITE);
		lbl_clock.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_clock.setBounds(10, 363, 214, 14);

		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);

		int second = cal.get(Calendar.SECOND);
		int minute = cal.get(Calendar.MINUTE);
		int hour = cal.get(Calendar.HOUR);

		lbl_clock.setText(
				"Time " + hour + ":" + minute + ":" + second + " Date " + day + "/" + (month + 1) + "/" + year);
		contentPane.add(lbl_clock);

		JLabel lbl_title = new JLabel("StudentUnite");
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setFont(new Font("Arial", Font.BOLD, 40));
		lbl_title.setBounds(164, 32, 252, 31);
		contentPane.add(lbl_title);

		JLabel lbl_username = new JLabel("Username");
		lbl_username.setForeground(Color.WHITE);
		lbl_username.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_username.setBounds(77, 114, 112, 13);
		contentPane.add(lbl_username);

		JLabel lbl_password = new JLabel("Password");
		lbl_password.setForeground(Color.WHITE);
		lbl_password.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_password.setBounds(77, 167, 112, 13);
		contentPane.add(lbl_password);

		txt_username = new JTextField();
		txt_username.setFont(new Font("Arial", Font.BOLD, 16));
		txt_username.setBounds(234, 110, 214, 19);
		contentPane.add(txt_username);
		txt_username.setColumns(10);

		txt_password = new JPasswordField();
		txt_password.setFont(new Font("Arial", Font.BOLD, 16));
		txt_password.setBounds(234, 163, 214, 19);
		contentPane.add(txt_password);
		txt_password.setColumns(10);

		JButton btn_login = new JButton("Login");
		btn_login.setBackground(Color.GREEN);
		btn_login.setForeground(Color.WHITE);
		btn_login.setFont(new Font("Arial", Font.BOLD, 13));
		btn_login.setBounds(123, 253, 101, 44);
		btn_login.addActionListener((listener) -> {
			if (controller.authorizeUser(txt_username.getText(), new String(txt_password.getPassword()))) {
				controller.closeLogin();
				controller.showMain();
			} else {
				JOptionPane.showMessageDialog(null, "Invalid username or password");
			}
		});
		contentPane.add(btn_login);

		JButton btn_signUp = new JButton("Sign Up");
		btn_signUp.setBackground(new Color(0, 191, 255));
		btn_signUp.setForeground(Color.WHITE);
		btn_signUp.setFont(new Font("Arial", Font.BOLD, 13));
		btn_signUp.addActionListener((listener) -> {
			controller.closeLogin();
			controller.showSignUp();
		});
		btn_signUp.setBounds(327, 253, 89, 44);
		contentPane.add(btn_signUp);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 89, 530, 132);
		contentPane.add(panel);

	}
}
