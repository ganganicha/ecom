package com.example.ecom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductCreateRequest {


    @NotNull(message = "product name may not be empty")
    @NotEmpty
    private String name;

    @NotNull(message = "available quantity name may not be empty")
    @NotEmpty
    private long availableQty;

    @NotNull(message = "sold quantity may not be empty")
    @NotEmpty
    private long soldQty;

    @NotNull(message = "product selling price may not be empty")
    @NotEmpty
    private float sellingPrice;

    @NotNull(message = "product face value may not be empty")
    @NotEmpty
    private float faceValue;

    @JsonIgnore
    private boolean approvedStatus;

    @JsonIgnore
    private String  approvedUser;

    @JsonIgnore
    private String  createdUser;

    @JsonIgnore
    private Date createdDate;


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

}
