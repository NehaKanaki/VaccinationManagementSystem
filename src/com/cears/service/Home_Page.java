package com.cears.service;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_Page extends JFrame {
	
	private JPanel contentPane;
	int length=0;
	Timer tm;
	int counter=0;
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
					Home_Page frame = new Home_Page();
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
	public Home_Page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1603,1021);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1552, 371);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Title1Label = new JLabel("These so-called bleak times are necessary to go through in order");
		Title1Label.setBounds(27, 139, 1479, 52);
		panel.add(Title1Label);
		Title1Label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 35));
		
		JLabel Title2Label = new JLabel("to get to a much, much better place.");
		Title2Label.setBounds(10, 180, 755, 52);
		panel.add(Title2Label);
		Title2Label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 35));
		
		JLabel QuoteLabel = new JLabel("Get vaccinated and stay safe from Covid-19. Research proves Vaccination prevents serious illiness.");
		QuoteLabel.setBounds(298, 254, 1154, 38);
		panel.add(QuoteLabel);
		QuoteLabel.setForeground(new Color(25, 25, 112));
		QuoteLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel MainTitleLabel = new JLabel("ONE NATION ONE CARE!");
		MainTitleLabel.setForeground(new Color(0, 0, 102));
		MainTitleLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 45));
		MainTitleLabel.setBounds(510, 38, 648, 63);
		panel.add(MainTitleLabel);
		String txt=MainTitleLabel.getText();
		length=txt.length();
		
		tm=new Timer(200,new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter++;
				if(counter>length) {
					counter=0;
					//tm.stop();
				}
				else {
					MainTitleLabel.setText(txt.substring(0,counter));
				}
			}
		});
	tm.start();
		

		
		JLabel LogoLabel = new JLabel("");
		LogoLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\LogoFinal.png"));
		LogoLabel.setBounds(10, 0, 183, 116);
		panel.add(LogoLabel);
		
		JButton btnNewButton = new JButton("SignUp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationPage rp=new RegistrationPage();
				rp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(1108, 332, 117, 39);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp=new LoginPage();
				lp.setVisible(true);
				setVisible(false);
			}
		});
		btnLogin.setForeground(new Color(0, 128, 0));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(1253, 332, 117, 39);
		panel.add(btnLogin);
		
		JButton btnNewButton_1_1 = new JButton("About Us\r\n");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUs au=new AboutUs();
				au.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1_1.setForeground(Color.RED);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(1389, 332, 133, 39);
		panel.add(btnNewButton_1_1);
		
		JLabel BackgroundImageLabel = new JLabel("");
		BackgroundImageLabel.setBounds(0, 0, 1542, 371);
		panel.add(BackgroundImageLabel);
		BackgroundImageLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Screenshot 2022-08-02 114440.png"));
		
		JLabel PrecautionTitleLabel = new JLabel("Following precautions to be taken to prevent Covid - 19 :-");
		PrecautionTitleLabel.setBounds(27, 397, 685, 31);
		PrecautionTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(PrecautionTitleLabel);
		
		JLabel Precaution1Label = new JLabel("Avoid touching your face.");
		Precaution1Label.setBounds(63, 461, 238, 31);
		Precaution1Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(Precaution1Label);
		
		JLabel Precaution2Label = new JLabel("Cover your mouth and nose when coughing");
		Precaution2Label.setBounds(63, 517, 435, 25);
		Precaution2Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(Precaution2Label);
		
		JLabel Precaution3Label = new JLabel("Avoid close contact");
		Precaution3Label.setBounds(68, 568, 248, 31);
		Precaution3Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(Precaution3Label);

		JLabel Precaution4Label = new JLabel("Wash your hands frequently");
		Precaution4Label.setBounds(63, 621, 332, 31);
		Precaution4Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(Precaution4Label);
		
		JLabel TickImage1Label = new JLabel("");
		TickImage1Label.setBounds(10, 461, 45, 31);
		TickImage1Label.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Picture1.png"));
		contentPane.add(TickImage1Label);

		JLabel TickImage2Label = new JLabel("");
		TickImage2Label.setBounds(8, 511, 45, 31);
		TickImage2Label.setIcon(new ImageIcon("D:\\\\Eclipse Workshop\\\\VaccinationManagementSystem\\\\src\\\\Images\\\\Picture1.png"));
		contentPane.add(TickImage2Label);
		
		JLabel TickImage3Label = new JLabel("");
		TickImage3Label.setBounds(10, 568, 45, 31);
		TickImage3Label.setIcon(new ImageIcon("D:\\\\Eclipse Workshop\\\\VaccinationManagementSystem\\\\src\\\\Images\\\\Picture1.png"));
		contentPane.add(TickImage3Label);
		
		JLabel TickImage4Label = new JLabel("");
		TickImage4Label.setBounds(10, 627, 45, 31);
		TickImage4Label.setIcon(new ImageIcon("D:\\\\Eclipse Workshop\\\\VaccinationManagementSystem\\\\src\\\\Images\\\\Picture1.png"));
		contentPane.add(TickImage4Label);
		
		JLabel PictureLabel = new JLabel("");
		PictureLabel.setBounds(637, 433, 427, 338);
		PictureLabel.setIcon(new ImageIcon("D:\\\\Eclipse Workshop\\\\VaccinationManagementSystem\\\\src\\\\Images\\Picture2.jpg"));
		contentPane.add(PictureLabel);
		
		JLabel Picture1Label = new JLabel("");
		Picture1Label.setBounds(1095, 440, 435, 338);
		Picture1Label.setIcon(new ImageIcon("D:\\\\\\\\Eclipse Workshop\\\\\\\\VaccinationManagementSystem\\\\\\\\src\\\\\\\\Images\\Picture7.png"));
		contentPane.add(Picture1Label);
		//setUndecorated(true);
		}
}
