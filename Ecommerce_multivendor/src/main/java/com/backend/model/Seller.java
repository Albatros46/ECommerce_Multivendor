package com.backend.model;

import com.backend.enums.AccountStatus;
import com.backend.enums.USER_ROLE;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sellerName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Embedded
    private BusinessDetails businessDetails = new BusinessDetails();

    @Embedded
    private BankDetails bankDetails = new BankDetails();

    private String GSTIN;

    @Enumerated(EnumType.STRING)
    private USER_ROLE role = USER_ROLE.SELLER;

    @Column(columnDefinition = "boolean default false")
    private boolean isEmailVerified;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus = AccountStatus.PENDING_VERIFICATION;

    @PostLoad
    @PrePersist
    public void setDefaults() {
        if (this.role == null) {
            this.role = USER_ROLE.SELLER;
        }
        if (this.accountStatus == null) {
            this.accountStatus = AccountStatus.PENDING_VERIFICATION;
        }
    }
}