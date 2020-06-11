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



public class ResultPage 
{	
	private JFrame frame;
    private JLabel label;
    private JTable ta;
    private JButton btnPurchase;
    private JButton button;
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;
    private JButton button_5;
    private JButton button_6;
    private JButton button_7;
    
    
	public static void ResFun() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultPage window = new ResultPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
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
		ta.setBounds(0, 263, 556, 300);
		ta.setBackground(new Color(255, 250, 240));
		ta.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(ta);
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.setForeground(new Color(204, 0, 51));
		btnPurchase.setBackground(new Color(255, 255, 255));
		btnPurchase.setBounds(566, 300, 87, 23);
		frame.getContentPane().add(btnPurchase);
		//ta.setIntercellSpacing(new  Dimension(5,5));
		 ta.setRowHeight(30);
		 
		 button = new JButton("Purchase");
		 button.setForeground(new Color(204, 0, 51));
		 button.setBackground(Color.WHITE);
		 button.setBounds(566, 326, 87, 23);
		 frame.getContentPane().add(button);
		 
		 button_1 = new JButton("Purchase");
		 button_1.setForeground(new Color(204, 0, 51));
		 button_1.setBackground(Color.WHITE);
		 button_1.setBounds(566, 356, 87, 23);
		 frame.getContentPane().add(button_1);
		 
		 button_2 = new JButton("Purchase");
		 button_2.setForeground(new Color(204, 0, 51));
		 button_2.setBackground(Color.WHITE);
		 button_2.setBounds(566, 385, 87, 23);
		 frame.getContentPane().add(button_2);
		 
		 button_3 = new JButton("Purchase");
		 button_3.setForeground(new Color(204, 0, 51));
		 button_3.setBackground(Color.WHITE);
		 button_3.setBounds(566, 416, 87, 23);
		 frame.getContentPane().add(button_3);
		 
		 button_4 = new JButton("Purchase");
		 button_4.setForeground(new Color(204, 0, 51));
		 button_4.setBackground(Color.WHITE);
		 button_4.setBounds(566, 447, 87, 23);
		 frame.getContentPane().add(button_4);
		 
		 button_5 = new JButton("Purchase");
		 button_5.setForeground(new Color(204, 0, 51));
		 button_5.setBackground(Color.WHITE);
		 button_5.setBounds(566, 475, 87, 23);
		 frame.getContentPane().add(button_5);
		 
		 button_6 = new JButton("Purchase");
		 button_6.setForeground(new Color(204, 0, 51));
		 button_6.setBackground(Color.WHITE);
		 button_6.setBounds(566, 507, 87, 23);
		 frame.getContentPane().add(button_6);
		 
		 button_7 = new JButton("Purchase");
		 button_7.setForeground(new Color(204, 0, 51));
		 button_7.setBackground(Color.WHITE);
		 button_7.setBounds(566, 540, 87, 23);
		 frame.getContentPane().add(button_7);
		ta.setValueAt("Dep Date", 0, 0);
	    ta.setValueAt("Land Date",0, 1);	
	    ta.setValueAt("vendor",0,2);
	    ta.setValueAt("Air port", 0, 3);
	    ta.setValueAt("Flight ID",0,4);
	    ta.setValueAt("Price", 0,5);
	    
	    
	    
	    
	 }
}
