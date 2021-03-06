package UI;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import iFly.DataBase;
import iFly.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import iFly.Date;
import iFly.Server;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Choice;
import java.awt.Canvas;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
//import javax.swing.JScrollBar;
//import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;

@SuppressWarnings("unused")
public class SearchPage
{

	private JFrame frame;
	private JTextField depDate;
	private JTextField destField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField retDateField;
	private JTextField originField;
	
	public static void SpFun() {   
		EventQueue.invokeLater(new Runnable() {
			public void run() {  
				try {
					SearchPage window = new SearchPage();
					window.frame.setVisible(true);
				} catch (Exception e) { 
					e.printStackTrace();
				}}});
	}  
	
	public SearchPage() 
	{
		initialize();
	}
	 
	
	
	
	
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(700,400,700, 400);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setForeground(SystemColor.controlText);
		frame.getContentPane().setForeground(SystemColor.controlText);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setFocusable(true);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("IFLY");
		lblNewLabel.setBounds(260, 11, 147, 87);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		frame.setLocationRelativeTo(null);

	     frame.addWindowListener(new java.awt.event.WindowAdapter() {
	          
	    	 @Override
	            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	               DataBase.writeToFile(); }});
	   
		depDate = new JTextField();
		depDate.setBounds(200, 222, 122, 42);
		depDate.setText("01/06/2020");
		depDate.setHorizontalAlignment(SwingConstants.CENTER);
		depDate.setFont(new Font("Arial", Font.PLAIN, 15));
		depDate.setToolTipText("Enter Departure Date");
		depDate.setColumns(10);
		frame.getContentPane().add(depDate);
		
		depDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				depDate.setText("");
			}
		});
		
		destField = new JTextField();
		destField.setBounds(324, 134, 136, 42);
		destField.setHorizontalAlignment(SwingConstants.CENTER);
		destField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		destField.setText("ELT");
		destField.setEditable(false);
		destField.setToolTipText("");
		frame.getContentPane().add(destField);
		destField.setColumns(10);

		destField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				destField.setText("");
				
			}
		});
			
		lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setBounds(332, 109, 97, 35);
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Departure date");
		lblNewLabel_2.setBounds(200, 192, 117, 42);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_2);
		
				
		JPanel panel = new JPanel();
		panel.setBounds(493, 165, 136, 33);
		panel.setBorder(null);
		frame.getContentPane().add(panel);
		
		JRadioButton eiRad = new JRadioButton("Local");
		eiRad.setBackground(new Color(34, 139, 34));
		panel.add(eiRad);
		ButtonGroup bg = new ButtonGroup();
		bg.add(eiRad);
		eiRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				destField.setEditable(false);
			}
		});
		eiRad.setSelected(true);

		JRadioButton abRad = new JRadioButton("Abroad");
		abRad.setBackground(new Color(124, 252, 0));
		panel.add(abRad);
	 	bg.add(abRad);
		abRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
		      destField.setEditable(true);
			}
		});

		retDateField = new JTextField();
		retDateField.setBounds(326, 222, 122, 42);
		retDateField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		retDateField.setHorizontalAlignment(SwingConstants.CENTER);
		retDateField.setText("02/06/2020");
		retDateField.setToolTipText("");
		retDateField.setEditable(false);
		retDateField.setColumns(10);
		frame.getContentPane().add(retDateField);
		retDateField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//retDateField.setText("");
				
				
			}
		});
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Return Date");
		lblNewLabel_4.setBounds(324, 187, 136, 55);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(470, 209, 177, 33);
		frame.getContentPane().add(panel_1);
		
		ButtonGroup bg1 = new ButtonGroup();		
		JRadioButton oneRad = new JRadioButton("One way");
		oneRad.setSelected(true);
		oneRad.setBackground(new Color(255, 153, 0));
		panel_1.add(oneRad);  
		bg1.add(oneRad);
		JRadioButton rouRad = new JRadioButton("Roundtrip");
		rouRad.setBackground(new Color(255, 255, 51));
		panel_1.add(rouRad);
		bg1.add(rouRad);
		
		JButton searchBtn = new JButton(" Search Flights");
		searchBtn.setBounds(260, 310, 147, 42);
		frame.getContentPane().add(searchBtn);
		
		originField = new JTextField();
		originField.setToolTipText("");
		originField.setText("TLV");
		originField.setHorizontalAlignment(SwingConstants.CENTER);
		originField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		originField.setEditable(true);
		originField.setColumns(10);
		originField.setBounds(186, 134, 136, 42);
		frame.getContentPane().add(originField);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFrom.setBackground(Color.RED);
		lblFrom.setBounds(196, 109, 97, 35);
		frame.getContentPane().add(lblFrom);
		
	
		oneRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retDateField.setEditable(false);
			}
		});
		rouRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retDateField.setEditable(true);
			}
		});
		
		
		searchBtn.addActionListener(new ActionListener() {    // SEARCH Button
			public void actionPerformed(ActionEvent e)
			{
				String depurtureDate = depDate.getText();
				String returnDate= "";
				String destination = null;
				String origin = originField.getText();
				
				
				if(eiRad.isSelected())
				{
					if(origin.equals("TLV")) 
						destination = "ELT";
					else
						destination = "TLV";
				}
				else 
		 			destination = destField.getText();
				
				if(rouRad.isSelected())
					returnDate = retDateField.getText();
				
					  			 
				Server.requestSearchFlight(depurtureDate,returnDate,origin, destination);  //now need to send to server
				
				frame.dispose();
				ResultPage.ResFun();	
			
			}
		});
		
		
	}
}




