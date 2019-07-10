package com.ketai.house.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author naruto
 * @date 2018/10/17 21:07
 */
@Entity
public class Users implements Serializable{
    private Integer uid;
    private String uname;
    private String password;
    private String telephone;
    private String username;
    private Integer isAdmin;

    @Id
    @Column(name = "UID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "UNAME")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "TELEPHONE")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "ISADMIN")
    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

}
