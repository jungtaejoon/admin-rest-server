package com.bookcloudpub.adminrestserver.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserRole {
    @Id
    @SequenceGenerator(name = "user_role_id_seq", sequenceName = "user_role_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_role_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @Column(columnDefinition = "varchar(100) not null")
    private String role;
}
