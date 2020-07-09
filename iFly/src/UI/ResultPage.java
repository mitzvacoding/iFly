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



@SuppressWarnings("unused")
public class ResultPage 
{	
	private JFrame frame;
    private JLabel label;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    
    
	public static void ResFun() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ResultPage window = new ResultPage();
					window.frame.setVisible(true);
					window.frame.getContentPane().add(Server.requestFlightResults());
				}
				catch (Exception e)
				{
					e.printStackTrace();
					 
				}
			}
		});
	}
	 
	public ResultPage() {
		initialize();
	}

	
	
	 void initialize() 
	 
	 {
		frame = new JFrame();  
		frame.setBounds(600,600,700,600);
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
		label.setBounds(247, 11, 126, 76);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Aharoni", Font.PLAIN, 75));
		frame.getContentPane().add(label);
		
		
		btn1 = new JButton("Purchase");
	
		
		btn1.setForeground(new Color(204, 0, 51));
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setBounds(566, 251, 97, 23);
		frame.getContentPane().add(btn1);

		 
		 btn2 = new JButton("Purchase");
		 btn2.setForeground(new Color(204, 0, 51));
		 btn2.setBackground(Color.WHITE);
		 btn2.setBounds(566, 281, 97, 23);
		 frame.getContentPane().add(btn2);
		 
		 btn3 = new JButton("Purchase");
		 btn3.setForeground(new Color(204, 0, 51));
		 btn3.setBackground(Color.WHITE);
		 btn3.setBounds(566, 310, 97, 23);
		 frame.getContentPane().add(btn3);
		 
		 btn4 = new JButton("Purchase");
		 btn4.setForeground(new Color(204, 0, 51));
		 btn4.setBackground(Color.WHITE);
		 btn4.setBounds(566, 340, 97, 23);
		 frame.getContentPane().add(btn4);
		 
		 JButton btn5 = new JButton("Purchase");
		 btn5.setForeground(new Color(204, 0, 51));
		 btn5.setBackground(Color.WHITE);
		 btn5.setBounds(566, 374, 97, 23);
		 frame.getContentPane().add(btn5);
		 
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					
					JOptionPane.showMessageDialog(frame, "Purchase operation successful.");
					frame.setVisible(false);
					
				}
			});
			
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
				
					JOptionPane.showMessageDialog(frame, "Purchase operation successful.");
					frame.setVisible(false);
					
				}
			});
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{  
				
					JOptionPane.showMessageDialog(frame, "Purchase operation successful.");
					frame.setVisible(false);
					
				}
			});
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
				
					JOptionPane.showMessageDialog(frame, "Purchase operation successful.");
					frame.setVisible(false);
					
				}
			});
			
			
			
			
	    
		 
		 
	  
	  
	    
	 }
}
