package com.ketai.house.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author naruto
 * @date 2018/10/17 21:07
 */@Entity
public class House implements Serializable{
    private Integer hid;
    private String title;
    private String description;
    private Integer price;
    private Date pubDate;
    private Integer floorage;
    private String contact;
    private Users user;
    private Types type;
    private Street street;


//    private String betweenPrince;
//
//    private String districtName;
//
//    private Integer typeId;
//
//    private String betweenPubDate;
//
//    private String betweenSpace;

    @Id
    @Column(name = "HID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "PRICE")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "PUBDATE")
    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    @Basic
    @Column(name = "FLOORAGE")
    public Integer getFloorage() {
        return floorage;
    }

    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }

    @Basic
    @Column(name = "CONTACT")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="USER_ID")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="TYPE_ID")
    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="STREET_ID")
    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
//    @Transient
//    public String getBetweenPrince() {
//        return betweenPrince;
//    }
//
//    public void setBetweenPrince(String betweenPrince) {
//        this.betweenPrince = betweenPrince;
//    }
//    @Transient
//    public String getDistrictName() {
//        return districtName;
//    }
//
//    public void setDistrictName(String districtName) {
//        this.districtName = districtName;
//    }
//    @Transient
//    public String getBetweenPubDate() {
//        return betweenPubDate;
//    }
//
//    public void setBetweenPubDate(String betweenPubDate) {
//        this.betweenPubDate = betweenPubDate;
//    }
//    @Transient
//    public Integer getTypeId() {
//        return typeId;
//    }
//
//    public void setTypeId(Integer typeId) {
//        this.typeId = typeId;
//    }
//
//    @Transient
//    public String getBetweenSpace() {
//        return betweenSpace;
//    }
//
//    public void setBetweenSpace(String betweenSpace) {
//        this.betweenSpace = betweenSpace;
//    }
}
