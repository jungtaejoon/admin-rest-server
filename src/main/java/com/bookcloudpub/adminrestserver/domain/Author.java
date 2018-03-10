package com.bookcloudpub.adminrestserver.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Author {
    @Id
    @SequenceGenerator(name = "author_id_seq", sequenceName = "author_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "author_id_seq")
    private Long id;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

    private String penName;

    @OneToOne
    @JoinColumn
    private User bookcloudpubAccount;

    public Author(String penName) {
        this.penName = penName;
    }

    public void setBookcloudpubAccount(User user) {
        this.bookcloudpubAccount = user;
        if(this.bookcloudpubAccount.getAuthorData() == null) {
            this.bookcloudpubAccount.setAuthorData(this);
        }
    }
}
