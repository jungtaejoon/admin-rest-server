package com.bookcloudpub.adminrestserver.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Publisher {
    @Id
    @SequenceGenerator(name = "publisher_id_seq", sequenceName = "publisher_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "publisher_id_seq")
    private Long id;

    private String name;

    @Column(columnDefinition = "varchar(32) unique not null")
    private String corporateNumber;

    private String presidentName;
    private String email;
    private String address;
    private String workStyle;
    private String workType;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastModifiedTime;


}
