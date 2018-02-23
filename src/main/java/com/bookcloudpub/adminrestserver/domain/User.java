package com.bookcloudpub.adminrestserver.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_seq")
    private Long id;

    @Column(columnDefinition = "varchar(255) unique")
    private String email;

    private String password;
    private String name;

    @OneToOne(mappedBy = "bookcloudpubAccount")
    private Author authorData;

}
