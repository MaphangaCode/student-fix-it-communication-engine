package za.co.student.fix.it.communication.engine.email.template;

/**
 * This is a class that defines templates for emails
 */
public class EmailTemplate {

    public static String registrationEmailTemplate(String recipientName, String senderName, String recipientId) {
        String email = String.format("<p>Greetings %s <p>", recipientName);
        email += String.format("<p> Your email account was used to register at student fix it. Click the following link to <a href=\"https://www.student-fix-it.co.za/registration/confirm-registration/%s</p> <p>Regards %s </p>", recipientId, senderName);
        email += String.format("<p>%s</p>", senderName);
        return email;
    }
}
