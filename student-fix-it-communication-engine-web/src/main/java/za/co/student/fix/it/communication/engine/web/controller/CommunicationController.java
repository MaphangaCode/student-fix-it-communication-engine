package za.co.student.fix.it.communication.engine.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.co.student.fix.it.common.registration.communication.engine.RegistrationConfirmationRequest;
import za.co.student.fix.it.common.registration.communication.engine.RegistrationConfirmationResponse;
import za.co.student.fix.it.communication.engine.web.service.CommunicationEngineWebBusinessService;

/**
 * This is the rest endpoint for the communication engine
 */
@RestController
@RequestMapping("/student-fix-it/communication")
public class CommunicationController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private CommunicationEngineWebBusinessService communicationEngineWebBusinessService;

    @RequestMapping(value = "/email/registration-confirmation", method = RequestMethod.POST)
    @ResponseBody
    public RegistrationConfirmationResponse sendRegistrationConfirmationEmail(@RequestBody final RegistrationConfirmationRequest registrationConfirmationRequest) {
        LOGGER.info("sendRegistrationConfirmationEmail - START");
        RegistrationConfirmationResponse registrationConfirmationResponse;
        registrationConfirmationResponse = communicationEngineWebBusinessService.sendEmail(registrationConfirmationRequest);
        LOGGER.info("sendRegistrationConfirmationEmail - END");
        return registrationConfirmationResponse;
    }

    @Autowired
    public void setCommunicationEngineWebBusinessService(CommunicationEngineWebBusinessService aCommunicationEngineWebBusinessService) {
        communicationEngineWebBusinessService = aCommunicationEngineWebBusinessService;
    }
}
