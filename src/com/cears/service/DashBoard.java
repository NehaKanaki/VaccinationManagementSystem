package com.cears.service;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import com.cears.dao.Booking;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import com.cears.utility.EmailNotification;

public class DashBoard extends JFrame {
	private JPanel contentPane;
	private JLabel LTitleLabel;
	private JTextField adtextField;
	private JLabel familyImageLabel;
	private JTextField textField;
	private JLabel NurseLabel;
	private JTextField VAadhartextField;
	private JLabel VAadharLabel;
	
	private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/vmsdatabase";
    private static String user = "root";
    private static String pwd = "root2004";

    int count,length=0,len=0,length1=0,length2=0,length3=0,length4=0,counter=0,counter1=0,counter2=0,counter3=0,counter4=0,counter5=0;
	String number, str,VaccinationCenter;
	Timer tm,tm1,tm2,tm3,tm4,tm5;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
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
	

	public DashBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920,1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Default Dashboard Design
		JPanel Leftpanel = new JPanel();
		Leftpanel.setBounds(0, 0, 242, 845);
		Leftpanel.setBackground(new Color(255, 255, 255));
		contentPane.add(Leftpanel);
		
		JPanel Toppanel = new JPanel();
		Toppanel.setBounds(240, 0, 1332, 124);
		Toppanel.setBackground(new Color(255, 255, 255));
		contentPane.add(Toppanel);
		Toppanel.setLayout(null);
		
		JLabel EmblemLabel = new JLabel("");
		EmblemLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Emblem.png"));
		EmblemLabel.setBounds(10, 10, 75, 104);
		Toppanel.add(EmblemLabel);
		
		LTitleLabel = new JLabel("Ministry of Health");
		LTitleLabel.setForeground(new Color(0, 0, 0));
		LTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		LTitleLabel.setBounds(83, 22, 176, 39);
		Toppanel.add(LTitleLabel);
		
		JLabel LTitle1Label = new JLabel("and Family Welfare");
		LTitle1Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		LTitle1Label.setForeground(new Color(0, 0, 0));
		LTitle1Label.setBounds(83, 46, 175, 22);
		Toppanel.add(LTitle1Label);
		
		JLabel LTitle2Label = new JLabel("GOVERNMENT OF INDIA");
		LTitle2Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LTitle2Label.setBounds(78, 71, 214, 22);
		Toppanel.add(LTitle2Label);
		
		JLabel LogoLabel = new JLabel("");
		LogoLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\LogoFinal.png"));
		LogoLabel.setBounds(1115, 0, 176, 114);
		Toppanel.add(LogoLabel);
		
		JLabel DashboardTitleLabel = new JLabel("One Nation One Care\r\n");
		DashboardTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		DashboardTitleLabel.setBounds(454, 32, 385, 56);
		Toppanel.add(DashboardTitleLabel);
		String text=DashboardTitleLabel.getText();
		length4=text.length();
		
		tm5=new Timer(200,new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter5++;
				if(counter5>length4) {
					DashboardTitleLabel.setText("");
					counter5=0;
				}
				else {
					DashboardTitleLabel.setText(text.substring(0,counter5));
				}
			}
		});
	tm5.start();
		
		JLabel TopPanelLabel = new JLabel("");
		TopPanelLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\dashboard.png"));
		TopPanelLabel.setBounds(0, 0, 1302, 124);
		Toppanel.add(TopPanelLabel);
		Leftpanel.setLayout(null);
		
		JLabel WelcomeLabel = new JLabel("Welcome");
		WelcomeLabel.setBounds(49, 25, 99, 27);
		WelcomeLabel.setFont(new Font("Algerian", Font.PLAIN, 20));
		Leftpanel.add(WelcomeLabel);
		String txt1=WelcomeLabel.getText();
		len=txt1.length();
		
		tm1=new Timer(200,new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter1++;
				if(counter1>len) {
					counter1=0;
					tm1.stop();
				}
				else {
					WelcomeLabel.setText(txt1.substring(0,counter1));
				}
			}
		});
	tm1.start();
		
		JLabel ToLabel = new JLabel("To");
		ToLabel.setBounds(82, 62, 40, 27);
		ToLabel.setFont(new Font("Algerian", Font.PLAIN, 20));
		Leftpanel.add(ToLabel);
		String txt2=ToLabel .getText();
		length1=txt2.length();
		
		tm2=new Timer(200,new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter2++;
				if(counter2>length1) {
					counter2=0;
					tm2.stop();
				}
				else {
					ToLabel .setText(txt2.substring(0,counter2));
				}
			}
		});
	tm2.start();
		
		JLabel ONOCLabel = new JLabel("One Nation One Care");
		ONOCLabel.setBounds(10, 99, 222, 27);
		ONOCLabel.setFont(new Font("Algerian", Font.PLAIN, 20));
		Leftpanel.add(ONOCLabel);
		
		JButton ProfileButton = new JButton("Profile");
		ProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile p=new Profile();
				p.setVisible(true);
				setVisible(false);
			}
		});
		ProfileButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ProfileButton.setBounds(0, 233, 242, 51);
		Leftpanel.add(ProfileButton);
		
		JButton HomeButton = new JButton("Home");
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_Page hp=new Home_Page();
				hp.setVisible(true);
				setVisible(false);
			}
		});
		HomeButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		HomeButton.setBounds(0, 307, 242, 51);
		Leftpanel.add(HomeButton);
		
		JButton FeedbackButton = new JButton("Feedback");
		FeedbackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FeedBack fb=new FeedBack();
				fb.setVisible(true);
				setVisible(false);
			}
		});
		FeedbackButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		FeedbackButton.setBounds(0, 380, 242, 51);
		Leftpanel.add(FeedbackButton);
		
		JButton SignOutButton = new JButton("Sign Out");
		SignOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "Are you sure? ";
                String title = "Quit";
                int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                {
                	LoginPage login=new LoginPage();
					login.setVisible(true);
					setVisible(false);
                }
			}
		});
		SignOutButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		SignOutButton.setBounds(0, 455, 242, 51);
		Leftpanel.add(SignOutButton);
		String txt3=ONOCLabel.getText();
		length2=txt3.length();
		
		tm3=new Timer(200,new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter3++;
				if(counter3>length2) {
					counter3=0;
					tm3.stop();
				}
				else {
					ONOCLabel.setText(txt3.substring(0,counter3));
				}
			}
		});
	tm3.start();
		
		JLabel LeftPanelLabel = new JLabel("");
		LeftPanelLabel.setBounds(0, 0, 242, 845);
		LeftPanelLabel.setForeground(Color.WHITE);
		LeftPanelLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\dashhhhhhh.png"));
		Leftpanel.add(LeftPanelLabel);
		
		//Default Dashboard Left Panel Design
		JPanel panel = new JPanel();
		panel.setBounds(240, 114, 381, 731);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		familyImageLabel = new JLabel("");
		familyImageLabel.setBackground(Color.WHITE);
		familyImageLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\FamilyImage.jpg"));
		familyImageLabel.setBounds(0, 10, 361, 293);
		panel.add(familyImageLabel);
		
		JLabel lblUnavoidablePrecautions = new JLabel("Unavoidable Precautions :-");
		lblUnavoidablePrecautions.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblUnavoidablePrecautions.setBounds(10, 326, 303, 29);
		panel.add(lblUnavoidablePrecautions);
		
		JLabel MaskLabel = new JLabel("Use Mask In Public");
		MaskLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MaskLabel.setBounds(74, 388, 194, 29);
		panel.add(MaskLabel);
		
		JLabel SanitizerLabel = new JLabel("Wash your hands often ");
		SanitizerLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		SanitizerLabel.setBounds(99, 548, 224, 29);
		panel.add(SanitizerLabel);
		
		JLabel StayFeetLabel = new JLabel("Stay 6 feet away from others");
		StayFeetLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		StayFeetLabel.setBounds(97, 469, 280, 29);
		panel.add(StayFeetLabel);
		
		JLabel VaccinatedLabel = new JLabel("Get Vaccinated");
		VaccinatedLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		VaccinatedLabel.setBounds(99, 627, 194, 29);
		panel.add(VaccinatedLabel);
	
		JLabel MaskImageLabel = new JLabel("");
		MaskImageLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\MaskImage.jpg"));
		MaskImageLabel.setBounds(0, 373, 69, 56);
		panel.add(MaskImageLabel);
		
		JLabel SocilaDistancingImageLabel = new JLabel("");
		SocilaDistancingImageLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Social Distancing.png"));
		SocilaDistancingImageLabel.setBounds(0, 449, 102, 64);
		panel.add(SocilaDistancingImageLabel);
		
		JLabel SanitizerImageLabel = new JLabel("");
		SanitizerImageLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Sanitizer.jpg"));
		SanitizerImageLabel.setBounds(10, 535, 81, 56);
		panel.add(SanitizerImageLabel);
		
		JLabel VaccinationImageLabel = new JLabel("");
		VaccinationImageLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Vaccination.png"));
		VaccinationImageLabel.setBounds(0, 601, 90, 86);
		panel.add(VaccinationImageLabel);
		
		//Default Dashboard Right Panel Design
		JPanel backpanel = new JPanel();
		backpanel.setBounds(882, 114, 658, 731);
		backpanel.setBackground(new Color(255, 255, 255));
		contentPane.add(backpanel);
		backpanel.setLayout(null);
		
		JLabel Tick1Label = new JLabel("");
		Tick1Label.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Picture1.png"));
		Tick1Label.setBounds(10, 472, 45, 31);
		backpanel.add(Tick1Label);
		
		JTextArea txtrAboutCoronavirusDisease = new JTextArea();
		txtrAboutCoronavirusDisease.setBackground(new Color(255, 255, 255));
		txtrAboutCoronavirusDisease.setFont(new Font("Arial", Font.PLAIN, 22));
		txtrAboutCoronavirusDisease.setText("Coronavirus disease (COVID-19) is an infectious disease caused \r\nby  the SARS-CoV-2 virus. Most people who fall sick with \r\nCOVID-19 will experience mild to moderate symptoms and \r\nrecover without special treatment. However, some will \r\nbecome seriously ill and require medical attention.\r\n\r\nSymptoms show up in people within two to 14 days of exposure\r\nto the virus. A person infected with the coronavirus is contagious \r\nto others for up to two days before symptoms appear, and they \r\nremain contagious to others for 10 to 20 days, depending upon \r\ntheir immune system and the severity of their illness. \r\n\r\n\r\n");
		txtrAboutCoronavirusDisease.setBounds(10, 101, 658, 305);
		backpanel.add(txtrAboutCoronavirusDisease);
		
		JLabel AboutLabel = new JLabel("About");
		AboutLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		AboutLabel.setForeground(new Color(0, 0, 0));
		AboutLabel.setBounds(59, 30, 119, 31);
		backpanel.add(AboutLabel);
		
		JLabel lAboutIconLabel = new JLabel("");
		lAboutIconLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\About.png"));
		lAboutIconLabel.setBounds(22, 30, 33, 28);
		backpanel.add(lAboutIconLabel);
		
		JLabel SynTitleLabel = new JLabel("Symptoms :");
		SynTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		SynTitleLabel.setBounds(63, 423, 201, 32);
		backpanel.add(SynTitleLabel);
		
		JLabel Tick2Label = new JLabel("");
		Tick2Label.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Picture1.png"));
		Tick2Label.setBounds(10, 526, 45, 31);
		backpanel.add(Tick2Label);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Picture1.png"));
		lblNewLabel_7.setBounds(10, 578, 45, 31);
		backpanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Picture1.png"));
		lblNewLabel_8.setBounds(10, 633, 45, 31);
		backpanel.add(lblNewLabel_8);
		
		JLabel Syn1Label = new JLabel("Fever");
		Syn1Label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Syn1Label.setBounds(65, 472, 113, 31);
		backpanel.add(Syn1Label);
		
		JLabel Syn2Label = new JLabel("Cough");
		Syn2Label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Syn2Label.setBounds(65, 526, 113, 31);
		backpanel.add(Syn2Label);
		
		JLabel lblTiredness = new JLabel("Tiredness");
		lblTiredness.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTiredness.setBounds(63, 578, 113, 31);
		backpanel.add(lblTiredness);
		
		JLabel lblLossOfTaste = new JLabel("Loss of taste or smell");
		lblLossOfTaste.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLossOfTaste.setBounds(63, 633, 296, 31);
		backpanel.add(lblLossOfTaste);
		
		JLabel ImageLabel = new JLabel("");
		ImageLabel.setBounds(353, 416, 281, 305);
		backpanel.add(ImageLabel);
		ImageLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\,,,,,,,,,,,,,,,,,.jpg"));
		
		JTextArea txtrVaccinationProtectsHealth = new JTextArea();
		txtrVaccinationProtectsHealth.setBounds(631, 168, 249, 120);
		contentPane.add(txtrVaccinationProtectsHealth);
		txtrVaccinationProtectsHealth.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 19));
		txtrVaccinationProtectsHealth.setText("Vaccination protects \r\nhealth at every stage\r\nof life.");
		String txt=txtrVaccinationProtectsHealth.getText();
		length=txt.length();
		tm=new Timer(150,new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter++;
				if(counter>length) {
					counter=0;
					tm.stop();
				}
				else {
					txtrVaccinationProtectsHealth.setText(txt.substring(0,counter));
				}
			}
		});
	tm.start();
		
		//Book Appointment Design
		JPanel appointmentrightpanel = new JPanel();
		appointmentrightpanel.setBackground(new Color(255, 240, 245));
		appointmentrightpanel.setBounds(882, 117, 658, 728);
		contentPane.add(appointmentrightpanel);
		appointmentrightpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booking");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(220, 72, 161, 50);
		appointmentrightpanel.add(lblNewLabel);
		
		JLabel AadharNoLabel = new JLabel("Aadhar No :");
		AadharNoLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		AadharNoLabel.setBounds(126, 213, 144, 36);
		appointmentrightpanel.add(AadharNoLabel);
		
		JLabel DateLabel = new JLabel("Date :");
		DateLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		DateLabel.setBounds(185, 294, 85, 36);
		appointmentrightpanel.add(DateLabel);
		
		JLabel VacChoiceLabel = new JLabel("Vaccination Choice :");
		VacChoiceLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		VacChoiceLabel.setBounds(27, 377, 243, 36);
		appointmentrightpanel.add(VacChoiceLabel);
		
		JLabel VacCentreLabel = new JLabel("Vaccination Centre :");
		VacCentreLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		VacCentreLabel.setBounds(27, 500, 233, 36);
		appointmentrightpanel.add(VacCentreLabel);
		
		JLabel DoseLabel = new JLabel("Dose :");
		DoseLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		DoseLabel.setBounds(185, 439, 85, 36);
		appointmentrightpanel.add(DoseLabel);
		
		JLabel AdErrorLabel = new JLabel("");
		AdErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AdErrorLabel.setForeground(Color.RED);
		AdErrorLabel.setBounds(460, 213, 144, 23);
		appointmentrightpanel.add(AdErrorLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String phoneNo =  textField.getText();
				int length = phoneNo.length();
				char c = e.getKeyChar();
				
				if(phoneNo.matches("^[0-9]$")&& phoneNo.length()==12)
				{
				}
				
				if(e.getKeyChar()>='0'&& e.getKeyChar()<='9') {
					if(length==0&&e.getKeyChar()<='1') {
						AdErrorLabel.setText("Enter valid number");
						AdErrorLabel.setVisible(true);
					}
					if(length<12) {
						textField.setEditable(true);
					}else {

						textField.setEditable(false);
					}
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE|| e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						textField.setEditable(true);
						AdErrorLabel.setText("");
					}else {
						textField.setEditable(false);
					}
				}
			}
		});
		textField.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		textField.setBounds(280, 213, 173, 31);
		appointmentrightpanel.add(textField);
		textField.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		dateChooser.setBounds(280, 294, 173, 31);
		appointmentrightpanel.add(dateChooser);
		
		JComboBox VaccCentrecomboBox = new JComboBox();
		VaccCentrecomboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		VaccCentrecomboBox.setModel(new DefaultComboBoxModel(new String[] {"---Choose Centre---", "Khobare hospital", "E S I Hospital", "Shree Clinic", "CNS Hospital", "Reliance Hospital", "Wadia Hospital", "Dr.G.J.Kasliwal Hospital"}));
		VaccCentrecomboBox.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		VaccCentrecomboBox.setBounds(280, 505, 173, 31);
		appointmentrightpanel.add(VaccCentrecomboBox);
		
		JRadioButton CovaxinRadioButton = new JRadioButton("Covaxin");
		CovaxinRadioButton.setContentAreaFilled(false);
		CovaxinRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CovaxinRadioButton.setBounds(259, 377, 103, 31);
		appointmentrightpanel.add(CovaxinRadioButton);
		
		JRadioButton CovidShieldRadioButton = new JRadioButton("CovidShield");
		CovidShieldRadioButton.setContentAreaFilled(false);
		CovidShieldRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CovidShieldRadioButton.setBounds(384, 377, 154, 35);
		appointmentrightpanel.add(CovidShieldRadioButton);
		
		ButtonGroup bn = new ButtonGroup();
		bn.add(CovaxinRadioButton);
		bn.add(CovidShieldRadioButton);
		
		JRadioButton Dose1RadioButton = new JRadioButton("1");
		Dose1RadioButton.setContentAreaFilled(false);
		Dose1RadioButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Dose1RadioButton.setBounds(276, 440, 48, 35);
		appointmentrightpanel.add(Dose1RadioButton);
		
		JRadioButton Dose2RadioButton = new JRadioButton("2");
		Dose2RadioButton.setContentAreaFilled(false);
		Dose2RadioButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Dose2RadioButton.setBounds(365, 440, 48, 35);
		appointmentrightpanel.add(Dose2RadioButton);
		
		ButtonGroup button = new ButtonGroup();
		button.add(Dose1RadioButton);
		button.add(Dose2RadioButton);

		JLabel AdReLabel = new JLabel("");
		AdReLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AdReLabel.setBounds(126, 243, 108, 23);
		appointmentrightpanel.add(AdReLabel);
		
		JLabel DateReLabel = new JLabel("");
		DateReLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DateReLabel.setBounds(185, 326, 108, 23);
		appointmentrightpanel.add(DateReLabel);
		
		JLabel VCReLabel = new JLabel("");
		VCReLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		VCReLabel.setBounds(27, 412, 108, 23);
		appointmentrightpanel.add(VCReLabel);
		
		JLabel DoseReLabel = new JLabel("");
		DoseReLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DoseReLabel.setBounds(185, 467, 108, 23);
		appointmentrightpanel.add(DoseReLabel);
		
		JLabel vcReLabel = new JLabel("");
		vcReLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		vcReLabel.setBounds(27, 534, 108, 23);
		appointmentrightpanel.add(vcReLabel);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().equals(""))
				{
					AdReLabel.setText("Required *");
					AdReLabel.setForeground(Color.red);
				}
				if(((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().isEmpty()) {
					DateReLabel.setForeground(Color.red);
					DateReLabel.setText("Required *");
				}
				if(!CovaxinRadioButton.isSelected()&&!CovidShieldRadioButton.isSelected())
				{
					VCReLabel.setForeground(Color.red);
					VCReLabel.setText("Required *");
				}
				if(!Dose1RadioButton.isSelected()&&!Dose2RadioButton.isSelected())
				{
					DoseReLabel.setForeground(Color.red);
					DoseReLabel.setText("Required *");
				}
				if(VaccCentrecomboBox.getSelectedItem ().toString ().equals ("---Choose Centre---")) {
					vcReLabel.setForeground(Color.red);
					vcReLabel.setText("Required *");
				}
				else {
					if(CovaxinRadioButton.isSelected()) 
						str="Covaxin";
					else
						str="CovidShield";
					
					if(Dose1RadioButton.isSelected())
						number="1";
					else
						number="2";
					
					int index;
					index=VaccCentrecomboBox.getSelectedIndex();
					if(index==1)
						VaccinationCenter="Khobare hospital";
					if(index==2)
						VaccinationCenter="E S I Hospital";
					if(index==3)
						VaccinationCenter="Shree Clinic";
					if(index==4)
						VaccinationCenter="CNS Hospital";
					if(index==5)
					VaccinationCenter="Reliance Hospital";
					if(index==6)
					VaccinationCenter="Wadia Hospital";
					if(index==7)
					VaccinationCenter="Dr.G.J.Kasliwal Hospital";
					String dob=dateChooser.getDate().toString();
					Connection con = null;
			    	Statement st=null;
			    	ResultSet res=null;
			    	try {
			    			Class.forName(driver);
			    			con = DriverManager.getConnection(url, user, pwd);
			    			st = con.createStatement();
			    			String SELECT_QUERY = "SELECT VaccineStock FROM vaccinestock where'"+str+"'=  VaccineName";
							res = st.executeQuery(SELECT_QUERY);
							if(res.next()) {
							count=res.getInt(1);
							}
							
						if(count>0) {
							ArrayList<String> list=new ArrayList<> ();
							list.add(textField.getText());
							list.add(dob);
							list.add(str);
							list.add(number);
							list.add(VaccinationCenter);
							LoginPage login=new LoginPage();
							list.add(login.username);
							Booking book=new Booking();
							book.insert(list);
							String UPDATE_QUERY="Update vaccinestock set VaccineStock=VaccineStock-1 where '"+str+"'=  VaccineName";
							st.executeUpdate(UPDATE_QUERY);
							String msg="Done";
							JOptionPane.showMessageDialog(null,"Get Ready to Vaccinate",msg,JOptionPane.INFORMATION_MESSAGE,null);
							
							   String message="Congratulations! You have scheduled your vaccination. ";
							   String subject="Vaccination : Confirmation ";
							   String from="onenationonecare@gmail.com";
							   String to=login.username;
							   EmailNotification email=new EmailNotification();
							   email.sendEmail(message,subject,to,from);  
						}
						else {
							String msg="Not Done";
							JOptionPane.showMessageDialog(null,"Insufficient Stock!!!",msg,JOptionPane.INFORMATION_MESSAGE,null);
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
		});
		SubmitButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		SubmitButton.setBounds(247, 596, 134, 36);
		appointmentrightpanel.add(SubmitButton);
		
		JPanel appointmentleftpanel = new JPanel();
		appointmentleftpanel.setBackground(new Color(255, 240, 245));
		appointmentleftpanel.setBounds(240, 117, 380, 739);
		contentPane.add(appointmentleftpanel);
		appointmentleftpanel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(0, 10, 54, 38);
		appointmentleftpanel.add(btnNewButton);
		btnNewButton.setVisible(false);
		
		NurseLabel = new JLabel("");
		NurseLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\bookappointment.png"));
		NurseLabel.setBounds(0, 70, 380, 579);
		appointmentleftpanel.add(NurseLabel);
				
		JTextArea txtrNeverPutOff = new JTextArea();
		txtrNeverPutOff.setBackground(new Color(255, 255, 255));
		txtrNeverPutOff.setFont(new Font("Cambria", Font.BOLD, 22));
		txtrNeverPutOff.setBounds(630, 183, 242, 264);
		contentPane.add(txtrNeverPutOff);
		txtrNeverPutOff.setVisible(false);
	
		
	JButton BAButton = new JButton("Book Appointment");
	BAButton.setBounds(630, 476, 242, 43);
	contentPane.add(BAButton);
	BAButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.setBackground(new Color(255, 240, 245));
			backpanel.setVisible(false);
			panel.setVisible(false);
			btnNewButton.setVisible(true);
			txtrVaccinationProtectsHealth.setVisible(false);
			appointmentleftpanel.setVisible(true);
			appointmentrightpanel.setVisible(true);
			txtrNeverPutOff.setVisible(true);
			txtrNeverPutOff.setBackground(new Color(255, 240, 245));
			txtrNeverPutOff.setText("Never put off until\r\ntomorrow what you\r\ncan do today. Grab\r\nopportunity and\r\nschedule your \r\nvaccine appointment\r\nto help each other\r\nto make a better\r\nIndia!");
			String txt4=txtrNeverPutOff.getText();
			length3=txt4.length();
			
			tm4=new Timer(200,new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					counter4++;
					if(counter4>length3) {
						counter4=0;
						tm4.stop();
					}
					else {
						txtrNeverPutOff.setText(txt4.substring(0,counter4));
					}
				}
			});
		tm4.start();
		}
	});
	BAButton.setFont(new Font("Tahoma", Font.BOLD, 20));

	//View Appointment Panel
	JPanel Vapanel = new JPanel();
	Vapanel.setBounds(882, 123, 658, 722);
	contentPane.add(Vapanel);
	Vapanel.setLayout(null);
	Vapanel.setVisible(false);
	Vapanel.setBackground(new Color(255, 240, 245));
	
	JLabel VaTitleLabel = new JLabel("To view your appointment, please enter your Aadhar No");
	VaTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
	VaTitleLabel.setBounds(20, 185, 638, 42);
	Vapanel.add(VaTitleLabel);
	
	VAadharLabel = new JLabel("AadharCard No :");
	VAadharLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
	VAadharLabel.setBounds(124, 331, 266, 42);
	Vapanel.add(VAadharLabel);
	
	JLabel AadharValidationLabel = new JLabel("");
	AadharValidationLabel.setForeground(Color.RED);
	AadharValidationLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	AadharValidationLabel.setBounds(286, 353, 192, 42);
	Vapanel.add(AadharValidationLabel);
	
	
	JTextArea DisplaytextArea = new JTextArea();
	DisplaytextArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
	DisplaytextArea.setBounds(96, 125, 526, 460);
	Vapanel.add(DisplaytextArea);
	DisplaytextArea.setVisible(false);
	
	VAadhartextField = new JTextField();
	VAadhartextField.setBorder(new LineBorder(new Color(171, 173, 179), 3, true));
	VAadhartextField.setBounds(316, 331, 212, 42);
	Vapanel.add(VAadhartextField);
	VAadhartextField.setFont(new Font("Tahoma", Font.PLAIN, 25));
	VAadhartextField.setColumns(10);
	VAadhartextField.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			String pNo =  VAadhartextField.getText();
			int l = pNo.length();
			char c = e.getKeyChar();
			
			if(pNo.matches("^[0-9]$")&& pNo.length()==12)
			{
			}
			
			if(e.getKeyChar()>='0'&& e.getKeyChar()<='9') {
				if(l==0&&e.getKeyChar()<='1') {
					AadharValidationLabel.setText("Enter valid number");
					AadharValidationLabel.setVisible(true);
				}
				if(l<12) {
					VAadhartextField.setEditable(true);
				}else {

					VAadhartextField.setEditable(false);
				}
			}else {
				if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE|| e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
					VAadhartextField.setEditable(true);
					AadharValidationLabel.setText("");
				}else {
					VAadhartextField.setEditable(false);
					
				}
			}
		}
	});	
	
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnNewButton.setVisible(false);
			contentPane.setBackground(Color.WHITE);
			txtrNeverPutOff.setVisible(false);
			txtrVaccinationProtectsHealth.setVisible(true);
			panel.setVisible(true);
			backpanel.setVisible(true);
			Vapanel.setVisible(false);
			appointmentrightpanel.setVisible(false);
		}
	});
	btnNewButton.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\backicon.jpg"));

	JButton VSubmitButton = new JButton("Submit");
	VSubmitButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Connection con = null;
	    	Statement st=null;
	    	ResultSet res=null;
	    	try {
	    			Class.forName(driver);
	    			con = DriverManager.getConnection(url, user, pwd);
	    			st = con.createStatement();
	    			String SELECT_QUERY = "SELECT * FROM appointment where'"+VAadhartextField.getText()+"'=  AadharNo";
					res = st.executeQuery(SELECT_QUERY);
				
					if(res.next()) {	
						VaTitleLabel.setVisible(false);
						VAadhartextField.setVisible(false);
						AadharValidationLabel.setVisible(false);
						VAadharLabel.setVisible(false);
						VSubmitButton.setVisible(false);
						DisplaytextArea.setVisible(true);
						 DisplaytextArea.setText("\t   ----- Hello -----"+"\n\nAadhar No :" + res.getString(1)+ "\r\n\nDate :" +res.getString(2)+"\r\n\nVaccination Choice :"+res.getString(3)+"\r\n\nDose :"+res.getString(4)+"\r\n\nVaccination Centre:"+res.getString(5));
						 DisplaytextArea.setEditable(false);
					}
					else if(VAadhartextField.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Enter Aadhar Number");
					}
				else {
					JOptionPane.showMessageDialog(null,"Enter Valid number");
				}
		}catch (ClassNotFoundException e1) {
    		e1.printStackTrace();
    	} catch (SQLException e2) {
    		e2.printStackTrace();
    	} catch (Exception e3) {
    		e3.printStackTrace();
    	}
    }
	});
	VSubmitButton.setFont(new Font("Tahoma", Font.BOLD, 20));
	VSubmitButton.setBounds(267, 438, 135, 42);
	Vapanel.add(VSubmitButton);
	
	JButton btnViewAppointment = new JButton("View Appointment");
	btnViewAppointment.setBounds(630, 553, 242, 43);
	contentPane.add(btnViewAppointment);
	btnViewAppointment.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.setBackground(new Color(255, 240, 245));
			btnNewButton.setVisible(true);
			panel.setVisible(false);
			backpanel.setVisible(false);
			txtrNeverPutOff.setBackground(new Color(255, 240, 245));
			txtrVaccinationProtectsHealth.setVisible(false);
			appointmentrightpanel.setVisible(false);
			appointmentleftpanel.setVisible(true);
			Vapanel.setVisible(true);
		}
	});
	btnViewAppointment.setFont(new Font("Tahoma", Font.BOLD, 20));
}
}