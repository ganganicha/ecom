package com.example.ecom.persister;

import com.example.ecom.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

@Repository
public interface ProductPersister extends PagingAndSortingRepository<Product, Long> {

    List<Product> findByIdAndApprovedStatus(long productId, boolean status, Pageable pageable);

    List<Product> findByApprovedStatus( boolean status, Pageable pageable);

    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<Product> findAllProducts(Pageable pageable);

    List<Product> findById(long productId, Pageable pageable);

}
