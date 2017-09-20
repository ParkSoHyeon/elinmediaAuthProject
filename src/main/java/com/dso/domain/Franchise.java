package com.dso.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_franchise")
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long franchiseNo;

    @Column(nullable = false)
    private Long partnerNo;

    @Column(length = 320, nullable = false)
    private String franchiseEmail;

    @Column(length = 320, nullable = false)
    private String franchiseName;

    @Column(length = 320, nullable = false)
    private String franchiseContractStatusCode;

    @Column(length = 320, nullable = false)
    private Date franchiseContractFinishDate;
}
