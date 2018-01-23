package za.co.student.fix.it.communication.engine.email.dto;

/**
 * Confirmation email response for carrying output that's from processing an email confirmation request
 */
public class EmailRegistrationConfirmationResponse {
    private Integer responseCode;
    private String responseMessage;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer aResponseCode) {
        responseCode = aResponseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String aResponseMessage) {
        responseMessage = aResponseMessage;
    }
}
