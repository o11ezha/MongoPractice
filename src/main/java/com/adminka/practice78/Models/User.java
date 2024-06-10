package com.adminka.practice78.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_username")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_role")
    private Integer userRole;
}
