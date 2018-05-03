/**
 * 
 */
package com.marketplace.mail;

import org.springframework.mail.SimpleMailMessage;

/**
 * @author sepehrsafari
 *
 */
public interface EmailService {
	/**
     * Sends an email with the content in the Feedback Pojo.
     * @param feedbackPojo The feedback Pojo
     */
    public void sendFeedbackEmail(Feedback feedback);

    /**
     * Sends an email with the content of the Simple Mail Message object.
     * @param message The object containing the email content
     */
    public void sendGenericEmailMessage(SimpleMailMessage message);

}
