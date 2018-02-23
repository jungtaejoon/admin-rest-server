package com.bookcloudpub.adminrestserver.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "book_id_seq")
    private Long id;
}
