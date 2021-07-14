package info.insetsolv;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MailDataRequest {

    private String fromMail;
    private String toMail;
    private String fromMailPassword;
    private String filePath;
    private String subject;

    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    public String getFromMailPassword() {
        return fromMailPassword;
    }

    public void setFromMailPassword(String fromMailPassword) {
        this.fromMailPassword = fromMailPassword;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public MailDataRequest(String fromMail, String toMail, String fromMailPassword, String filePath, String subject) {
        super();
        this.fromMail = fromMail;
        this.toMail = toMail;
        this.fromMailPassword = fromMailPassword;
        this.filePath = filePath;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "MailDataRequest [fromMail=" + fromMail + ", toMail=" + toMail + ", fromMailPassword=" + fromMailPassword
                + ", filePath=" + filePath + ", subject=" + subject + "]";
    }

    public MailDataRequest() {
        super();
// TODO Auto-generated constructor stub
    }
}
