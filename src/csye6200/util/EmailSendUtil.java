package csye6200.util;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import csye6200.constants.Constants;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

public class EmailSendUtil {
    private static String email_sender = "" ;

    private static String email_host = "";

    private static String email_certificate = "";

    private static String email_receivers = "";

    private static int email_start = 9;

    private static int email_end = 12;


    static {
        try {
            Properties properties = new Properties();

            InputStream in = new FileInputStream(Constants.PROPERTIE_FILE_NAME);

            properties.load(in);

            email_sender = properties.getProperty("email.sender");

            email_host = properties.getProperty("email.host");

            email_certificate = properties.getProperty("email.certificate");

            email_receivers = properties.getProperty("email.receivers");

            String startMonth = properties.getProperty("email.start");

            email_start = Strings.isNullOrEmpty(startMonth)?email_start:Integer.parseInt(startMonth);

            String endMonth = properties.getProperty("email.start");

            email_end = Strings.isNullOrEmpty(endMonth)?email_end:Integer.parseInt(endMonth);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void sendEmail(String subject,String content){
        if(Strings.isNullOrEmpty(email_certificate) || Strings.isNullOrEmpty(email_host)|| Strings.isNullOrEmpty(email_receivers)
                ||Strings.isNullOrEmpty(email_sender)){
            return;
        }

        LocalDate now = LocalDate.now();
        if(now.getMonthValue() < email_start || now.getMonthValue() > email_end) return;

        Properties properties = System.getProperties();

        // set server
        properties.setProperty("mail.smtp.host", email_host);

        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(email_sender, email_certificate);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(email_sender));

            List<String> receivers = Splitter.on(",").trimResults().splitToList(email_receivers);

            for(String receiver :receivers) {
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(receiver));

            }
            message.setSubject(subject);

            message.setText(content);

            Transport.send(message);
            System.out.println("Send email successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

