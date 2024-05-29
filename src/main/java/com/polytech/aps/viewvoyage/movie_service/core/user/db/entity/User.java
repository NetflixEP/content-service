package com.polytech.aps.viewvoyage.movie_service.core.user.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String login;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String phone;

    private LocalDate birthday;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "subscription_status")
    private Boolean status;

    @Column(name = "subscription_start_date")
    private LocalDateTime startDate;

    @Column(name = "subscription_end_date")
    private LocalDateTime endDate;

    @JoinColumn(name = "subscription_type", insertable = false, updatable = false)
    @ManyToOne(targetEntity = SubscriptionType.class, fetch = FetchType.LAZY)
    private SubscriptionType subscriptionType;

    @Column(name = "subscription_type", nullable = false)
    private String subscriptionCode;
}
