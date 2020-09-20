package com.example.ecom.service.impl;

import com.example.ecom.domain.Product;
import com.example.ecom.dto.ProductDto;
import com.example.ecom.persister.ProductPersister;
import com.example.ecom.service.ProductView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

@Service
@Primary
public class CustomerProductView implements ProductView {

    @Autowired
    ProductPersister productPersister;

    @Override
    public List<?> loadProductById(long productId, Pageable pageable) {
        List<Product> products = productPersister.findByIdAndApprovedStatus(productId, true, pageable);
        List<ProductDto> productDtos = new ArrayList<>();
        products.forEach(product -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            productDtos.add(productDto);
        });
        return productDtos;
    }

    public List<?> loadProducts(Pageable pageable) {
        List<Product> products = productPersister.findByApprovedStatus(true, pageable);
        List<ProductDto> productDtos = new ArrayList<>();
        products.forEach(product -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            productDtos.add(productDto);
        });
        return productDtos;
    }
}
