package com.dso.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="tb_wide_role")
public class WideRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wideRoleNo;

    @Column(length = 40, nullable = false)
    private String wideRoleCode;

//    @Column(length = 40, nullable = false)
//    private String wideRoleName;
}
