

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*; 
import javax.mail.Session; 
import javax.mail.Transport; 


public class SchedulerMain {
		public static void main(String args[]) throws InterruptedException {

			Timer time = new Timer(); // Instantiate Timer Object
			ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
			// Create Repetitively task for every 1 secs

			//for demo only.
			for (int i = 0; i <= 1000; i++) {
				System.out.println("Execution in Main Thread...." + i);
			
					System.out.println("Sending email at time"+ LocalDateTime.now());
					 String recipient = "kiranjntu2004@gmail.com"; 
					 String recipient2 = "ecommerce@airindia.in"; 
					 String recipient3 = "mobilebookings@airindia.in"; 
					  
				      // email ID of  Sender. 
				      String sender = "kiranjntu2004@gmail.com"; 
				  
				      // using host as localhost 
				      String host = "smtp.gmail.com"; 
				  
				      // Getting system properties 
				      Properties properties = System.getProperties(); 
				  
				      // Setting up mail server 
				      properties.setProperty("mail.smtp.host", host); 
				      properties.put("mail.smtp.port", "465");
				        properties.put("mail.smtp.ssl.enable", "true");
				        properties.put("mail.smtp.auth", "true");
				  
				      // creating session object to get properties 
				        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

				            protected PasswordAuthentication getPasswordAuthentication() {

				                return new PasswordAuthentication("<yourGmailId>", "<YourGmailPassword>");

				            }

				        });
				  
				      try 
				      { 
				         // MimeMessage object. 
				         MimeMessage message = new MimeMessage(session); 
				  
				         // Set From Field: adding senders email to from field. 
				         message.setFrom(new InternetAddress(sender)); 
				  
				         // Set To Field: adding recipient's email to from field. 
				         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
				         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient2)); 
				         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient3)); 
				  
				         // Set Subject: subject of the email 
				         //Change the content as needed
				         message.setSubject("Refund for Ticket - 0982133299022"); 
				  
				         // set body of the email. 
				             //Change the content as needed
				         message.setContent("<h2>Hi Team,\n" + 
				         		"\n" + 
				         		"It is over 5 months since I cancelled my ticket -0982133299022 it is over 9 weeks since you first said that refund has been processed and 4 weeks since you second said that money was refunded but till now money was not credited to my account.\n" + 
				         		"\n" + 
				         		"Please check on this and reply.\n" + 
				         		"\n" + 
				         		"Thanks,\n" + 
				         		"Kiran</h2>","text/html"); 
				  
				         // Send email. 
				         Transport.send(message); 
				         System.out.println("Mail successfully sent"); 
				      } 
				      catch (MessagingException mex)  
				      { 
				         mex.printStackTrace(); 
				      } 
				  	Thread.sleep(3600000);
					//Thread.sleep(3600000);
			}
		}

}
