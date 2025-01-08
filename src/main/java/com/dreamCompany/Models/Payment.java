package com.dreamCompany.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Payment {
    @Id
    private String referenceId;
    private Ticket ticket;
}
