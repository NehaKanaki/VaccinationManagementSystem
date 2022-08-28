package com.cears.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;
import java.net.HttpURLConnection;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;


public class ForgotPassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				try {
					//int refs=1000+(int)(Math.random()*28);
				  //   txtmessage.setText("Your One Time Password is "+refs);
				    // jButton1.setVisible(true);
				     // Random r=new Random();
				      //int refs=r.nextInt(99999);
					String refs="Hello";
				   String apiKey = "apikey=" + "NjQzNzM0NTI2MzMyMzU3NTUxNTQ2NjM2NjE2MTUwNDU=";
				   String message = "&message=" + refs;
				   String sender = "&sender=" + "TXTLCL";
				   String numbers = "&numbers=" + "8421252118";
				                        
				   
				   HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
				   String data = apiKey + numbers + message + sender;
				   conn.setDoOutput(true);
				   conn.setRequestMethod("POST");
				   conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
				   conn.getOutputStream().write(data.getBytes("UTF-8"));
				   final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				   final StringBuffer stringBuffer = new StringBuffer();
				   String line;
				   while ((line = rd.readLine()) != null) {
				    
				                                JOptionPane.showMessageDialog(null,"message"+line);
				   }
				   rd.close();
				   
				   
				  } catch (Exception e1) {
				                    JOptionPane.showMessageDialog(null,e1);
				   }


			}
});
		btnNewButton.setBounds(271, 237, 105, 40);
		contentPane.add(btnNewButton);
		
		/*JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(72, 177, 45, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(211, 146, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);*/
	}
}

