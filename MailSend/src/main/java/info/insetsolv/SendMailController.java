package info.insetsolv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

@RestController
public class SendMailController {

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping("/sendMail")
    public String SendMail(@RequestBody final MailDataRequest request) {
        try {
            sendEmailService.sendHtmlEmail(request);
        } catch (AddressException e) {
            e.printStackTrace();
            return "Mail sending is unsuccessfull";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Mail sending is unsuccessfull";
        }
        return "sent mail successFully";
    }
}
