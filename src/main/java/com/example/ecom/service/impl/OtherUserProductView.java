package com.example.ecom.service.impl;

import com.example.ecom.persister.ProductPersister;
import com.example.ecom.service.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

@Qualifier("OtherUserProductView")
@Service
public class OtherUserProductView implements ProductView {

    @Autowired
    ProductPersister productPersister;

    @Override
    public List<?> loadProductById(long productId, Pageable pageable) {
        return productPersister.findById(productId, pageable);
    }


    public List<?> loadProducts(Pageable pageable) {
       return productPersister.findAllProducts( pageable);
    }
}
