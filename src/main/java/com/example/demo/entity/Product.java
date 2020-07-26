package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "priceperday")
    private Integer priceperday;

    @Column(name = "pricepermonth")
    private Integer pricepermonth;

    @Column(name = "image")
    private String image;

    @Column(name = "image2")
    private String image2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriceperday() {
        return priceperday;
    }

    public void setPriceperday(Integer priceperday) {
        this.priceperday = priceperday;
    }

    public Integer getPricepermonth() {
        return pricepermonth;
    }

    public void setPricepermonth(Integer pricepermonth) {
        this.pricepermonth = pricepermonth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

}
