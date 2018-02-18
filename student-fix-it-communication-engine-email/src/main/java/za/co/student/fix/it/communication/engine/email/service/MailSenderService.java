package za.co.student.fix.it.communication.engine.email.service;

import za.co.student.fix.it.communication.engine.email.dto.EmailRegistrationConfirmationRequest;
import za.co.student.fix.it.communication.engine.email.dto.EmailRegistrationConfirmationResponse;

/**
 * This is the email service which is used to send email communication
 */
public interface MailSenderService {
    EmailRegistrationConfirmationResponse sendMail(EmailRegistrationConfirmationRequest emailRegistrationConfirmationRequest);
}

