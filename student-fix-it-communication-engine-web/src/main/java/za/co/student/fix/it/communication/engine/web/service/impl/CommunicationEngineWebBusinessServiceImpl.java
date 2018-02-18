package za.co.student.fix.it.communication.engine.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.student.fix.it.common.registration.communication.engine.RegistrationConfirmationRequest;
import za.co.student.fix.it.common.registration.communication.engine.RegistrationConfirmationResponse;
import za.co.student.fix.it.common.registration.communication.engine.dto.RegistrationConfirmationCommunicationDto;
import za.co.student.fix.it.communication.engine.email.dto.EmailRegistrationConfirmationRequest;
import za.co.student.fix.it.communication.engine.email.dto.EmailRegistrationConfirmationResponse;
import za.co.student.fix.it.communication.engine.email.service.MailSenderService;
import za.co.student.fix.it.communication.engine.web.service.CommunicationEngineWebBusinessService;

/**
 * This is the business service of the web communication engine section
 */
@Service
public class CommunicationEngineWebBusinessServiceImpl implements CommunicationEngineWebBusinessService{

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private MailSenderService mailSenderService;

    public RegistrationConfirmationResponse sendEmail(RegistrationConfirmationRequest registrationConfirmationRequest) {
        LOGGER.info("sendEmail - START");
        EmailRegistrationConfirmationRequest request = buildEmailRegistrationConfirmationRequest(registrationConfirmationRequest);
        EmailRegistrationConfirmationResponse emailRegistrationConfirmationResponse = mailSenderService.sendMail(request);
        LOGGER.info("sendEmail - END");
        return buildRegistrationConfirmationResponse(emailRegistrationConfirmationResponse);
    }

    private EmailRegistrationConfirmationRequest buildEmailRegistrationConfirmationRequest(RegistrationConfirmationRequest registrationConfirmationRequest) {
       LOGGER.debug("buildEmailRegistrationConfirmationRequest - START");
       EmailRegistrationConfirmationRequest request = new EmailRegistrationConfirmationRequest();

       RegistrationConfirmationCommunicationDto registrationConfirmationCommunicationDto = registrationConfirmationRequest.getRegistrationConfirmationCommunicationDto();
       request.setEmailAddress(registrationConfirmationCommunicationDto.getEmailAddress());
       request.setRecipientName(registrationConfirmationCommunicationDto.getRecipientName());
       request.setUserId(registrationConfirmationRequest.getUserId());
       request.setCc(registrationConfirmationCommunicationDto.getCc());
       request.setSenderName(registrationConfirmationCommunicationDto.getSenderName());
       request.setSubject(registrationConfirmationCommunicationDto.getSubject());
       LOGGER.debug("buildEmailRegistrationConfirmationRequest - END");
       return request;
    }

    private RegistrationConfirmationResponse buildRegistrationConfirmationResponse(EmailRegistrationConfirmationResponse emailRegistrationConfirmationResponse) {
        LOGGER.info("buildRegistrationConfirmationResponse - START");
        RegistrationConfirmationResponse registrationConfirmationResponse = new RegistrationConfirmationResponse();
        registrationConfirmationResponse.setResponseCode(emailRegistrationConfirmationResponse.getResponseCode());
        registrationConfirmationResponse.setResponseMessage(emailRegistrationConfirmationResponse.getResponseMessage());
        LOGGER.info("buildRegistrationConfirmationResponse - END");
        return registrationConfirmationResponse;
    }

    @Autowired
    public void setMailSenderService(MailSenderService aMailSenderService) {
        mailSenderService = aMailSenderService;
    }
}
