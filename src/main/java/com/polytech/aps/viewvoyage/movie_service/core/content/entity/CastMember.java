package com.polytech.aps.viewvoyage.movie_service.core.content.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private Long id;

    @JoinColumn(name = "actor_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Employee.class, fetch = FetchType.LAZY)
    private Employee employee;

    @JoinColumn(name = "content_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Content.class, fetch = FetchType.LAZY)
    private Content content;

    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Role.class, fetch = FetchType.LAZY)
    private Role role;

    @Column(name = "content_id", nullable = false)
    private UUID contentId;

    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "actor_id", nullable = false)
    private Long actorId;
}
