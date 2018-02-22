package com.bookcloudpub.adminrestserver.domain;

import com.bookcloudpub.adminrestserver.domain.enumSet.PaymentType;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Bookstore {
    @Id
    @SequenceGenerator(name = "bookstore_id_seq", sequenceName = "bookstore_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bookstore_id_seq")
    private Long id;
    private String name;
    private String presidentName;
    private String email;
    private String address;
    private float salesRate;
    private PaymentType paymentType;
    private Timestamp createTime;
}
