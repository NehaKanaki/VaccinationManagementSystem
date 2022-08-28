package com.cears.service;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import com.cears.dao.DatabaseConnectivity;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrationPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmailId;
	private JTextField txtPhoneNo;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	String Gender;
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
					RegistrationPage frame = new RegistrationPage();
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
	public RegistrationPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1603,1021);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel FirstNameErrorLabel = new JLabel("");
		FirstNameErrorLabel.setBounds(536, 96, 89, 21);
		contentPane.add(FirstNameErrorLabel);
		
		txtFirstName = new JTextField();
		txtFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(txtFirstName.getForeground()!=Color.black) {
					if(txtFirstName.getText().equals("First Name")) {
						txtFirstName.setText("");
					}
				}
				txtFirstName.setForeground(Color.black);
			
				if(!(Character.isDigit(e.getKeyChar()))) {
					FirstNameErrorLabel.setText("");
					txtFirstName.setEditable(true);
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						txtFirstName.setEditable(true);
					}else {
						txtFirstName.setEditable(true);
						FirstNameErrorLabel.setText("Invalid");
						FirstNameErrorLabel.setForeground(Color.red);
					}
			}
			}
		});
		txtFirstName.setBounds(536, 117, 208, 33);
		txtFirstName.setText("First Name");
		txtFirstName.setForeground(Color.LIGHT_GRAY);
		txtFirstName.setFont(new Font("Monospaced", Font.PLAIN, 20));
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel LastNameErrorLabel= new JLabel("");
		LastNameErrorLabel.setBounds(794, 96, 89, 21);
		contentPane.add(LastNameErrorLabel);
		
		txtLastName = new JTextField();
		txtLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(txtLastName.getForeground()!=Color.black) {
					if(txtLastName.getText().equals("Last Name")) {
						txtLastName.setText("");
					}
				}
				txtLastName.setForeground(Color.black);
			
				if(!(Character.isDigit(e.getKeyChar()))) {
					LastNameErrorLabel.setText("");
					txtLastName.setEditable(true);
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						txtLastName .setEditable(true);
					}else {
						txtLastName.setEditable(true);
						LastNameErrorLabel.setText("Invalid");
						LastNameErrorLabel.setForeground(Color.red);
					}
				}
			}
		});
		txtLastName.setBounds(794, 117, 208, 33);
		txtLastName.setText("Last Name");
		txtLastName.setForeground(Color.LIGHT_GRAY);
		txtLastName.setFont(new Font("Monospaced", Font.PLAIN, 20));
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel EmailErrorLabel = new JLabel("");
		EmailErrorLabel.setBounds(536, 163, 178, 21);
		EmailErrorLabel.setForeground(Color.RED);
		EmailErrorLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		contentPane.add(EmailErrorLabel);
		
		JLabel EmailIdIconLabel = new JLabel("");
		EmailIdIconLabel.setBounds(493, 193, 37, 23);
		contentPane.add(EmailIdIconLabel);
		EmailIdIconLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\email.png"));
		
		txtEmailId = new JTextField();
		txtEmailId.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtEmailId.setText("abc@gmail.com");
		txtEmailId.setForeground(Color.LIGHT_GRAY);
		txtEmailId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(	txtEmailId.getForeground()!=Color.black) {
					if(	txtEmailId.getText().equals("abc@gmail.com")) {
						txtEmailId.setText("@gmail.com");
					}
				}
				txtEmailId.setForeground(Color.black);
				String PATTERN = "^[a-zA-Z0-9.]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txtEmailId.getText());
				if(!match.matches()) {
					EmailErrorLabel.setText("Incorrect email");
				}else {
					EmailErrorLabel.setText(null);
				}
			}
		});
		txtEmailId.setBounds(536, 183, 208, 33);
		contentPane.add(txtEmailId);
		txtEmailId.setColumns(10);
		
		JLabel PhoneNoIconLabel = new JLabel("");
		PhoneNoIconLabel.setBounds(767, 183, 27, 37);
		contentPane.add(PhoneNoIconLabel);
		PhoneNoIconLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\phone.png"));
		
		JLabel PhoneNoErrorLabel = new JLabel("");
		PhoneNoErrorLabel.setBounds(794, 163, 208, 21);
		contentPane.add(PhoneNoErrorLabel);
		PhoneNoErrorLabel.setForeground(Color.RED);
		PhoneNoErrorLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		txtPhoneNo = new JTextField();
		txtPhoneNo.setBounds(794, 183, 208, 33);
		txtPhoneNo.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtPhoneNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String phoneNo =  txtPhoneNo.getText();
				int length = phoneNo.length();
				char c = e.getKeyChar();
				
				if(phoneNo.matches("^[0-9]$")&& phoneNo.length()==10)
				{
				}
				
				if(e.getKeyChar()>='0'&& e.getKeyChar()<='9') {
					if(length==0&&e.getKeyChar()>='0'&& e.getKeyChar()<='5') {
						PhoneNoErrorLabel.setText("Enter valid number");
						PhoneNoErrorLabel.setVisible(true);
					}
					if(length<10) {
						txtPhoneNo.setEditable(true);
					}else {

						txtPhoneNo.setEditable(false);
					}
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE|| e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						txtPhoneNo.setEditable(true);
						PhoneNoErrorLabel.setText("");
					}else {
						txtPhoneNo.setEditable(false);
						
					}
				}
				}
		});
		contentPane.add(txtPhoneNo);
		txtPhoneNo.setColumns(10);
		
		JLabel GenderIconLabel = new JLabel("");
		GenderIconLabel.setBounds(493, 260, 29, 33);
		contentPane.add(GenderIconLabel);
		GenderIconLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\Gender.png"));
		
		JLabel GenderLabel = new JLabel("Gender :");
		GenderLabel.setBounds(540, 260, 113, 33);
		contentPane.add(GenderLabel);
		GenderLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JRadioButton MaleRadioButton = new JRadioButton("Male");
		MaleRadioButton.setBounds(659, 267, 103, 21);
		contentPane.add(MaleRadioButton);
		MaleRadioButton.setContentAreaFilled(false);
		MaleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JRadioButton FemaleRadioButton = new JRadioButton("Female");
		FemaleRadioButton.setBounds(767, 267, 103, 21);
		contentPane.add(FemaleRadioButton);
		FemaleRadioButton.setContentAreaFilled(false);
		FemaleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		ButtonGroup bn = new ButtonGroup();
		bn.add(MaleRadioButton);
		bn.add(FemaleRadioButton);
		
		JLabel AddressIconLabel = new JLabel("");
		AddressIconLabel.setBounds(497, 328, 33, 31);
		contentPane.add(AddressIconLabel);
		AddressIconLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\home.png"));
		
		JLabel AddressLabel = new JLabel("Address :");
		AddressLabel.setBounds(536, 328, 125, 33);
		contentPane.add(AddressLabel);
		AddressLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JTextArea AddresstextArea = new JTextArea();
		AddresstextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		AddresstextArea.setBounds(637, 336, 265, 134);
		contentPane.add(AddresstextArea);
		
		JLabel DOBLabel = new JLabel("DOB :");
		DOBLabel.setBounds(524, 483, 94, 33);
		contentPane.add(DOBLabel);
		DOBLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(599, 489, 155, 27);
		contentPane.add(dateChooser);

		JLabel PassKeyIconLabel = new JLabel("");
		PassKeyIconLabel.setBounds(547, 550, 29, 21);
		contentPane.add(PassKeyIconLabel);
		PassKeyIconLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\password.png"));
		
		JLabel PasswordLabel = new JLabel("Enter Password");
		PasswordLabel.setBounds(586, 550, 176, 21);
		contentPane.add(PasswordLabel);
		PasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(767, 538, 200, 33);
		contentPane.add(passwordField_1);
		passwordField_1.setEchoChar('*');
		
		JLabel ConfPassKeyIconLabel = new JLabel("");
		ConfPassKeyIconLabel.setBounds(522, 630, 27, 21);
		contentPane.add(ConfPassKeyIconLabel);
		ConfPassKeyIconLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\password.png"));

		JLabel ConfirmPasswordLabel = new JLabel("Confirm Password");
		ConfirmPasswordLabel.setBounds(562, 630, 200, 21);
		contentPane.add(ConfirmPasswordLabel);
		ConfirmPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(767, 618, 200, 33);
		contentPane.add(passwordField_2);
		passwordField_2.setEchoChar('*');
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(536, 152, 89, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(794, 152, 89, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(536, 219, 208, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(794, 219, 89, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(550, 290, 89, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(536, 355, 89, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(524, 519, 89, 21);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(559, 570, 203, 21);
		lblNewLabel_7.setVisible(false);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(559, 653, 408, 21);
		contentPane.add(lblNewLabel_8);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(MaleRadioButton.isSelected()) 
					Gender="Male";
				else
					Gender="Female";
				
				//String PATTERN = "^(?=.\\d)(?=.[a-z])(?=.[A-Z])(?=.[@#$%&!~^]).{8,20}$";
				String PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(passwordField_1.getText());
				if(!match.matches()) {
					lblNewLabel_7.setVisible(true);
					lblNewLabel_7.setText("Please set strong password!");
					lblNewLabel_7.setForeground(Color.red);
				}else {
					lblNewLabel_7.setText(null);
				}
				
				if(!passwordField_2.getText().equals(passwordField_1.getText())) {
				lblNewLabel_8.setText("Confirm password is not the same as password!");
				lblNewLabel_8.setForeground(Color.red);
				}
				else {
					lblNewLabel_8.setText("");
				}
				
				if(txtFirstName.getText().equals("First Name"))
				{
					lblNewLabel.setForeground(Color.red);
					lblNewLabel.setText("Required *");
				}
				
				if(txtLastName.getText().equals("Last Name"))
				{
					lblNewLabel_1.setForeground(Color.red);
					lblNewLabel_1.setText("Required *");
				}
				
				if(txtEmailId.getText().equals("abc@gmail.com"))
				{
					lblNewLabel_2.setForeground(Color.red);
					lblNewLabel_2.setText("Required *");
				}
			
				if(txtPhoneNo.getText().equals(""))
				{
					lblNewLabel_3.setForeground(Color.red);
					lblNewLabel_3.setText("Required *");
				}
				
				if(!MaleRadioButton.isSelected()&&!FemaleRadioButton.isSelected())
				{
					lblNewLabel_4.setForeground(Color.red);
					lblNewLabel_4.setText("Required *");
				}
				
				if(AddresstextArea.getText().equals(""))
				{
					lblNewLabel_5.setForeground(Color.red);
					lblNewLabel_5.setText("Required *");
				}
	
				if(((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().isEmpty()) {
					    lblNewLabel_6.setForeground(Color.red);
					 	lblNewLabel_6.setText("Required *");
					}
				if(passwordField_1.getPassword().length==0) {
					lblNewLabel_7.setText("Required *");
				}
				if(passwordField_2.getPassword().length==0) {
					lblNewLabel_8.setForeground(Color.red);
					lblNewLabel_8.setText("Required *");
				}
				
				else
				{
					String dob = dateChooser.getDate().toString();
					ArrayList<String> list=new ArrayList<> ();
					list.add(txtFirstName.getText());
					list.add(txtLastName.getText());
					list.add(txtEmailId.getText());
					list.add(txtPhoneNo.getText());
					list.add(Gender);
					list.add(AddresstextArea.getText());
					list.add(dob);
					list.add(passwordField_1.getText());
					list.add(passwordField_2.getText());
					
					DatabaseConnectivity db=new DatabaseConnectivity();
					int count=db.insert(list);
					String st="Done";
					JOptionPane.showMessageDialog(null,"Registered Successfully",st,JOptionPane.INFORMATION_MESSAGE,null);
					
				}
			}
		});
		SubmitButton.setBounds(599, 724, 115, 33);
		contentPane.add(SubmitButton);
		SubmitButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton button = new JButton("Reset");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFirstName.setText("");
				txtLastName.setText("");
				txtEmailId.setText("");
				txtPhoneNo.setText("");
				bn.clearSelection();
				AddresstextArea.setText("");
				dateChooser.setDate(null);
				passwordField_1.setText("");
				passwordField_2.setText("");
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(785, 724, 98, 31);
		contentPane.add(button);
		
		JButton btnGotoLogin = new JButton("GoTo Login");
		btnGotoLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage login=new LoginPage();
				login.setVisible(true);
				setVisible(false);
			}
		});
		btnGotoLogin.setForeground(Color.BLUE);
		btnGotoLogin.setBorderPainted(false);
		btnGotoLogin.setContentAreaFilled(false);
		btnGotoLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGotoLogin.setBounds(888, 763, 173, 21);
		contentPane.add(btnGotoLogin);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("");
		tglbtnNewToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tglbtnNewToggleButton.isSelected())
					passwordField_1.setEchoChar((char)0);
					else
						passwordField_1.setEchoChar('\u25cf');
			}
		});
		tglbtnNewToggleButton.setBorderPainted(false);
		tglbtnNewToggleButton.setContentAreaFilled(false);
		tglbtnNewToggleButton.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\EyeIcon.png"));
		tglbtnNewToggleButton.setBounds(966, 538, 27, 33);
		contentPane.add(tglbtnNewToggleButton);
		
		JLabel BackgroundLabel = new JLabel("");
		BackgroundLabel.setIcon(new ImageIcon("D:\\Eclipse Workshop\\VaccinationManagementSystem\\src\\Images\\RegistrationBackgroundImage.png"));
		BackgroundLabel.setBounds(0, 0, 1590, 887);
		contentPane.add(BackgroundLabel);		
	}
}
