package in.redeemer.alerts;

import in.redeemer.constants.Constants;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

public class Mail {
	public static boolean sendMail(String to,String msg) throws IOException
	{

	boolean mail_atate=true;	
		
    // Sender's email ID needs to be mentioned
    String from = Constants.FROM;//change accordingly
    final String username = Constants.FROM;//change accordingly
    final String user = Constants.USER;//change accordingly

    // Assuming you are sending email through relay.jangosmtp.net
    String host = "smtp.gmail.com";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.starttls.enable", "true"); 
    // Get the Session object.
    Session session = Session.getInstance(props,
    new javax.mail.Authenticator() {
       protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(username, user);
       }
    });

    try {
       // Create a default MimeMessage object.
       Message message = new MimeMessage(session);

       // Set From: header field of the header.
       message.setFrom(new InternetAddress(from));
       message.setRecipients(Message.RecipientType.TO,
    	       InternetAddress.parse(Constants.FROM));
       
       // Set To: header field of the header.
       message.setRecipients(Message.RecipientType.BCC,
       InternetAddress.parse(to));

       // Set Subject: header field
       message.setSubject(Constants.SUBJECT);

       // Now set the actual message
       String content=msg+Constants.BR+Constants.BR+Constants.DISCLAIMER;
       
       message.setDataHandler(new DataHandler(new ByteArrayDataSource(content.toString(),"text/html")));
	      
       // Send message
      Transport.send(message);
       System.out.println(content);
       System.out.println("Sent message successfully....");

    } catch (MessagingException e) {
    	mail_atate=false;
          throw new RuntimeException(e);
    }
    return mail_atate;
 }
}
