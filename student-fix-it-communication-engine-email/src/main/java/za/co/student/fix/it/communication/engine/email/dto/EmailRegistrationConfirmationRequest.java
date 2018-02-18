package za.co.student.fix.it.communication.engine.email.dto;

/**
 * Email registration confirmation request which is used to carry
 * information for a registration confirmation request that's being
 * processed, e.g being sent to a member.
 */
public class EmailRegistrationConfirmationRequest {
    private Long userId;
    private String emailAddress;
    private String cc;
    private String subject;
    private String recipientName;
    private String senderName;
    private String template;
    private String message;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long aUserId) {
        userId = aUserId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String aEmailAddress) {
        emailAddress = aEmailAddress;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String aCc) {
        cc = aCc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String aSubject) {
        subject = aSubject;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String aRecipientName) {
        recipientName = aRecipientName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String aSenderName) {
        senderName = aSenderName;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String aTemplate) {
        template = aTemplate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String aMessage) {
        message = aMessage;
    }
}
