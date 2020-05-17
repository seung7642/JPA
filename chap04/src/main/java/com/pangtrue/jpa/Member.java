package com.pangtrue.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * User: Seungho Lee ( seung7642@gmail.com )
 * Date: 2020.05.17
 * Time: 15:30
 */
@Data
@Entity
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(
        name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"}
)})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", nullable = false, length = 10)
    private String userName;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updDate;

    @Lob
    private String description;

    @Transient
    private String temp;
}
