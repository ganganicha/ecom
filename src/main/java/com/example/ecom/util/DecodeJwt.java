package com.example.ecom.util;


import com.example.ecom.dto.TokenBodyDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

public class DecodeJwt {
    private static final Logger LOGGER = LoggerFactory.getLogger(DecodeJwt.class);

    public String decodeJwtTokenBody(String token) {
        String[] tokenArray = token.split("\\.");
        String encodedBody = tokenArray[1];
        Base64 base64 = new Base64(true);
        try {
            return new String(base64.decode(encodedBody), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Error has occurred while converting token.", e);
        }
        return null;
    }

    public TokenBodyDto convertTokenBody(String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(body, TokenBodyDto.class);
        } catch (IOException e) {
            LOGGER.error("Error has occurred while converting token.", e);
            return null;
        }
    }
}
