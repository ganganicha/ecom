package com.example.ecom.service.impl;

import com.example.ecom.domain.Product;
import com.example.ecom.persister.ProductPersister;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class CustomerProductViewTest {

    @Mock
    ProductPersister productPersister;

    @InjectMocks
    CustomerProductView customerProductView;

    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadProductById() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        products.add(product);
        products.add(product2);
        products.add(product3);
        when(productPersister.findByIdAndApprovedStatus(Mockito.any(Long.class), Mockito.any(Boolean.class),
                Mockito.any())).thenReturn(products);
        List<?> list = customerProductView.loadProductById(12, null);
    }

    @Test
    public void loadProducts() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        products.add(product);
        products.add(product2);
        products.add(product3);
        when(productPersister.findByApprovedStatus(Mockito.any(Boolean.class),
                Mockito.any())).thenReturn(products);
        List<?> list = customerProductView.loadProducts(null);
    }
}