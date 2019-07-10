package com.ketai.house.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author naruto
 * @date 2018/10/17 21:07
 */
@Entity
public class District implements Serializable{
    private Integer did;
    private String dname;

    @Id
    @Column(name = "DID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Basic
    @Column(name = "DNAME")
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

}
