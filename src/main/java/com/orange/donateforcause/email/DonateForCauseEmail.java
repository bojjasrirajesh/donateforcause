package com.orange.donateforcause.email;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Utility class to generate mail.
 */
@Component
public class DonateForCauseEmail {

	private static final String TD_CLOSE = "</td>";
	public static final String BR = "<br>";
	public static final String TD_STYLE = "<td style=\"border:1px solid grey;\">";
	public static final Logger logger = LoggerFactory.getLogger(DonateForCauseEmail.class);

	private DonateForCauseEmail() {
	}

	@Autowired
	private Environment environment;

	/**
	 * Send email confirmation as donation successful.
	 * 
	 * @param filePath
	 * @param donorEmailId
	 */
	public void sendDonationPaymentConfirmationMail(String filePath, String donorEmailId, String donorName) {

		logger.debug("Inside DonateForCauseEmail :: sendDonationPaymentConfirmationMail.");

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");// 465

		// ********************************* IMPORTANT
		// ***********************************//
		String username = environment.getProperty("email.sender_mail");
		String password = "**********";

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		// *******************************************************************************//

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(environment.getProperty("email.sender_mail"),
					environment.getProperty("email.alias_mail")));
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(donorEmailId));
			message.setSubject(environment.getProperty("email.subject"));

			File folder = new File(environment.getProperty("pdf.file.path"));
			File[] listOfFiles = folder.listFiles();
			Multipart multipart = new MimeMultipart();
			BodyPart messageBodyText = new MimeBodyPart();
			StringBuilder sb = new StringBuilder();
			sb.append("Dear " + donorName).append(System.lineSeparator());

			// font color
			String fontColor = "<font color=\"green\">";

			sb.append(BR);
			sb.append(BR);
			sb.append("<table style=\"border:1px solid black;border-collapse:collapse;\" width=\"800px\">");
			sb.append("<tr>");
			sb.append("<th style=\"border:1px solid grey;\">Sl.No</th>");
			sb.append("<th style=\"border:1px solid grey;\">Donation Scheme</th>");
			sb.append("<th style=\"border:1px solid grey;\">Amount</th>");
			sb.append("<th style=\"border:1px solid grey;\">Tax Benefit Amount</th>");
			sb.append("<th style=\"border:1px solid grey;\">PAN</th>");
			sb.append("</tr>");

			sb.append("<tr>");
			sb.append(TD_STYLE).append(1).append(TD_CLOSE);
			sb.append(TD_STYLE).append(" ").append(TD_CLOSE);
			sb.append(TD_STYLE).append(fontColor).append(" ").append(TD_CLOSE);
			sb.append(TD_STYLE).append(fontColor).append(" ").append(TD_CLOSE);
			sb.append(TD_STYLE).append(fontColor).append(" ").append(TD_CLOSE);
			sb.append(TD_STYLE).append(fontColor).append(" ").append(TD_CLOSE);
			sb.append("</tr>");

			sb.append("</table>");

			messageBodyText.setText(sb.toString());
			multipart.addBodyPart(messageBodyText);

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					File att = new File(new File(filePath), listOfFiles[i].getName());
					messageBodyPart.attachFile(att);
					multipart.addBodyPart(messageBodyPart);
				}
			}
			message.setContent(multipart);
			Transport tr = session.getTransport("smtp");
			tr.send(message);
			tr.close();

		} catch (MessagingException | IOException e) {
			logger.error("Exception while sending donation payement confirmation mail.");
		}
	}
}