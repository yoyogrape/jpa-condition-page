package com.ketai.house.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author naruto
 * @date 2018/10/17 21:07
 */
@Entity
public class Street implements Serializable{
    private Integer sid;
    private String sname;
    private District district;



    @Id
    @Column(name = "SID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "SNAME")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="DISTRICT_ID")
    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

}
