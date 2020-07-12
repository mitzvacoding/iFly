package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;
import iFly.DataBase;
import iFly.DataObject;
import iFly.Date;
import iFly.Server;


import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.DropMode;
import java.awt.TextArea;
import java.awt.Scrollbar;
import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.UIManager;



@SuppressWarnings("unused")
public class ResultPage 
{	
	private JFrame frame;
    private JLabel label;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private String  id;
    private int quantity;
 //   private JTable table;
	public static void ResFun() 
	{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					JTable ta = Server.requestFlightResults();
					JTable ta2 = Server.requestConnectionFlightResults();
					ResultPage window = new ResultPage(ta,ta2);
					window.frame.setVisible(true);		
			
					}
				catch (Exception e)
				{
					e.printStackTrace();
					 
				}
			}
		});
	} 
	 
	
	
	public ResultPage(JTable ta, JTable ta2) {
		initialize(ta, ta2);
	}

	
	
	 void initialize(JTable ta, JTable table) 
	 
	 {
		frame = new JFrame();  
		frame.getContentPane().setForeground(Color.GRAY);
		//frame.setBounds(600,600,700,600);    
		frame.setBounds(1200,600,900,600);      
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setFocusable(true);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
	     frame.addWindowListener(new java.awt.event.WindowAdapter() {
	          
	    	 @Override
	            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	               DataBase.writeToFile();
	            }
	        });
	     
	     
		label = new JLabel("IFly");
		label.setBounds(359, 11, 126, 76);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Aharoni", Font.PLAIN, 75));
		frame.getContentPane().add(label);
		
		
		btn1 = new JButton("Purchase");
	
		Choice choice = new Choice();
		choice.setBounds(787, 120, 44, 39);
		frame.getContentPane().add(choice);
		choice.add("1");
		choice.add("2");
		choice.add("3");
		
		btn1.setForeground(new Color(204, 0, 51));
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setBounds(765, 151, 97, 23);
		frame.getContentPane().add(btn1);

		 
		 btn2 = new JButton("Purchase");
		 btn2.setForeground(new Color(204, 0, 51));
		 btn2.setBackground(Color.WHITE);
		 btn2.setBounds(765, 181, 97, 23);
		 frame.getContentPane().add(btn2);
		 
		 btn3 = new JButton("Purchase");
		 btn3.setForeground(new Color(204, 0, 51));
		 btn3.setBackground(Color.WHITE);
		 btn3.setBounds(765, 210, 97, 23);
		 frame.getContentPane().add(btn3);
		 
		 btn4 = new JButton("Purchase");
		 btn4.setForeground(new Color(204, 0, 51));
		 btn4.setBackground(Color.WHITE);
		 btn4.setBounds(765, 240, 97, 23);
		 frame.getContentPane().add(btn4);
		 
		 JButton btn5 = new JButton("Purchase");
		 btn5.setForeground(new Color(204, 0, 51));
		 btn5.setBackground(Color.WHITE);
		 btn5.setBounds(765, 274, 97, 23);
		 frame.getContentPane().add(btn5);
		 
		JButton btn6 = new JButton("Purchase");
		btn6.setForeground(new Color(204, 0, 51));
		btn6.setBackground(Color.WHITE);
		btn6.setBounds(765, 368, 97, 23);
		frame.getContentPane().add(btn6);
			
		JButton btn7 = new JButton("Purchase");
		btn7.setForeground(new Color(204, 0, 51));
		btn7.setBackground(Color.WHITE);
		btn7.setBounds(765, 402, 97, 23);
		frame.getContentPane().add(btn7);
			
		 
		 
		 
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					id=ta.getValueAt(1,5).toString();
					quantity= Date.convertString(choice.getSelectedItem().toString());
					
					if(ta.getValueAt(1, 4)==null)
						Server.requestremoveObj(id,quantity,"Flight");
					else 
						Server.requestremoveObj(id,quantity,"InternationalFlight");
					
					JOptionPane.showMessageDialog(frame, "Purchase operation successful.");
					frame.dispose(); 
					 DataBase.writeToFile();
				}
			});
			
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					id=ta.getValueAt(2,5).toString();
					quantity= Date.convertString(choice.getSelectedItem().toString());
					
					if(ta.getValueAt(2, 4)==null)
						Server.requestremoveObj(id,quantity,"Flight");
					else 
						Server.requestremoveObj(id,quantity,"InternationalFlight");
					
					JOptionPane.showMessageDialog(frame, "Purchase operation successful.");
					frame.dispose(); 
					 DataBase.writeToFile();
				}
			});
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{  
					id=ta.getValueAt(3,5).toString();
					quantity= Date.convertString(choice.getSelectedItem().toString());
					
					if(ta.getValueAt(3, 4)==null)
						Server.requestremoveObj(id,quantity,"Flight");
					else 
						Server.requestremoveObj(id,quantity,"InternationalFlight");
					
					JOptionPane.showMessageDialog(frame, "Purchase operation successful.");
					frame.dispose(); 
					 DataBase.writeToFile();
				}
			});
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					id=ta.getValueAt(4,5).toString();
					quantity= Date.convertString(choice.getSelectedItem().toString());
					
					if(ta.getValueAt(4, 4)==null)
						Server.requestremoveObj(id,quantity,"Flight");
					else 
						Server.requestremoveObj(id,quantity,"InternationalFlight");
					
					JOptionPane.showMessageDialog(frame, "Purchase operation successful.");
					frame.dispose(); 
					 DataBase.writeToFile();
				}
			});
			
		
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					id=ta.getValueAt(5,5).toString();
					quantity= Date.convertString(choice.getSelectedItem().toString());
					if(ta.getValueAt(5, 4)==null)
						Server.requestremoveObj(id,quantity,"Flight");
					else 
						Server.requestremoveObj(id,quantity,"InternationalFlight");
					
					JOptionPane.showMessageDialog(frame, "Purchase operation successful.");
					frame.dispose(); 
					 DataBase.writeToFile();
				}
			});
			
			
			btn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					id=table.getValueAt(1,8).toString();
					quantity= Date.convertString(choice.getSelectedItem().toString());
					
					if(table.getValueAt(1, 4)==null)
						Server.requestremoveObj(id,quantity,"Flight");
					else 
						Server.requestremoveObj(id,quantity,"InternationalFlight");
					
					JOptionPane.showMessageDialog(frame, "Purchase operation successful.");
					frame.dispose(); 
					 DataBase.writeToFile();
				}
			});
			
			btn7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					id=table.getValueAt(2,8).toString();
					quantity= Date.convertString(choice.getSelectedItem().toString());
					
					if(table.getValueAt(2, 4)==null)
						Server.requestremoveObj(id,quantity,"Flight");
					else 
						Server.requestremoveObj(id,quantity,"InternationalFlight");
					
					JOptionPane.showMessageDialog(frame, "Purchase operation successful.");
					frame.dispose(); 
					DataBase.writeToFile();
				}
			});
			
			
	
			frame.getContentPane().add(ta);
			frame.getContentPane().add(table);
			
			JLabel lblNewLabel = new JLabel("Direct Flights");
			lblNewLabel.setForeground(SystemColor.textHighlight);
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
			lblNewLabel.setBounds(46, 98, 375, 20);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblConnectionFlights = new JLabel("Connection Flights");
			lblConnectionFlights.setForeground(SystemColor.textHighlight);
			lblConnectionFlights.setFont(new Font("Arial", Font.PLAIN, 20));
			lblConnectionFlights.setBounds(46, 315, 375, 20);
			frame.getContentPane().add(lblConnectionFlights);

	  
			  for(int i=1 ; i<6 ; i++)
			  {
				  if(ta.getValueAt(i, 0)==null) 
				  {
					  switch(i)
					  {
						  case 1:
							  btn1.setEnabled(false);
							  break;
							  
						 case 2:
							 btn2.setEnabled(false);				  
							 	break;
						 case 3:
							 btn3.setEnabled(false);
							  break;
					 	 case 4:
					 		 btn4.setEnabled(false);
							  break;
						 case 5:
							 btn5.setEnabled(false);
							  break;  		  
					  }					 
				  }
			  }
			  
			  for(int i =1; i<3 ; i++)
			  {
				  if(table.getValueAt(i, 0)==null)
					  switch(i)
					  {
						  case 1:
							  btn6.setEnabled(false);
							  break;
							  
						 case 2:
							 btn7.setEnabled(false);				  
							 	break;	  
					  }				  
			  }
	 
	 }
 }

