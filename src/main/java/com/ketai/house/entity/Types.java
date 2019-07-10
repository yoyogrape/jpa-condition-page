package com.ketai.house.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author naruto
 * @date 2018/10/17 21:07
 */
@Entity
public class Types implements Serializable {
    private Integer tid;
    private String tname;

    @Id
    @Column(name = "TID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "TNAME")
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

}
