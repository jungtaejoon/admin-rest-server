package com.bookcloudpub.adminrestserver.domain;

import com.bookcloudpub.adminrestserver.domain.enumSet.PaymentType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Bookstore {
    @Id
    @SequenceGenerator(name = "bookstore_id_seq", sequenceName = "bookstore_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bookstore_id_seq")
    private Long id;

    @Column(columnDefinition = "varchar(32) unique")
    private String name;
    private String presidentName;
    private String email;
    private String address;
    private Float salesRate;

    @Column(columnDefinition = "varchar(16)")
    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType = PaymentType.CHARGE;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastModifiedTime;

    public String getPaymentType() {
        return this.paymentType.toString();
    }
}
