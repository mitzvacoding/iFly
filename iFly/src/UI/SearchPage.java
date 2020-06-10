package UI;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import iFly.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;

public class SearchPage
{

	private JFrame frame;
	private JTextField depDate;
	private JTextField DesttextField;
	private JTextField passField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField ReDate;
	
	
	
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
		
		DesttextField = new JTextField();
		DesttextField.setHorizontalAlignment(SwingConstants.CENTER);
		DesttextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DesttextField.setText("Enter City");
		DesttextField.setBounds(364, 217, 122, 42);
		DesttextField.setEditable(false);
		DesttextField.setToolTipText("");
		frame.getContentPane().add(DesttextField);
		DesttextField.setColumns(10);

		DesttextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				DesttextField.setText("");
				
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
		
		JRadioButton Eirad = new JRadioButton("Eilat");
		Eirad.setBackground(new Color(34, 139, 34));
		panel.add(Eirad);
		ButtonGroup bg = new ButtonGroup();
		bg.add(Eirad);
		Eirad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DesttextField.setEditable(false);
			}
		});
		Eirad.setSelected(true);
		
		JRadioButton abrad = new JRadioButton("abroad");
		abrad.setBackground(new Color(124, 252, 0));
		panel.add(abrad);
	 	bg.add(abrad);
		abrad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
		      DesttextField.setEditable(true);
			
			}
		});

		ReDate = new JTextField();
		ReDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ReDate.setHorizontalAlignment(SwingConstants.CENTER);
		ReDate.setText("02/06/2020");
		ReDate.setToolTipText("");
		ReDate.setEditable(false);
		ReDate.setColumns(10);
		ReDate.setBounds(204, 217, 122, 42);
		frame.getContentPane().add(ReDate);
		ReDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ReDate.setText("");
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
		JRadioButton Onerad = new JRadioButton("One way");
		Onerad.setSelected(true);
		Onerad.setBackground(new Color(255, 153, 0));
		panel_1.add(Onerad);
		bg1.add(Onerad);
		JRadioButton Rourad = new JRadioButton("Roundtrip");
		Rourad.setBackground(new Color(255, 255, 51));
		panel_1.add(Rourad);
		bg1.add(Rourad);
		
		JButton SearchBtn = new JButton(" Search Flights");
		SearchBtn.setBounds(510, 280, 147, 42);
		frame.getContentPane().add(SearchBtn);
		
	
		Onerad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReDate.setEditable(false);
			}
		});
		Rourad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReDate.setEditable(true);
			}
		});
		
		
		
		
		
	}
}