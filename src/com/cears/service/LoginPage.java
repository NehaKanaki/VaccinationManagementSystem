package com.cears.service;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private static JTextField txtUsername;
	private JTextField txtPassword;
	private JPasswordField passwordField;
	int OTP;
public static String username;
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
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920,1080);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		JButton HomeButton = new JButton("");
		HomeButton.setBounds(1465, 10, 65, 58);
		HomeButton.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\nnnn.png"));
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_Page hp=new Home_Page();
				hp.setVisible(true);
				setVisible(false);
		
			}
		});
		contentPane.setLayout(null);
		HomeButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(HomeButton);
		
		JLabel LogoLabel = new JLabel("");
		LogoLabel.setBounds(1153, 156, 162, 159);
		contentPane.add(LogoLabel);
		LogoLabel.setFocusTraversalPolicyProvider(true);
		LogoLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\ssss.png"));
		
		txtUsername = new JTextField();
		txtUsername.setBounds(1123, 349, 294, 36);
		contentPane.add(txtUsername);
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					if(txtUsername.getForeground()!=Color.black) {
						if(txtUsername.getText().equals("Enter Username")) {
							txtUsername.setText("");
						}
					}
					txtUsername.setForeground(Color.black);
				}
		});
		
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsername.setForeground(Color.LIGHT_GRAY);
		txtUsername.setText("Enter Username");
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(1123, 438, 251, 33);
		contentPane.add(passwordField);
		passwordField.setEchoChar('*');
		
		JLabel UserLogoLabel = new JLabel("");
		UserLogoLabel.setBounds(1064, 349, 45, 33);
		contentPane.add(UserLogoLabel);
		UserLogoLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\abc.png"));
		
		JLabel PassLogoLabel = new JLabel("");
		PassLogoLabel.setBounds(1074, 427, 39, 51);
		contentPane.add(PassLogoLabel);
		PassLogoLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Picture....png"));
		
		JToggleButton EyeIconButton = new JToggleButton("");
		EyeIconButton.setBounds(1371, 438, 33, 33);
		contentPane.add(EyeIconButton);
		EyeIconButton.setBorderPainted(false);
		EyeIconButton.setContentAreaFilled(false);
		EyeIconButton.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\EyeIcon.png"));
		
		JLabel UserErrorLabel = new JLabel("");
		UserErrorLabel.setBounds(1121, 384, 194, 20);
		contentPane.add(UserErrorLabel);
		UserErrorLabel.setForeground(Color.RED);
		UserErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel PasswordErrorLabel = new JLabel("");
		PasswordErrorLabel.setBounds(1123, 470, 162, 20);
		contentPane.add(PasswordErrorLabel);
		PasswordErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PasswordErrorLabel.setForeground(Color.RED);
		UserErrorLabel.setVisible(false);
		UserErrorLabel.setVisible(false);
		EyeIconButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(EyeIconButton.isSelected())
				passwordField.setEchoChar((char)0);
				else
					passwordField.setEchoChar('*');
			}
		});
	
		JButton LoginButton = new JButton("Login");
		LoginButton.setBounds(1180, 500, 133, 40);
		contentPane.add(LoginButton);
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				username = txtUsername.getText();
				String password= passwordField.getText();
				
				if(txtUsername.getForeground()!=Color.black) {
				if(txtUsername.getText().equals("Enter Username"))
				{
					UserErrorLabel.setText("Username Required *");
					UserErrorLabel.setVisible(true);
				}
				}
				if(password.equals(""))
				{
					PasswordErrorLabel.setText("Password Required *");
					PasswordErrorLabel.setVisible(true);
				}
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vmsdatabase","root","root2004");
					String query = "SELECT * FROM registration where'"+username+"'=  emailId and '"+password+"' = password";
					Statement st = con.createStatement();
					rs = st.executeQuery(query);
					
					if(rs.next())
					{
						DashBoard db = new DashBoard();
						db.setVisible(true);
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Username and Password");
					}
						
				}
				
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		
		JButton btnNewButton = new JButton("SignUp/Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationPage rp=new RegistrationPage();
				rp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(1295, 645, 245, 51);
		contentPane.add(btnNewButton);
			
		JLabel BackgroundImageLabel = new JLabel("");
		BackgroundImageLabel.setBounds(-18, -47, 1582, 882);
		BackgroundImageLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Picture14.jpg"));
		contentPane.add(BackgroundImageLabel);
	}
}


