package els;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;

@WebServlet(name = "SendMail", urlPatterns = { "/SendMail" })
public class SendMail extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String to = request.getParameter("recipient");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		Properties props= new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");
		
		Session session = Session.getInstance(props,
		        new javax.mail.Authenticator() {
			@Override 
		          protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication("askme.netify@gmail.com", "netify1234");
		          }
		        });
		
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("askme.netify@gmail.com"));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			msg.setSubject(subject);
			msg.setText(message);
			
			Transport.send(msg);
			 out.println("<html><body><h1>Email sent successfully!</h1></body></html>");
		}
		
		catch (MessagingException m){
			out.println("Error: Unable to send email");
		}
		
		out.print("Message has been sent successfully");
		
		out.close();
	}
}
