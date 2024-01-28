package com.gadgets.repair.system.services.email;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Personalization;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {
    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;
    @Value("${sendgrid.email.from}")
    private String fromEmail;
    @Value("${sendgrid.confirmation.template}")
    private String confirmationTemplate;
    @Value("${sendgrid.completion.template}")
    private String completionTemplate;

    @Override
    public void sendConfirmationEmail(String customerEmail, String customerFirstName, String customerLastName,
                                      Long ticketId, LocalDate estimatedCompletionDate, String technicianEmail) {
        SendGrid sendGrid = new SendGrid(sendGridApiKey);
        Mail confirmationMail = prepareConfirmationMail(customerEmail, customerFirstName, customerLastName, ticketId, estimatedCompletionDate, technicianEmail);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(confirmationMail.build());

            Response response = sendGrid.api(request);

            log.info(response.getBody());
            log.info(response.getHeaders().toString());

        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    @Override
    public void sendCompletionEmail(String customerEmail, String customerFirstName, String customerLastName, Long ticketId) {
        SendGrid sendGrid = new SendGrid(sendGridApiKey);
        Mail completionEmail = prepareCompletionEmail(customerEmail, customerFirstName, customerLastName, ticketId);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(completionEmail.build());

            Response response = sendGrid.api(request);

            log.info(response.getBody());
            log.info(response.getHeaders().toString());

        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    private Mail prepareCompletionEmail(String customerEmail, String customerFirstName, String customerLastName, Long ticketId) {
        Email from = new Email(fromEmail);
        Email to = new Email(customerEmail);

        Mail mail = new Mail();
        Personalization personalization = new Personalization();

        personalization.addTo(to);
        personalization.addDynamicTemplateData("firstName", customerFirstName);
        personalization.addDynamicTemplateData("lastName", customerLastName);
        personalization.addDynamicTemplateData("ticketId", ticketId.toString());

        mail.setFrom(from);
        mail.setTemplateId(completionTemplate);
        mail.addPersonalization(personalization);

        return mail;
    }

    private Mail prepareConfirmationMail(String customerEmail, String customerFirstName, String customerLastName, Long ticketId, LocalDate estimatedCompletionDate, String technicianEmail) {
        Email from = new Email(fromEmail);
        Email to = new Email(customerEmail);

        Mail mail = new Mail();
        Personalization personalization = new Personalization();

        personalization.addTo(to);
        personalization.addDynamicTemplateData("firstName", customerFirstName);
        personalization.addDynamicTemplateData("lastName", customerLastName);
        personalization.addDynamicTemplateData("ticketId", ticketId.toString());
        personalization.addDynamicTemplateData("estimatedCompletionDate", estimatedCompletionDate.toString());
        personalization.addDynamicTemplateData("technicianEmail", technicianEmail);

        mail.setFrom(from);
        mail.setTemplateId(confirmationTemplate);
        mail.addPersonalization(personalization);

        return mail;
    }
}