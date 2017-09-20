package com.dso.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_partner")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partnerNo;

    @Column(length = 320, nullable = false)
    private String partnerEmail;

    @Column(length = 320, nullable = false)
    private String partnerName;

    @Column(length = 320, nullable = false)
    private String partnerContractStatusCode;

    @Column(length = 320, nullable = false)
    private Date partnerContractFinishDate;
}
