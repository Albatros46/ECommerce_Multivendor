package com.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    private String accountNumber;
    private String accountHolderName;
//    private String bankName;
    private String ifscCode;
}
