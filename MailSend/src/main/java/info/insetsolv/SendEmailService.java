package info.insetsolv;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class SendEmailService {

    public void sendHtmlEmail(final MailDataRequest mailData) throws AddressException, MessagingException {

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailData.getFromMail(), mailData.getFromMailPassword());
            }
        };

        Session session = Session.getInstance(properties, auth);

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(mailData.getFromMail()));
        InternetAddress[] toAddresses = {new InternetAddress(mailData.getToMail())};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(mailData.getSubject());
        msg.setSentDate(new Date());
        // set plain text message
        msg.setContent(readFileData(mailData.getFilePath()), "text/html");

        // sends the e-mail
        Transport.send(msg);

    }

    private String readFileData(final String filePath) {
        try {
            return Jsoup.parse(new File(filePath), "UTF-8").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
