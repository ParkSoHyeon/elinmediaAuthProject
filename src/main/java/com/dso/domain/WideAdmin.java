package com.dso.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_wide_admin")
public class WideAdmin {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long wideAdminNo;

    @Id
    @Column(length = 320, nullable = false)
    private String wideAdminEmail;

    @Column(nullable = false)
    private String wideAdminPassword;

    @Column(length = 40, nullable = false)
    private String wideAdminName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "wideAdmin")
    @Column(length = 40, nullable = false)
    private List<WideRole> wideAdminRoleCode;

    @Column(nullable = false)
    private Date wideAdminContractFinishDate;

    @Column(length = 10, nullable = false)
    private String wideAdminContractStatusCode;

}
