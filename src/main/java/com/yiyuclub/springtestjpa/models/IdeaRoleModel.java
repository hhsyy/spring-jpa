package com.yiyuclub.springtestjpa.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "idea_role")
@Data
public class IdeaRoleModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "role_id", insertable = false, nullable = false)
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_remake")
    private String roleRemake;

    @Column(name = "permission_id", nullable = false)
    private Integer permissionId;

    
}