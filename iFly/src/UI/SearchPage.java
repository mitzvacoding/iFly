package UI;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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

public class SearchPage
{

	private JFrame frame;
	private JTextField depDate;
	private JTextField destField;
	private JTextField passField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField retDateField;
	private JButton SearchBtn;
	private  static Integer abroadFlight=0;
	private  static Integer roundTrip=0;
	
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
		
		depDate = new JTextField();
		depDate.setBounds(44, 216, 122, 42);
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
		destField.setHorizontalAlignment(SwingConstants.CENTER);
		destField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		destField.setText("Enter City");
		destField.setBounds(364, 217, 122, 42);
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
		
		passField = new JTextField();
		passField.setBounds(520, 222, 50, 33);
		passField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passField.setText("");
			}
		});
		passField.setText("1-9");
		passField.setToolTipText("");
		frame.getContentPane().add(passField);
		passField.setColumns(10);
			
		lblNewLabel_1 = new JLabel("Flying to");
		lblNewLabel_1.setBounds(363, 183, 97, 35);
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Departure date");
		lblNewLabel_2.setBounds(44, 176, 117, 42);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Passengers");
		lblNewLabel_3.setBounds(520, 183, 147, 35);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_3);
		
				
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(299, 121, 136, 33);
		frame.getContentPane().add(panel);
		
		JRadioButton eiRad = new JRadioButton("Eilat");
		eiRad.setBackground(new Color(34, 139, 34));
		panel.add(eiRad);
		ButtonGroup bg = new ButtonGroup();
		bg.add(eiRad);
		eiRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				destField.setEditable(false);
				abroadFlight=0;
			}
		});
		eiRad.setSelected(true);

		SearchBtn = new JButton("Search");		
		SearchBtn.setBounds(126, 397, 129, 55);
		frame.getContentPane().add(SearchBtn);

		JRadioButton abRad = new JRadioButton("abroad");
		abRad.setBackground(new Color(124, 252, 0));
		panel.add(abRad);
	 	bg.add(abRad);
		abRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
		      destField.setEditable(true);
		      abroadFlight=1;
			}
		});

		retDateField = new JTextField();
		retDateField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		retDateField.setHorizontalAlignment(SwingConstants.CENTER);
		retDateField.setText("02/06/2020");
		retDateField.setToolTipText("");
		retDateField.setEditable(false);
		retDateField.setColumns(10);
		retDateField.setBounds(204, 217, 122, 42);
		frame.getContentPane().add(retDateField);
		retDateField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				retDateField.setText("");
				
				
			}
		});
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Return Date");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(204, 174, 136, 55);
		frame.getContentPane().add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(43, 121, 177, 33);
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
		searchBtn.setBounds(510, 280, 147, 42);
		frame.getContentPane().add(searchBtn);
		
	
		oneRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retDateField.setEditable(false);
			}
		});
		rouRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retDateField.setEditable(true);
				roundTrip=1;
			}
		});
		
		
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int passengers;
				Date returnDate=null;
				String destination = null;
				Date date = new Date(depDate.getText());
				
				passengers = Date.convertString(passField.getText());
				
				if(eiRad.isSelected())
					destination= "Eilat";
				else 
					destination = destField.getText();
				
				if(rouRad.isSelected())
					returnDate=new Date( retDateField.getText());
				
				frame.setVisible(false);
				ResultPage.ResFun();	
				//now need to send to server
				
				Server.requestSearchFlight(date,returnDate, destination, passengers,abroadFlight,roundTrip);
				
			}
		});
		
		
	}


}




