package org.example;

import org.example.readcsv.ReadExcel;

public class App {
    public static void main(String[] args) {

        ReadExcel readExcel = new ReadExcel();
        readExcel.readFile();
    }
//
//    //this is responsible to send the message with attachment
//    private static void sendAttach(String message, String subject, String to, String from) {
//
//        //Variable for gmail
//        String host="smtp.gmail.com";
//
//        //get the system properties
//        Properties properties = System.getProperties();
//        System.out.println("PROPERTIES "+properties);
//
//        //setting important information to properties object
//
//        //host set
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port","465");
//        properties.put("mail.smtp.ssl.enable","true");
//        properties.put("mail.smtp.auth","true");
//
//        //Step 1: to get the session object..
//        Session session=Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(from, "cemb ayso tnzv kgnp");
//            }
//
//
//
//        });
//
//        session.setDebug(true);
//
//        //Step 2 : compose the message [text,multi media]
//        MimeMessage m = new MimeMessage(session);
//
//        try {
//
//            //from email
//            m.setFrom(from);
//
//            //adding recipient to message
//            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            //adding subject to message
//            m.setSubject(subject);
//
//
//            //attachement..
//
//            //file path
//            String path="/Users/panda/Downloads/Resume.pdf";
//            //String signPath="/Users/panda/Downloads/Vijay.png";
//
//            MimeMultipart mimeMultipart = new MimeMultipart();
//            //text
//            //file
//
//            MimeBodyPart textMime = new MimeBodyPart();
//
//            MimeBodyPart fileMime = new MimeBodyPart();
//
//           // MimeBodyPart signMime = new MimeBodyPart();
//
//            try {
//
//                textMime.setText(message);
//
//                File file=new File(path);
//               // File signFile=new File(signPath);
//                fileMime.attachFile(file);
//               // signMime.attachFile(signFile);
//
//
//                mimeMultipart.addBodyPart(textMime);
//               // mimeMultipart.addBodyPart(signMime);
//                mimeMultipart.addBodyPart(fileMime);
//
//
//            } catch (Exception e) {
//
//                e.printStackTrace();
//            }
//
//
//            m.setContent(mimeMultipart);
//
//
//            //send
//
//            //Step 3 : send the message using Transport class
//            Transport.send(m);
//
//
//
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//
//
//
//
//
//        System.out.println("Sent success...................");
//
//
//    }
//
//    //this is responsible to send email..
//    private static void sendEmail(String message, String subject, String to, String from) {
//
//        //Variable for gmail
//        String host="smtp.gmail.com";
//
//        //get the system properties
//        Properties properties = System.getProperties();
//        System.out.println("PROPERTIES "+properties);
//
//        //setting important information to properties object
//
//        //host set
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port","465");
//        properties.put("mail.smtp.ssl.enable","true");
//        properties.put("mail.smtp.auth","true");
//
//        //Step 1: to get the session object..
//        Session session=Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("techsoftindia2018@gmail.com", "Durgesh@123");
//            }
//
//
//
//        });
//
//        session.setDebug(true);
//
//        //Step 2 : compose the message [text,multi media]
//        MimeMessage m = new MimeMessage(session);
//
//        try {
//
//            //from email
//            m.setFrom(from);
//
//            //adding recipient to message
//            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            //adding subject to message
//            m.setSubject(subject);
//
//
//            //adding text to message
//            m.setText(message);
//
//            //send
//
//            //Step 3 : send the message using Transport class
//            Transport.send(m);
//
//            System.out.println("Sent success...................");
//
//
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
