package com.gadgets.repair.system.services.email;

import java.time.LocalDate;

public interface EmailService {
    void sendConfirmationEmail(String customerEmail, String customerFirstName, String customerLastName, Long ticketId, LocalDate estimatedCompletionDate, String technicianEmail);
    void sendCompletionEmail(String customerEmail, String customerFirstName, String customerLastName, Long ticketId);
}
