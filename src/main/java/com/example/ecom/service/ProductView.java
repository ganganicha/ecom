package com.example.ecom.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

public interface ProductView {

    List<?> loadProductById(long productId, Pageable pageable);

    List<?> loadProducts(Pageable pageable);

}
