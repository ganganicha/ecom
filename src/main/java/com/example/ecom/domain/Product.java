package com.example.ecom.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.util.Date;

import static com.example.ecom.config.Constant.Product.*;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */


@Entity
@Table(name = TABLE)
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Product  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = ID)
    private long id;

    @Column(name = NAME)
    private String name;

    @Column(name = AVAILABLE_QTY)
    private long availableQty;

    @Column(name = SOLD_QTY)
    private long soldQty;

    @Column(name = SELLING_PRICE)
    private float sellingPrice;

    @Column(name = FACE_VALUE)
    private float faceValue;

    @Column(name = APPROVED_STATUS)
    private boolean approvedStatus;

    @Column(name = APPROVED_USER)
    private String  approvedUser;

    @Column(name = CREATED_USER)
    private String  createdUser;

    @Column(name = CREATED_DATE)
    private Date createdDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(long availableQty) {
        this.availableQty = availableQty;
    }

    public long getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(long soldQty) {
        this.soldQty = soldQty;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public float getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(float faceValue) {
        this.faceValue = faceValue;
    }

    public boolean isApprovedStatus() {
        return approvedStatus;
    }

    public void setApprovedStatus(boolean approvedStatus) {
        this.approvedStatus = approvedStatus;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getApprovedUser() {
        return approvedUser;
    }

    public void setApprovedUser(String approvedUser) {
        this.approvedUser = approvedUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
