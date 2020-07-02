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
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;

import iFly.DataBase;

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



public class ResultPage 
{	
	private JFrame frame;
    private JLabel label;
    private JTable ta;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    
    
	public static void ResFun() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ResultPage window = new ResultPage();
					window.frame.setVisible(true);
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
		
		
		label = new JLabel("IFly");
		label.setBounds(247, 11, 126, 76);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Aharoni", Font.PLAIN, 75));
		frame.getContentPane().add(label);
		
		
		ta = new JTable(10,6);
		ta.setColumnSelectionAllowed(true);
		ta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ta.setBounds(0, 185, 556, 300);
		ta.setBackground(new Color(255, 250, 240));
		ta.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(ta);
		
		
		
		// ADD value for Jtable;
		
		/*ta.setValueAt(DataBase.res.get(1).getDepartureDate(),1,0);
		ta.setValueAt(DataBase.res.get(1).getLandingDate(),1,1);
		ta.setValueAt(DataBase.res.get(1).getLandingAirport(),1,2);
		ta.setValueAt(DataBase.res.get(1).getVendor(),1,3);
		ta.setValueAt(DataBase.res.get(1).getPrice(),1,4);
		ta.setValueAt(DataBase.res.get(1).getFlightId(),1,5);
		*/
		
		ta.setValueAt(DataBase.big.get("Flight").get(1),1,3);
			

		
		btn1 = new JButton("Purchase");
		btn1.setForeground(new Color(204, 0, 51));
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setBounds(563, 222, 87, 23);
		frame.getContentPane().add(btn1);
		ta.setIntercellSpacing(new  Dimension(5,5));
		 ta.setRowHeight(30);
		 
		 btn2 = new JButton("Purchase");
		 btn2.setForeground(new Color(204, 0, 51));
		 btn2.setBackground(Color.WHITE);
		 btn2.setBounds(563, 248, 87, 23);
		 frame.getContentPane().add(btn2);
		 
		 btn3 = new JButton("Purchase");
		 btn3.setForeground(new Color(204, 0, 51));
		 btn3.setBackground(Color.WHITE);
		 btn3.setBounds(563, 278, 87, 23);
		 frame.getContentPane().add(btn3);
		 
		 btn4 = new JButton("Purchase");
		 btn4.setForeground(new Color(204, 0, 51));
		 btn4.setBackground(Color.WHITE);
		 btn4.setBounds(563, 307, 87, 23);
		 frame.getContentPane().add(btn4);
		 
		 btn5 = new JButton("Purchase");
		 btn5.setForeground(new Color(204, 0, 51));
		 btn5.setBackground(Color.WHITE);
		 btn5.setBounds(563, 338, 87, 23);
		 frame.getContentPane().add(btn5);
		 
		 btn6 = new JButton("Purchase");
		 btn6.setForeground(new Color(204, 0, 51));
		 btn6.setBackground(Color.WHITE);
		 btn6.setBounds(563, 369, 87, 23);
		 frame.getContentPane().add(btn6);
		 
		 btn7 = new JButton("Purchase");
		 btn7.setForeground(new Color(204, 0, 51));
		 btn7.setBackground(Color.WHITE);
		 btn7.setBounds(563, 397, 87, 23);
		 frame.getContentPane().add(btn7);
		 
		 btn8 = new JButton("Purchase");
		 btn8.setForeground(new Color(204, 0, 51));
		 btn8.setBackground(Color.WHITE);
		 btn8.setBounds(563, 429, 87, 23);
		 frame.getContentPane().add(btn8);
		 
		 btn9 = new JButton("Purchase");
	
		 
		 
		 btn9.setForeground(new Color(204, 0, 51));
		 btn9.setBackground(Color.WHITE);
		 btn9.setBounds(563, 462, 87, 23);
		 frame.getContentPane().add(btn9);
		ta.setValueAt("Dep Date", 0, 0);
	    ta.setValueAt("Land Date",0, 1);	
	    ta.setValueAt("vendor",0,2);
	    ta.setValueAt("Air port", 0, 3);
	    ta.setValueAt("Flight ID",0,4);
	    ta.setValueAt("Price", 0,5);
	    
	  
	  
	    
	 }
}
