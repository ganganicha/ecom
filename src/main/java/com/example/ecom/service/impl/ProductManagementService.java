package com.example.ecom.service.impl;

import com.example.ecom.config.Constant;
import com.example.ecom.domain.Product;
import com.example.ecom.dto.ProductCreateRequest;
import com.example.ecom.dto.TokenBodyDto;
import com.example.ecom.exception.ProductException;
import com.example.ecom.persister.ProductPersister;
import com.example.ecom.service.ProductView;
import com.example.ecom.util.DecodeJwt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */


@Service
public class ProductManagementService {

    @Autowired
    ProductPersister productPersister;
    @Autowired
    MessageSource messageSource;
    @Autowired
    ProductViewFactory productViewFactory;
    @Autowired
    ProductView productView;

    @Value("${default.page.no}")
    private int pageNoProperty;
    @Value("${default.page.size}")
    private int pageSizeProperty;


    public Product addProduct(ProductCreateRequest productCreateRequest, String token) {
        Product product = new Product();
        BeanUtils.copyProperties(productCreateRequest, product);
        product.setApprovedStatus(false);
        TokenBodyDto tokenBodyDto = getUserName(token);
        if (tokenBodyDto != null) {
            product.setCreatedUser(tokenBodyDto.getPreferredUsername());
        }
        product.setCreatedDate(new Date());
        return productPersister.save(product);
    }


    public Product approveProduct(long productId, String token) {
        if (productPersister.findById(productId).isPresent()) {
            Product product = productPersister.findById(productId).get();
            if (product.isApprovedStatus()) {
                throw new ProductException(Constant.ResponseCode.PRODUCT_ALREADY_APPROVED,
                        messageSource.getMessage(
                                String.valueOf(Constant.ResponseCode.PRODUCT_ALREADY_APPROVED),
                                new Object[]{productId},
                                LocaleContextHolder.getLocale()));
            } else {
                product.setApprovedStatus(true);
                TokenBodyDto tokenBodyDto = getUserName(token);
                if (tokenBodyDto != null) {
                    product.setCreatedUser(tokenBodyDto.getPreferredUsername());
                }
                return productPersister.save(product);
            }
        } else {
            throw new ProductException(Constant.ResponseCode.INVALID_PRODUCT,
                    messageSource.getMessage(
                            String.valueOf(Constant.ResponseCode.INVALID_PRODUCT),
                            new Object[]{productId},
                            LocaleContextHolder.getLocale()));
        }
    }

    public List<?> customerViewProductsById(Optional<Long> productId, String token,Optional<Integer> pageNo,
                                            Optional<Integer> pageSize) {
        Pageable pageable = getDefaultPageConfiguration(pageNo, pageSize);
         productView = productViewFactory.identifyViewType(token);
        if (productId.isPresent()) {
            return productView.loadProductById(productId.get(),pageable);
        } else {
            return productView.loadProducts(pageable);
        }
    }

    public TokenBodyDto getUserName(String token) {
        DecodeJwt decodeJwt = new DecodeJwt();
        String decodedBody = decodeJwt.decodeJwtTokenBody(token);
        return decodeJwt.convertTokenBody(decodedBody);
    }

    public Pageable getDefaultPageConfiguration(Optional<Integer> optPageNo, Optional<Integer> optPageSize) {

        int pageNo;
        int pageSize;
        pageNo = optPageNo.orElseGet(() -> pageNoProperty);
        pageSize = optPageSize.orElseGet(() -> pageSizeProperty);
        return PageRequest.of(pageNo, pageSize);
    }
}
