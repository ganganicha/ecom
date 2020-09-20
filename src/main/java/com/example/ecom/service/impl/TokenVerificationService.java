package com.example.ecom.service.impl;

import com.example.ecom.dto.TokenBodyDto;
import com.example.ecom.util.DecodeJwt;
import org.springframework.stereotype.Service;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

@Service
public class TokenVerificationService {

    public TokenBodyDto getUserName(String token) {
        DecodeJwt decodeJwt = new DecodeJwt();
        String decodedBody = decodeJwt.decodeJwtTokenBody(token);
        return decodeJwt.convertTokenBody(decodedBody);
    }
}
