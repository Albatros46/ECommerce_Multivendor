package com.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String reviewText;
    @Column(nullable = false)
    private double rating;
    @ElementCollection
    private List<String> productImages;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)  // ✅ Eksikse ekleyin
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // ✅ Eksikse ekleyin
    private User user;

    @Column(nullable = false)
    private LocalDateTime createdAt=LocalDateTime.now();
}
