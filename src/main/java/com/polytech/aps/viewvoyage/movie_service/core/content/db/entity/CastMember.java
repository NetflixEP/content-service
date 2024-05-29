package com.polytech.aps.viewvoyage.movie_service.core.content.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "cast_member")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CastMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @JoinColumn(name = "content_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Content.class, fetch = FetchType.LAZY)
    private Content content;

    @Column(name = "content_id", nullable = false)
    private UUID contentId;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "employee_full_name", nullable = false)
    private String employeeFullName;
}
