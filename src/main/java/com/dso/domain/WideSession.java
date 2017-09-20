package com.dso.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "tb_wide_session")
public class WideSession {
    @Id
    @Column(length = 80, nullable = false)
    private String wideSessionId;

    @Column(length = 320, nullable = false)
    private String wideAdminEmail;

    @Column(length = 20, nullable = false)
    private String wideAdminName;

    @Column(length = 20, nullable = false)
    private String wideAdminRole;

    @Column(length = 10, nullable = false)
    private int wideLoginStatus=1;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp wideSessionRegDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp wideSessionUpdateDate;
}
