package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class MainPage {

	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	private JButton regBtn;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void UI_func() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 450, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton loginBtn = new JButton("Log In");
		loginBtn.setBounds(149, 213, 143, 32);
		frame.getContentPane().add(loginBtn);
		
		userField = new JTextField();
		userField.setBounds(129, 111, 180, 40);
		frame.getContentPane().add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(129, 162, 180, 40);
		frame.getContentPane().add(passwordField);
		
		regBtn = new JButton("Sign Up");
		regBtn.setBounds(149, 305, 143, 32);
		frame.getContentPane().add(regBtn);
		
		lblNewLabel = new JLabel("IFly");
		lblNewLabel.setFont(new Font("Aharoni", Font.PLAIN, 75));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(110, 23, 223, 67);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
