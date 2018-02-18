package za.co.student.fix.it.communication.engine.web.service;

import za.co.student.fix.it.common.registration.communication.engine.RegistrationConfirmationRequest;
import za.co.student.fix.it.common.registration.communication.engine.RegistrationConfirmationResponse;

/**
 * This is the communication engine web business service which is used to call the communication engine email part to
 * send communication via mail.
 */
public interface CommunicationEngineWebBusinessService {
    RegistrationConfirmationResponse sendEmail(RegistrationConfirmationRequest registrationConfirmationRequest);
}
