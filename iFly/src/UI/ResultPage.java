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



public class ResultPage {

	
	private JFrame frame;
    private JTable t;
    private JLabel label;
	public static void ResFun() {
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

	 void initialize() {
		frame = new JFrame();
		frame.setBounds(600,600,600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().add(t);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("IFly");
		label.setBounds(247, 11, 126, 76);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Aharoni", Font.PLAIN, 75));
		frame.getContentPane().add(label);
		 String[] name= {"qq","ww"};
		   Object[] [] o= { {"ee", "rr " },{"ggg ","uu "}};  
	    JTable t=new JTable(o,name);
	    JScrollPane sc= new JScrollPane ();
	   frame.getContentPane().add(sc);
	    sc.setViewportView(t);
	   
	    
	    
	    
	    
	    
	    
	    
	    
	}
}
