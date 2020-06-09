package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import iFly.Date;

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
import java.lang.FdLibm.Pow;

public class SearchPage {

	private JFrame frame;
	private JTextField depDate;
	private JTextField DesttextField;
	private JTextField passField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	
	
	
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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100,100,500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setForeground(SystemColor.controlText);
		frame.getContentPane().setForeground(SystemColor.controlText);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setLayout(null);
		frame.setFocusable(true);
		JLabel lblNewLabel = new JLabel("IFLY");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 11, 147, 87);
		frame.getContentPane().add(lblNewLabel);
		

		
		depDate = new JTextField();
		depDate.setText("dd/mm/yy");
		depDate.setHorizontalAlignment(SwingConstants.CENTER);
		depDate.setFont(new Font("Arial", Font.PLAIN, 15));
		depDate.setToolTipText("Enter Departure Date");
		depDate.setColumns(10);
		depDate.setBounds(341, 142, 122, 42);
		frame.getContentPane().add(depDate);
		
		depDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				depDate.setText("");
			}
		});
		
		DesttextField = new JTextField();
		DesttextField.setEditable(false);
		DesttextField.setToolTipText("");
		DesttextField.setBounds(341, 229, 122, 42);
		frame.getContentPane().add(DesttextField);
		DesttextField.setColumns(10);
		
		passField = new JTextField();
		passField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passField.setText("");
			}
		});
		passField.setText("33");
		passField.setToolTipText("");
		passField.setBounds(341, 315, 117, 33);
		frame.getContentPane().add(passField);
		passField.setColumns(10);
		
		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date(depDate.getText());
				String destination, temp;
				int passengers = convertString(passField.getText());
				
				destination = DesttextField.getText();
				
				//now need to send to server 
				
			}
		});
		btnNewButton.setBounds(126, 397, 129, 55);
		frame.getContentPane().add(btnNewButton);
		
		JRadioButton abrad = new JRadioButton("abroad");
		abrad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
		      DesttextField.setEditable(true);
			
			}
		});
		abrad.setBounds(139, 188, 73, 23);
		frame.getContentPane().add(abrad);
		
		JRadioButton Eirad = new JRadioButton("Eilat");
		Eirad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DesttextField.setEditable(false);
			}
		});
		Eirad.setSelected(true);
		Eirad.setBounds(139, 222, 73, 23);
		frame.getContentPane().add(Eirad);
		
		
		
		lblNewLabel_1 = new JLabel("Flying to");
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(341, 195, 97, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Departure date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(341, 106, 117, 42);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Passengers");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(341, 282, 147, 35);
		frame.getContentPane().add(lblNewLabel_3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(abrad);
		bg.add(Eirad);
		
		
		
		

	}
	public static int convertString(String str)
	{
		int size= str.length();
		int num=0;
		for(int i= 0; i<size ; i++)
		{
			num += (str.charAt(i)-'0') * Math.pow(10, size - i-1);
		}
	}
}