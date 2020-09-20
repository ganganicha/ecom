package com.example.ecom.persister;

import com.example.ecom.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

@Repository
public interface UserPersister extends JpaRepository<User, Long> {

    Optional<User> findByLoginName(String loginName);

}
