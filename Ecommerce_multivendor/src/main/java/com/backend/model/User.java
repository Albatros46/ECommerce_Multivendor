package com.backend.model;

import com.backend.enums.USER_ROLE;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String email;
    private String fullName;
    @JsonProperty("mobile")
    @Column(name = "mobile")
    private String mobile;
    private USER_ROLE role=USER_ROLE.ROLE_CUSTOMER;
    @OneToMany
    private Set<Address> addresses =new HashSet<>();
    @ManyToMany
    @JsonIgnore
    private Set<Coupon> usedCoupons=new HashSet<>();
}
