package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Window.Type;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistarPage {

	private JFrame frame;
	private JTextField NameField;
	private JTextField EmailField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void RpFun() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistarPage window = new RegistarPage();
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
	public RegistarPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(SystemColor.controlText);
		frame.getContentPane().setForeground(SystemColor.controlText);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IFLY");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(172, 11, 147, 87);
		frame.getContentPane().add(lblNewLabel);
		
		NameField = new JTextField();
		NameField.setToolTipText("Enter name");
		NameField.setBounds(172, 148, 137, 35);
		frame.getContentPane().add(NameField);
		NameField.setColumns(10);
		
		EmailField_1 = new JTextField();
		EmailField_1.setToolTipText(" Enter email ");
		EmailField_1.setBounds(172, 211, 137, 35);
		frame.getContentPane().add(EmailField_1);
		EmailField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setToolTipText("enter password");
		passwordField.setBounds(172, 268, 137, 35);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(190, 345, 102, 35);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100,100,500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
