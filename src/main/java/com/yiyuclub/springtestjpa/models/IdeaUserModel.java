package com.yiyuclub.springtestjpa.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "idea_user")
@Entity
@Data
public class IdeaUserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "area")
    private String area;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "salt")
    private String salt;

}