package com.cears.service;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class AboutUs extends JFrame {

	private JPanel contentPane;

	Timer tm,tm1;
	int counter,length,counter1,length1;
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
					AboutUs frame = new AboutUs();
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
	public AboutUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Titlepanel = new JPanel();
		Titlepanel.setBackground(Color.WHITE);
		Titlepanel.setBounds(0, 0, 1530, 103);
		contentPane.add(Titlepanel);
		Titlepanel.setLayout(null);
		
		JLabel LogoLabel = new JLabel("");
		LogoLabel.setBounds(0, 0, 190, 103);
		Titlepanel.add(LogoLabel);
		LogoLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\LogoFinal.png"));
		
		JLabel MainTitleLabel = new JLabel("One Nation One Care");
		MainTitleLabel.setBounds(567, 27, 487, 42);
		Titlepanel.add(MainTitleLabel);
		MainTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		String txt1=MainTitleLabel.getText();
		length1=txt1.length();
		
		tm1=new Timer(200,new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter1++;
				if(counter1>length1) {
					//counter1=0;
					tm1.stop();
				}
				else {
					MainTitleLabel.setText(txt1.substring(0,counter1));
				}
			}
		});
	tm1.start();
		
		JLabel TitleBackLabel = new JLabel("");
		TitleBackLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\AboutUsBackImage.png"));
		TitleBackLabel.setBounds(0, 0, 1530, 103);
		Titlepanel.add(TitleBackLabel);
		
		JLabel QuoteLabel = new JLabel("Let's help each other to make better INDIA!");
		QuoteLabel.setFont(new Font("Algerian", Font.BOLD, 35));
		QuoteLabel.setBounds(330, 98, 925, 70);
		contentPane.add(QuoteLabel);
		String txt=QuoteLabel.getText();
		length=txt.length();
		
		tm=new Timer(200,new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter++;
				if(counter>length) {
					
					counter=0;
					//tm.stop();
				}
				else {
					QuoteLabel.setText(txt.substring(0,counter));
				}
			}
		});
	tm.start();
	
		JLabel ImageLabel = new JLabel("");
		ImageLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\AboutUsBackGroundImage.jpg"));
		ImageLabel.setBounds(0, 153, 1551, 338);
		contentPane.add(ImageLabel);
		
		JTextArea txtrManageTheComplete = new JTextArea();
		txtrManageTheComplete.setBackground(Color.WHITE);
		txtrManageTheComplete.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrManageTheComplete.setText("   Manage the complete vaccination process from registration\r\nto administration and follow up via our vaccine administration\r\nmanagement system. Owing to the world’s struggling with a\r\nglobal pandemic for more than a year now, vaccination has\r\nassumed prime importance in everyone’s lives. After battling\r\nwith uncertainties and speculations, the public is finally being\r\nprovided with the much-needed vaccine doses across the world.\r\n   However, the vaccination process is not as simple as it looks.\r\nIt takes a lot of considerations, planning, and patience to get\r\nyou and your loved ones vaccinated.");
		txtrManageTheComplete.setBounds(10, 501, 782, 287);
		contentPane.add(txtrManageTheComplete);
		txtrManageTheComplete.setEditable(false);
		
		JTextArea txtrOneNationOne = new JTextArea();
		txtrOneNationOne.setBackground(Color.WHITE);
		txtrOneNationOne.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrOneNationOne.setText("   One Nation One Care helps you to get your appointment\r\nbooked by just doing some major steps. This app is user\r\nfriendly that even rural area people can use it to book\r\ntheir appointment and can help each other to make a\r\nbetter INDIA!\r\n");
		txtrOneNationOne.setBounds(832, 508, 679, 149);
		contentPane.add(txtrOneNationOne);
		txtrOneNationOne.setEditable(false);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_Page hm=new Home_Page();
				hm.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\backicon.jpg"));
		btnNewButton.setBounds(0, 103, 64, 40);
		contentPane.add(btnNewButton);
		
		JLabel ContLabel = new JLabel("\r\nContact for more info : ");
		ContLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		ContLabel.setBounds(832, 679, 254, 28);
		contentPane.add(ContLabel);
		
		JLabel ForLabel = new JLabel("For any query : ");
		ForLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		ForLabel.setBounds(909, 717, 166, 28);
		contentPane.add(ForLabel);
		
		JLabel EmailLabel = new JLabel("onenationonecare@gmail.com");
		EmailLabel.setForeground(new Color(0, 51, 255));
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EmailLabel.setBounds(1069, 719, 296, 25);
		contentPane.add(EmailLabel);
		
		JLabel MobileLabel = new JLabel("1010101010");
		MobileLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MobileLabel.setBounds(1069, 682, 145, 25);
		contentPane.add(MobileLabel);
		
	}
}
