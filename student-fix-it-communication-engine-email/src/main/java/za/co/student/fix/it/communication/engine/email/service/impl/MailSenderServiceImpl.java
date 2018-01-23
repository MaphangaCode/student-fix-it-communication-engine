package za.co.student.fix.it.communication.engine.email.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import za.co.student.fix.it.common.email.template.EmailTemplate;
import za.co.student.fix.it.communication.engine.email.dto.EmailRegistrationConfirmationRequest;
import za.co.student.fix.it.communication.engine.email.dto.EmailRegistrationConfirmationResponse;
import za.co.student.fix.it.communication.engine.email.service.MailSenderService;

import javax.mail.internet.MimeMessage;


/**
 * This is the email service implementation of mail sender service
 */
@Service
public class MailSenderServiceImpl implements MailSenderService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private JavaMailSender emailSender;

    /**
     * Implementation if tge send email functionality
     * @param emailRegistrationConfirmationRequest ..
     */
    @Override
    public EmailRegistrationConfirmationResponse sendMail(EmailRegistrationConfirmationRequest emailRegistrationConfirmationRequest) {
        LOGGER.info("sendMail - START");
        Long userId = emailRegistrationConfirmationRequest.getUserId();
        String destinationAddress = emailRegistrationConfirmationRequest.getEmailAddress();
        String senderName = emailRegistrationConfirmationRequest.getSenderName();
        String recipientName = emailRegistrationConfirmationRequest.getRecipientName();
        String cc = emailRegistrationConfirmationRequest.getCc();
        String registrationEmailTemplate = EmailTemplate.registrationEmailTemplate(recipientName, senderName, userId.toString());
        String subject = emailRegistrationConfirmationRequest.getSubject();
        EmailRegistrationConfirmationResponse registrationConfirmationResponse = new EmailRegistrationConfirmationResponse();;

        try{
            sendMail(destinationAddress, cc, subject, registrationEmailTemplate);
            registrationConfirmationResponse.setResponseCode(1);
            registrationConfirmationResponse.setResponseMessage("Success");
        }catch (Exception e) {
            LOGGER.info("An error occurred while trying to send email to mail address: {}", destinationAddress);
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("sendMail - END");
        return registrationConfirmationResponse;
    }

    private void sendMail(String destinationAddress, String cc, String subject, String message) throws Exception {
       MimeMessage mimeMessage = emailSender.createMimeMessage();
       MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
       mimeMessageHelper.setTo(destinationAddress);
       if(!cc.isEmpty() && (cc != null)) {
           mimeMessageHelper.addCc(cc);
       }
       mimeMessageHelper.setSubject(subject);
       mimeMessageHelper.setText(message);
       emailSender.send(mimeMessage);
    }

    @Autowired
    public void setEmailSender(JavaMailSender anEmailSender) {
        emailSender = anEmailSender;
    }
}