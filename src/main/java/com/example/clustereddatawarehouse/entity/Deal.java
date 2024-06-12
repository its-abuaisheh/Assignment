package com.example.clustereddatawarehouse.entity;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "deals", uniqueConstraints = @UniqueConstraint(columnNames = "dealUniqueId"))
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Deal Unique Id is mandatory")
    @Column(nullable = false, unique = true)
    private String dealUniqueId;

    @NotBlank(message = "From Currency ISO Code is mandatory")
    @Size(min = 3, max = 3, message = "From Currency ISO Code must be 3 characters long")
    @Column(nullable = false)
    private String fromCurrencyIsoCode;

    @NotBlank(message = "To Currency ISO Code is mandatory")
    @Size(min = 3, max = 3, message = "To Currency ISO Code must be 3 characters long")
    @Column(nullable = false)
    private String toCurrencyIsoCode;

    @NotNull(message = "Deal timestamp is mandatory")
    @PastOrPresent(message = "Deal timestamp must be in the past or present")
    @Column(nullable = false)
    private LocalDateTime dealTimestamp;

    @NotNull(message = "Deal Amount is mandatory")
    @Positive(message = "Deal Amount must be positive")
    @Column(nullable = false)
    private Double dealAmount;
}
