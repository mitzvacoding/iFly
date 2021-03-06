package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import iFly.Connected;
import iFly.DataBase;
import iFly.Server;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "deprecation" })
public class MainPage  extends Observable 
{


	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	private JButton regBtn;
	private JLabel lblNewLabel;

	
	public static void MpFun()  
	{
		
		 
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
	
	
	public MainPage() 
	{
		initialize();
	}

	
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 450, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
	     frame.addWindowListener(new java.awt.event.WindowAdapter() {
	          
	    	 @Override
	            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	               DataBase.writeToFile();
	            }
	        });
	    
		
	   //Log-in button
		JButton loginBtn = new JButton("Log In");
		loginBtn.addActionListener(new ActionListener() {				
			
			public void actionPerformed(ActionEvent e) 
			{
				MainPage m=new MainPage();  					// add observer c to Observable;
				Connected c=new Connected();
				m.addObserver(c);
				
				
				
				String Estr=userField.getText();//email 
				String Pstr=passwordField.getText();///password
				
				if(Pstr.charAt(0)=='*')
				{
					if(Server.requestSignInManager(Estr,Pstr)) 			// check if manager is connected;
					{
						//frame.setVisible(false); 
						frame.dispose(); 
						c.update(m, Pstr); 
						setChanged();
			    		notifyObservers();
					}				

					else         // ERROR_MESSAGE
					{
						JOptionPane.showMessageDialog(frame,
							    "One of the details you entered is incorrect",
							    "Login error",
							    JOptionPane.ERROR_MESSAGE);	
					} 
				}
				
	  			else  // check if user exists;
				{
  				 if( Server.requestSignInCustomer(Estr,Pstr))
  				 {
  					//frame.setVisible(false);
 					frame.dispose();
  					 SearchPage.SpFun(); 
	  				 }
  				 
  				 
					else         // ERROR_MESSAGE
					{
						JOptionPane.showMessageDialog(frame,
							    "One of the details you entered is incorrect",
							    "Login error",
							    JOptionPane.ERROR_MESSAGE);	
					} 
				   
				} 
				
			}
		});
	
		
		
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
		
		
		
		regBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) //sign up button function
			{
				RegistarPage.RpFun();
				frame.dispose();
				
			}
		});
		
		
		
		
		
		
		regBtn.setBounds(149, 305, 143, 32);
		frame.getContentPane().add(regBtn);
		
		lblNewLabel = new JLabel("IFly");
		lblNewLabel.setFont(new Font("Aharoni", Font.PLAIN, 75));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(110, 23, 223, 67);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(25, 115, 95, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblEnterPassword = new JLabel("Enter password:");
		lblEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterPassword.setBounds(25, 165, 110, 32);
		frame.getContentPane().add(lblEnterPassword);
		
	}
}
