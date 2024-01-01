package org.cortesrmzcau.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "TAUSERS")
@Data
public class UsersEntity {
    @Id
    private BigInteger  TUIDUSER;
    @Column(name = "TUEMAIL")
    private String      email;
    @Column(name = "TUPASSWORD")
    private String      password;
    @Column(name = "TUDATECREA")
    private Date        dateCreate;
    @Column(name = "TUWEEK")
    private int         week;
}
