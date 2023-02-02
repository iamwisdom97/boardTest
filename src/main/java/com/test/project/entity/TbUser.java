package com.test.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class TbUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userCode;
    @Column(length = 50, nullable = false)
    private String userId;
    @Column(length = 50, nullable = false)
    private String userName;
}
