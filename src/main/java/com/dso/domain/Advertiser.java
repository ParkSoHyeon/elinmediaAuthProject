package com.dso.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_advertiser")
public class Advertiser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertiserNo;

    @Column(length = 320, nullable = false)
    private String advertiserEmail;

    @Column(length = 320, nullable = false)
    private String advertiserName;

    @Column(length = 320, nullable = false)
    private String advertiserContractStatusCode;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(length = 320, nullable = false)
    private Date advertiserContractFinishDate;
}
