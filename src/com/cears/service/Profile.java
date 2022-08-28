package com.cears.service;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Profile extends JFrame {

	private JPanel contentPane;
	//private JTextField PtextField;
	private JTextField EtextField;
	private JTextField PtextField;
	private JTextField GtextField;
	private JTextField AtextField;
	private JTextField DtextField;
	private JTextField AadhartextField;

	private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/vmsdatabase";
    private static String user = "root";
    private static String pwd = "root2004";
    
    private JTextField VCtextField;
    private JTextField DosetextField;
    private JTextField VCentretextField;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit toolkit=getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		
		JPanel BottomPanel = new JPanel();
		BottomPanel.setBackground(new Color(255, 204, 204));
		BottomPanel.setBounds(0, 112, 664, 723);
		contentPane.add(BottomPanel);
		BottomPanel.setLayout(null);
		
		JLabel Alabel = new JLabel("EmailId");
		Alabel.setHorizontalAlignment(SwingConstants.RIGHT);
		Alabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Alabel.setBounds(143, 45, 81, 26);
		BottomPanel.add(Alabel);
		
		JLabel Dlabel = new JLabel("Phone No");
		Dlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		Dlabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dlabel.setBounds(125, 95, 99, 26);
		BottomPanel.add(Dlabel);
		
		JLabel D1label = new JLabel("Gender");
		D1label.setHorizontalAlignment(SwingConstants.RIGHT);
		D1label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		D1label.setBounds(151, 145, 73, 26);
		BottomPanel.add(D1label);
		
		JLabel D2label = new JLabel("Address");
		D2label.setHorizontalAlignment(SwingConstants.RIGHT);
		D2label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		D2label.setBounds(143, 197, 81, 26);
		BottomPanel.add(D2label);
		
		EtextField = new JTextField();
		EtextField.setBounds(234, 38, 209, 33);
		BottomPanel.add(EtextField);
		EtextField.setColumns(10);
		
		PtextField = new JTextField();
		PtextField.setColumns(10);
		PtextField.setBounds(234, 88, 209, 33);
		BottomPanel.add(PtextField);
		
		GtextField = new JTextField();
		GtextField.setColumns(10);
		GtextField.setBounds(234, 138, 209, 33);
		BottomPanel.add(GtextField);
		
		AtextField = new JTextField();
		AtextField.setColumns(10);
		AtextField.setBounds(234, 190, 209, 33);
		BottomPanel.add(AtextField);
		
		JLabel VNlabel = new JLabel("Date of Birth");
		VNlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		VNlabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		VNlabel.setBounds(101, 250, 123, 26);
		BottomPanel.add(VNlabel);
		
		DtextField = new JTextField();
		DtextField.setColumns(10);
		DtextField.setBounds(234, 243, 209, 33);
		BottomPanel.add(DtextField);
		
		JLabel Aadharlabel = new JLabel("Aadhar No");
		Aadharlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		Aadharlabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Aadharlabel.setBounds(94, 304, 130, 26);
		BottomPanel.add(Aadharlabel);
		
		AadhartextField = new JTextField();
		AadhartextField.setColumns(10);
		AadhartextField.setBounds(234, 297, 209, 33);
		BottomPanel.add(AadhartextField);
		
		LoginPage loginPage=new LoginPage();
		
		JButton EButton = new JButton("Exit");
		EButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashBoard db = new DashBoard();
				db.setVisible(true);
				setVisible(false);
			}
		});
		EButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EButton.setBounds(234, 536, 130, 33);
		BottomPanel.add(EButton);
		
		JLabel VClabel = new JLabel("Vaccination Choice");
		VClabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		VClabel.setHorizontalAlignment(SwingConstants.RIGHT);
		VClabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		VClabel.setBounds(54, 354, 177, 26);
		BottomPanel.add(VClabel);
		
		VCtextField = new JTextField();
		VCtextField.setColumns(10);
		VCtextField.setBounds(234, 347, 209, 33);
		BottomPanel.add(VCtextField);
		
		JLabel Doselabel = new JLabel("Dose");
		Doselabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		Doselabel.setHorizontalAlignment(SwingConstants.RIGHT);
		Doselabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Doselabel.setBounds(151, 413, 73, 26);
		BottomPanel.add(Doselabel);
		
		JLabel VCentrelabel = new JLabel("Vaccination Centre");
		VCentrelabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		VCentrelabel.setHorizontalAlignment(SwingConstants.RIGHT);
		VCentrelabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		VCentrelabel.setBounds(54, 468, 177, 26);
		BottomPanel.add(VCentrelabel);
		
		DosetextField = new JTextField();
		DosetextField.setColumns(10);
		DosetextField.setBounds(234, 406, 209, 33);
		BottomPanel.add(DosetextField);
		
		VCentretextField = new JTextField();
		VCentretextField.setColumns(10);
		VCentretextField.setBounds(234, 463, 209, 33);
		BottomPanel.add(VCentretextField);
		
		JPanel TopPanel = new JPanel();
		TopPanel.setBounds(0, 0, 664, 114);
		contentPane.add(TopPanel);
		TopPanel.setBackground(new Color(255, 102, 102));
		TopPanel.setLayout(null);
		
		JLabel FirstNameLabel = new JLabel("");
		FirstNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		FirstNameLabel.setForeground(new Color(0, 0, 0));
		FirstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		FirstNameLabel.setBounds(190, 52, 159, 26);
		TopPanel.add(FirstNameLabel);
		
		JLabel LastNameLabel = new JLabel("");
		LastNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		LastNameLabel.setForeground(Color.BLACK);
		LastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		LastNameLabel.setBounds(363, 52, 159, 26);
		TopPanel.add(LastNameLabel);
		
		JLabel LogoLabel = new JLabel("");
		LogoLabel.setBounds(0, 0, 192, 111);
		TopPanel.add(LogoLabel);
		LogoLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\LogoFinal.png"));
	
		LoginPage login=new LoginPage();
		RegistrationPage rg=new RegistrationPage();
		Connection con = null;
    	Statement st=null;
    	ResultSet res=null;
    	try {
    			Class.forName(driver);
    			con = DriverManager.getConnection(url, user, pwd);
    			st = con.createStatement();
    			String SELECT_QUERY = "SELECT * FROM registration where'"+login.username+"'=  EmailId";
				res = st.executeQuery(SELECT_QUERY);
				while(res.next()) {
					FirstNameLabel.setText(res.getString(2));
					LastNameLabel.setText(res.getString(3));
					EtextField.setText(res.getString(4));
					EtextField.setEditable(false);
					PtextField.setText(res.getString(5));
					PtextField.setEditable(false);
					GtextField.setText(res.getString(6));
					GtextField.setEditable(false);
					AtextField.setText(res.getString(7));
					AtextField.setEditable(false);
					DtextField.setText(res.getString(8));
					DtextField.setEditable(false);
				}
				
				String SELECT = "SELECT * FROM appointment where'"+login.username+"'=  EmailId";
				res = st.executeQuery(SELECT);
				while(res.next()) {
					AadhartextField.setText(res.getString(1));
					AadhartextField.setEditable(false);
					VCtextField.setText(res.getString(3));
					VCtextField.setEditable(false);
					DosetextField.setText(res.getString(4));
					DosetextField.setEditable(false);
					VCentretextField.setText(res.getString(5));
					VCentretextField.setEditable(false);
				}
			}catch (ClassNotFoundException e1) {
	    		e1.printStackTrace();
	    	} catch (SQLException e2) {
	    		e2.printStackTrace();
	    	} catch (Exception e3) {
	    		e3.printStackTrace();
	    }
	}
}