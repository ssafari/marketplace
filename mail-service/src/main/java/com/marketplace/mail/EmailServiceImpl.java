package com.marketplace.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;



@Service
public class EmailServiceImpl implements EmailService {
	
	 private static final Logger LOG = LoggerFactory.getLogger(EmailServiceImpl.class);
	 
	@Value("${default.mailing.address}")
    private String toAddress;
	
	@Autowired
    private MailSender mailSender;
	
    /**
     * Creates a Simple Mail Message from a Feedback Pojo.
     * @param feedback The Feedback pojo
     * @return
     */
    protected SimpleMailMessage prepareSimpleMailMessageFromFeedbackPojo(Feedback feedback) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toAddress);
        message.setFrom(feedback.getEmail());
        message.setReplyTo(feedback.getEmail());
        message.setSubject("Feedback received from " + feedback.getFirstName() + " " + feedback
                .getLastName() + "!");
        message.setText("User with email: " + feedback.getEmail() + " left this feedback:\n" + feedback.getFeedback());
        return message;
    }

    @Override
    public void sendFeedbackEmail(Feedback feedbackPojo) {
        sendGenericEmailMessage(prepareSimpleMailMessageFromFeedbackPojo(feedbackPojo));
    }

	@Override
	public void sendGenericEmailMessage(SimpleMailMessage message) {
        message.setTo(toAddress);
        message.setFrom("sdnsoft@gmail.com");
        message.setReplyTo("sdnsoft@gmail.com");
        message.setSubject("Registration confirmed");
        LOG.info("Sending email to: {}", toAddress);
        mailSender.send(message);
        LOG.info("Email sent.");
	}

}
