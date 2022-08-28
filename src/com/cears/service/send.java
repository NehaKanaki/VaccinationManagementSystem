package com.cears.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class send {

	public static void send(String message,String number,String apiKey)
	{
		try
		{
		String sendId="FSTSMS";
		String language="english";
		String route="p";
		
		message=URLEncoder.encode(message,"UTF-8");    //Important Step
		
		String myUrl="https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;

		URL url=new URL(myUrl);
		HttpsURLConnection con= (HttpsURLConnection)url.openConnection();
		
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User-Agent","Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		System.out.println("Wait......");
		int responseCode=  con.getResponseCode();
		System.out.println("Response Code:"+responseCode);
		StringBuffer response=new StringBuffer();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		while(true)
		{
			String line=br.readLine();
			
			if(line==null)
			{
				break;
			}
			
			response.append(line);
		}
		
		System.out.println(response);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

        public static void main(String[] args) 
	{
		   System.out.println("Program Started....");
		   
		   otp ot=new otp();
		   String otpmessage=ot.generateOTP(5);
		   System.out.println( "Generate OTP : "+otpmessage);
		   
		   String apiKey="AtKjPfQhBPLg3ZDuvksvrqYGS2xr0fBvBQB5qqkB4W9FoITG6uuFRAYCtYjv";
		   String number="9890941640";
		   
		   send("Dear User,\n"+otpmessage+"your one time password (OTP).Please enter OTP to proceed.\nThank You,\nOne Nation One Care",number,apiKey);
		 
	}
	
}
