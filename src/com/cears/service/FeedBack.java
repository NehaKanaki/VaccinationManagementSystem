package com.cears.service;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class FeedBack extends JFrame {
	 private static String driver = "com.mysql.jdbc.Driver";
	    private static String url = "jdbc:mysql://localhost:3306/vmsdatabase";
	    private static String user = "root";
	    private static String pwd = "root2004";
	    private JPanel contentPane;
	    String app,service,remark;
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
					FeedBack frame = new FeedBack();
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
	public FeedBack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel TitleLabel = new JLabel("ONE NATION ONE CARE");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		TitleLabel.setBounds(283, 0, 1046, 92);
		contentPane.add(TitleLabel);
		String txt=TitleLabel.getText();
		length=txt.length();
		
		tm=new Timer(150,new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter++;
				if(counter>length) {
					TitleLabel.setText("");
					counter=0;
				}
				else {
					TitleLabel.setText(txt.substring(0,counter));
				}
			}
		});
	tm.start();
		
		JLabel SatisfiedLabel = new JLabel("Satisfied");
		SatisfiedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SatisfiedLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		SatisfiedLabel.setBounds(550, 246, 92, 38);
		contentPane.add(SatisfiedLabel);
		
		JLabel NeutralLabel = new JLabel("Neutral");
		NeutralLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		NeutralLabel.setBounds(750, 252, 106, 26);
		contentPane.add(NeutralLabel);
		
		JLabel UnstLabel = new JLabel("Unsatisfied");
		UnstLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		UnstLabel.setBounds(933, 246, 144, 32);
		contentPane.add(UnstLabel);
		
		JLabel Label1 = new JLabel("How satisfied");
		Label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Label1.setBounds(395, 296, 128, 19);
		contentPane.add(Label1);
		
		JLabel Label2 = new JLabel("are you with");
		Label2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Label2.setBounds(395, 311, 128, 19);
		contentPane.add(Label2);
		
		JLabel Label3 = new JLabel("our app?");
		Label3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Label3.setBounds(395, 325, 128, 26);
		contentPane.add(Label3);
		
		JRadioButton RadioButton1 = new JRadioButton("");
		RadioButton1.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton1.setBackground(new Color(192, 192, 192));
		RadioButton1.setBounds(550, 296, 103, 47);
		contentPane.add(RadioButton1);
		
		JLabel Label4 = new JLabel("How satisfied");
		Label4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label4.setBounds(418, 448, 105, 13);
		contentPane.add(Label4);
		
		JLabel Label5 = new JLabel("are you with");
		Label5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label5.setBounds(418, 458, 92, 19);
		contentPane.add(Label5);
		
		JLabel Label6 = new JLabel("our service?");
		Label6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label6.setBounds(418, 471, 92, 13);
		contentPane.add(Label6);
		
		JLabel textAreaLabel = new JLabel("Tell us how we can improve:\r\n");
		textAreaLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textAreaLabel.setBounds(412, 529, 292, 26);
		contentPane.add(textAreaLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(395, 590, 856, 133);
		contentPane.add(textArea);
		
		JRadioButton RadioButton2 = new JRadioButton("");
		RadioButton2.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton2.setBackground(Color.LIGHT_GRAY);
		RadioButton2.setBounds(739, 294, 103, 47);
		contentPane.add(RadioButton2);
		
		JRadioButton RadioButton3 = new JRadioButton("");
		RadioButton3.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton3.setBackground(Color.LIGHT_GRAY);
		RadioButton3.setBounds(933, 294, 103, 47);
		contentPane.add(RadioButton3);
		
		ButtonGroup bn = new ButtonGroup();
		bn.add(RadioButton1);
		bn.add(RadioButton2);
		bn.add(RadioButton3);
		
		JRadioButton RadioButton4 = new JRadioButton("");
		RadioButton4.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton4.setBackground(Color.LIGHT_GRAY);
		RadioButton4.setBounds(550, 448, 103, 47);
		contentPane.add(RadioButton4);
		
		JRadioButton RadioButton5 = new JRadioButton("");
		RadioButton5.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton5.setBackground(Color.LIGHT_GRAY);
		RadioButton5.setBounds(739, 450, 103, 47);
		contentPane.add(RadioButton5);
		
		JRadioButton RadioButton6 = new JRadioButton("");
		RadioButton6.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton6.setBackground(Color.LIGHT_GRAY);
		RadioButton6.setBounds(933, 448, 103, 47);
		contentPane.add(RadioButton6);
		
		ButtonGroup b = new ButtonGroup();
		b.add(RadioButton4);
		b.add(RadioButton5);
		b.add(RadioButton6);
		
		JLabel LogoLabel = new JLabel("");
		LogoLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\LogoFinal.png"));
		LogoLabel.setBounds(1370, 0, 170, 112);
		contentPane.add(LogoLabel);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.setBackground(new Color(255, 0, 0));
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    Connection con = null;
				    PreparedStatement insert = null;
				    if(RadioButton1.isSelected())
				    	app="Satisfied";
				    else if(RadioButton2.isSelected())
				    	app="Neutral";
				    else
				    	app="Unsatisfied";
				    
				    if(RadioButton4.isSelected())
				    	service="Satisfied";
				    else if(RadioButton5.isSelected())
				    	service="Neutral";
				    else
				    	service="Unsatisfied";
				    
				    remark=textArea.getText();
				    String INSERT_QUERY = "insert into feedback values(?,?,?)";
				    try {
				        Class.forName(driver);
				        con = DriverManager.getConnection(url, user, pwd);
				                insert = con.prepareStatement(INSERT_QUERY);
				                insert.setString(1,app);
				                insert.setString(2,service);
				                insert.setString(3,remark);
				                insert.executeUpdate();
				                JOptionPane.showMessageDialog(null, "Thankyou for your response!");
				}catch (ClassNotFoundException exc) {
				    exc.printStackTrace();
				} catch (SQLException e1) {
				    e1.printStackTrace();
				} catch (Exception e2) {
				    e2.printStackTrace();
				}
			}
		});
		SubmitButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		SubmitButton.setBounds(738, 733, 118, 32);
		contentPane.add(SubmitButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 122, 1540, 92);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel FirstPanelLabel = new JLabel("WE VALUE YOUR FEEDBACK!");
		FirstPanelLabel.setBounds(295, 10, 1036, 32);
		panel.add(FirstPanelLabel);
		FirstPanelLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		FirstPanelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel SecondPanelLabel = new JLabel("Please complete the following form and help \r\n");
		SecondPanelLabel.setBounds(528, 22, 546, 60);
		panel.add(SecondPanelLabel);
		SecondPanelLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		SecondPanelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel ThirdPanelLabel = new JLabel("us improve our customer experience.");
		ThirdPanelLabel.setBounds(593, 56, 401, 26);
		panel.add(ThirdPanelLabel);
		ThirdPanelLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton BackButton = new JButton("");
		BackButton.setBorderPainted(false);
		BackButton.setContentAreaFilled(false);
		BackButton.setBounds(0, 0, 64, 47);
		contentPane.add(BackButton);
		BackButton.setBackground(Color.PINK);
		BackButton.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\backicon.jpg"));
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashBoard db = new DashBoard();
				db.setVisible(true);
				setVisible(false);
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\FeedBack.jpg"));
		lblNewLabel.setBounds(26, 319, 354, 242);
		contentPane.add(lblNewLabel);
	}
}
