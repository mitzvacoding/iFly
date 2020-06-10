package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import iFly.Server;

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
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

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
		NameField.setBounds(172, 162, 137, 35);
		frame.getContentPane().add(NameField);
		NameField.setColumns(10);
		
		EmailField_1 = new JTextField();
		EmailField_1.setToolTipText("");
		EmailField_1.setBounds(172, 225, 137, 35);
		frame.getContentPane().add(EmailField_1);
		EmailField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setToolTipText("enter password");
		passwordField.setBounds(172, 283, 137, 35);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

				String name=NameField.getText();
				String email=EmailField_1.getText();
				String password=passwordField.getText();
				frame.setVisible(false);
				SearchPage.SpFun();
			 	Server.requestSignUpCustomer(name, email,password);		
				
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(186, 348, 102, 35);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Enter Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(172, 128, 92, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel(" Enter email ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(172, 196, 92, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Enter password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(172, 259, 147, 29);
		frame.getContentPane().add(lblNewLabel_3);
		frame.setBounds(100,100,500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
