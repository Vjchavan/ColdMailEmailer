package org.example.sendmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class SendMail {

    String subject;
    String to;
    String from = "vjchavan582000@gmail.com";
    String company;
    String recruiterName;
    public static String message;

    public SendMail(String name, String companyName, String emailId) {
        this.recruiterName = name;
        this.company = companyName;
        this.to = emailId;
        this.message = "Dear "+ recruiterName + ",\n" +
                "\n" +
                "I hope you're doing well. I am currently exploring new opportunities and wanted to reach out regarding any available backend developer positions at "+ company +". \nWith over two years of experience in Java, Spring Boot, and microservices, I believe my skill set aligns well with your company’s needs.\n" +
                "\n" +
                "I would love to discuss any potential openings that match my expertise. Please find my resume attached for your review. Looking forward to hearing from you.\n" +
                "\n" +
                "Best regards,\n" +
                "Vijay Chavan\n" +
                "Mob: +91 9689756247\n" +
                "https://www.linkedin.com/in/vchavan/";
        this.subject = "Seeking Backend Developer Opportunities at "+company;
    }


    public void sendAttach() {
        //Variable for gmail
        String host="smtp.gmail.com";

        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES "+properties);

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //Step 1: to get the session object..
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "cemb ayso tnzv kgnp");
            }



        });

        session.setDebug(true);

        //Step 2 : compose the message [text,multi media]
        MimeMessage m = new MimeMessage(session);

        try {

            //from email
            m.setFrom(from);

            //adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //adding subject to message
            m.setSubject(subject);


            //attachement..

            //file path
            String path="/Users/panda/Downloads/Vijay_Chavan_Resume.pdf";
            //String signPath="/Users/panda/Downloads/Vijay.png";

            MimeMultipart mimeMultipart = new MimeMultipart();
            //text
            //file

            MimeBodyPart textMime = new MimeBodyPart();

            MimeBodyPart fileMime = new MimeBodyPart();

            // MimeBodyPart signMime = new MimeBodyPart();

            try {

                textMime.setText(message);

                File file=new File(path);
                // File signFile=new File(signPath);
                fileMime.attachFile(file);
                // signMime.attachFile(signFile);


                mimeMultipart.addBodyPart(textMime);
                // mimeMultipart.addBodyPart(signMime);
                mimeMultipart.addBodyPart(fileMime);


            } catch (Exception e) {

                e.printStackTrace();
            }


            m.setContent(mimeMultipart);


            //send

            //Step 3 : send the message using Transport class
            Transport.send(m);
            System.out.println("Mail sent to : " + recruiterName);



        }catch (Exception e) {
            e.printStackTrace();
        }








        System.out.println("Sent success...................");


    }
}
