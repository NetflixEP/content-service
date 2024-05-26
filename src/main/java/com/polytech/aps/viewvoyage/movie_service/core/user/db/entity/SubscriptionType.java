package com.polytech.aps.viewvoyage.movie_service.core.user.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "subscription_type")
public class SubscriptionType {
    @Id
    private String code;

    private String description;

    public BigDecimal price;
}
