package com.example.ecom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

public class ProductDto implements Serializable {

    @JsonIgnore
    private long productId;

    private String name;
    
    private long availableQty;

    private long soldQty;

    private float sellingPrice;

    @JsonIgnore
    private float faceValue;

    @JsonIgnore
    private boolean approvedStatus;

    @JsonIgnore
    private String approvedUser;

    @JsonIgnore
    private String createdUser;

    @JsonIgnore
    private Date createdDate;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public String getApprovedUser() {
        return approvedUser;
    }

    public void setApprovedUser(String approvedUser) {
        this.approvedUser = approvedUser;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
