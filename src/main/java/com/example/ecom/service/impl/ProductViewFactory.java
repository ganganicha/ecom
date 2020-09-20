package com.example.ecom.service.impl;

import com.example.ecom.dto.TokenBodyDto;
import com.example.ecom.service.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

@Service
public class ProductViewFactory {

    @Value("${com.ecom.user.customer}")
    private String customerRole;
    @Autowired
    TokenVerificationService productManagementService;
    @Autowired
    CustomerProductView customerProductView;
    @Qualifier("OtherUserProductView")
    @Autowired
    OtherUserProductView otherUserProductView;

    public ProductView identifyViewType(String token){
        TokenBodyDto tokenBodyDto = productManagementService.getUserName(token);
        if(tokenBodyDto.getRealmAccess().getRoles().contains(customerRole)){
            return customerProductView;
        }else {
            return otherUserProductView;
        }
    }

}
