package com.bookcloudpub.adminrestserver.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = "authorData")
@EqualsAndHashCode(exclude = "authorData")
public class User {
    @Id
    @Column(columnDefinition = "varchar(320)")
    private String email;

    @Column(columnDefinition = "varchar(255) not null")
    private String password;

    @Column(columnDefinition = "tinyint not null default 1")
    private boolean enabled;

    @Column(columnDefinition = "varchar(255) not null")
    private String name;

    @OneToOne(mappedBy = "bookcloudpubAccount")
    private Author authorData;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles = new ArrayList<>();

}
