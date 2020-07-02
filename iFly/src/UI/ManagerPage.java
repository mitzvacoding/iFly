package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import iFly.Customer;
import iFly.Date;
import iFly.Flight;
import iFly.Server;
import iFly.User;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

public class ManagerPage 
{

	private JFrame frame;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt6;
	private JTextField txt8;
	private JTextField txt9;
	private JTextField txt5;
	private JTextField txt7;

	/**
	 * Launch the application.
	 */
	public static void ManPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerPage window = new ManagerPage();
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
	public ManagerPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();  
		frame.setBounds(600,600,600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setFocusable(true);
		frame.getContentPane().setLayout(null);
		
	
		

		JLabel label = new JLabel("IFly");
		label.setBounds(224, 11, 126, 76);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Aharoni", Font.PLAIN, 75));
		frame.getContentPane().add(label);
		
		JComboBox UserBox = new JComboBox();
		UserBox.setBounds(25, 363, 199, 28);
		frame.getContentPane().add(UserBox);
		
		JComboBox FlightBox = new JComboBox();
		FlightBox.setBounds(275, 366, 262, 25);
		frame.getContentPane().add(FlightBox);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setBounds(25, 131, 77, 28);
		frame.getContentPane().add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setEditable(false);
		txt2.setColumns(10);
		txt2.setBounds(112, 131, 77, 28);
		frame.getContentPane().add(txt2);
		
		txt3 = new JTextField();
		txt3.setEditable(false);
		txt3.setColumns(10);
		txt3.setBounds(201, 131, 77, 28);
		frame.getContentPane().add(txt3);
		
		txt4 = new JTextField();
		txt4.setEditable(false);
		txt4.setColumns(10);
		txt4.setBounds(25, 181, 77, 28);
		frame.getContentPane().add(txt4);
		
		txt6 = new JTextField();
		txt6.setEditable(false);
		txt6.setColumns(10);
		txt6.setBounds(201, 181, 77, 28);
		frame.getContentPane().add(txt6);
		
		txt8 = new JTextField();
		txt8.setEditable(true);
		txt8.setColumns(10);
		txt8.setBounds(67, 269, 112, 28);
		frame.getContentPane().add(txt8);
		
		txt9 = new JTextField();
		txt9.setEditable(true);
		txt9.setColumns(10);
		txt9.setBounds(224, 269, 110, 28);
		frame.getContentPane().add(txt9);
		
		JButton Addbtn = new JButton("ADD");
		Addbtn.setEnabled(false);
		Addbtn.setForeground(Color.GREEN);
		Addbtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Addbtn.setBounds(147, 308, 110, 44);
		frame.getContentPane().add(Addbtn);
		
		JButton Delbtn = new JButton("DELETE");
	
		Delbtn.setForeground(Color.RED);
		Delbtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Delbtn.setBounds(347, 308, 110, 44);
		frame.getContentPane().add(Delbtn);
		
		JLabel lblNewLabel = new JLabel("Dep Date");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(txt1);
		lblNewLabel.setBounds(25, 117, 77, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblLandDate = new JLabel("Land Date");
		lblLandDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblLandDate.setBounds(112, 117, 77, 14);
		frame.getContentPane().add(lblLandDate);
		
		JLabel lblVendor = new JLabel("Land Airport");
		lblVendor.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendor.setBounds(201, 117, 77, 14);
		frame.getContentPane().add(lblVendor);
		
		JLabel lblVendor_1 = new JLabel("Vendor");
		lblVendor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendor_1.setBounds(25, 163, 77, 14);
		frame.getContentPane().add(lblVendor_1);
		
		JLabel lblQuantity = new JLabel("quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(201, 163, 77, 14);
		frame.getContentPane().add(lblQuantity);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(54, 252, 77, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(214, 253, 77, 14);
		frame.getContentPane().add(lblEmail);
		
		JRadioButton usrd = new JRadioButton("User");
		usrd.setBackground(new Color(255, 140, 0));
		usrd.setBounds(499, 224, 67, 23);
		frame.getContentPane().add(usrd);
		
		JRadioButton Flird = new JRadioButton("Flight");
		Flird.setBackground(new Color(0, 0, 255));
		Flird.setBounds(499, 184, 67, 23);
		frame.getContentPane().add(Flird);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(491, 180, 85, 76);
		frame.getContentPane().add(panel);
		
		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(usrd);
		bg.add(Flird);
		
		usrd.setSelected(true);
		
		txt5 = new JTextField();
		txt5.setEditable(false);
		txt5.setColumns(10); 
		txt5.setBounds(112, 181, 77, 28);
		frame.getContentPane().add(txt5);
		
		txt7 = new JTextField();
		txt7.setEditable(false);
		txt7.setColumns(10);
		txt7.setBounds(309, 163, 54, 28);
		frame.getContentPane().add(txt7);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(102, 163, 77, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblFlightId = new JLabel("Flight ID");
		lblFlightId.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightId.setBounds(298, 149, 77, 14);
		frame.getContentPane().add(lblFlightId);
		
		// user radio button 
		usrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				txt1.setEditable(false);
				txt2.setEditable(false);
				txt3.setEditable(false);
				txt4.setEditable(false);
				txt5.setEditable(false);
				txt6.setEditable(false);
				txt7.setEditable(false);
				txt8.setEditable(true);
				txt9.setEditable(true);
				Addbtn.setEnabled(false);
			}
		});
			
		// flight radio button
		Flird.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) 
				{
					
					Addbtn.setEnabled(true);	
					txt1.setEditable(true);
					txt2.setEditable(true);
					txt3.setEditable(true);
					txt4.setEditable(true);
					txt5.setEditable(true);					
					txt6.setEditable(true);
					txt7.setEditable(true);
					txt8.setEditable(false);
					txt9.setEditable(false);
				}
			});
			
			
		
			Addbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
			      if(Flird.isSelected())	
			      {
			    	  Date DepDatenew=new Date(txt1.getText());
			    	  Date LandDate=new Date(txt2.getText());
			    	  String LandAirport= txt3.getText(); 
			    	  String vendor= txt4.getText();
			    	  String price= txt5.getText();
			    	  String quantity= txt6.getText();
			    	  String flightId= txt7.getText();
			    	  Object f=new Flight(DepDatenew,LandDate,LandAirport,vendor,price,quantity,flightId);
			    	  Server.requestAddObject("Flight",f);  
			      }
			      else //user radio selected
			      {
			    	  String name=txt8.getText();
			    	  String email=txt9.getText();
			    	  String password="11111";
			    	  
			    	  Object c=new Customer(name,email,password);
			    	  Server.requestAddObject("Customer",c);  
			      }
					
					
				}
			});
			
			Delbtn.addActionListener(new ActionListener() {    //DELETE button
				public void actionPerformed(ActionEvent e) 
				{
					String mapName;
					if(usrd.isSelected())
					{
						mapName="Customer";
						String email=txt7.getText();
						Server.requestremoveObj(email, mapName);
					}
					else
					{
						mapName="Flight";
						String flightId=txt7.getText();
							Server.requestremoveObj(flightId,mapName);
				
					}
					
					
					
					
					
				}
			});
			
			
			
			
			
			
			
	}
}
				
			
			
		

