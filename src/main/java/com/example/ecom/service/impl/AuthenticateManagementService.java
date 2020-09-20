package com.example.ecom.service.impl;


import com.example.ecom.config.Constant;
import com.example.ecom.dto.KeycloakLoginResponseDto;
import com.example.ecom.dto.LoginRequestDto;
import com.example.ecom.dto.RefreshTokenRequestDto;
import com.example.ecom.exception.AuthenticationException;
import com.example.ecom.persister.UserPersister;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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
public class AuthenticateManagementService {

    private static final String TOKEN_PREFIX = "Bearer ";
    RestTemplate restTemplate = new RestTemplate();
    @Value("${com.ecom.keycloak.host}")
    private String keycloakHost;
    @Value("${com.ecom.keycloak.url.auth}")
    private String keycloakUrlAuth;
    @Value("${com.ecom.keycloak.client-id}")
    private String clientId;
    @Value("${com.ecom.keycloak.grant-type.token}")
    private String tokenGrant;
    @Value("${com.ecom.keycloak.grant-type.refresh-token}")
    private String refreshTokenGrant;

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private UserPersister userPersister;

    Logger LOGGER = LoggerFactory.getLogger(AuthenticateManagementService.class);

    public KeycloakLoginResponseDto authenticateInKeycloakSide(LoginRequestDto loginRequestDto) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        KeycloakLoginResponseDto keycloakResponse;
        if(userPersister.findByLoginName(loginRequestDto.getUsername()).isPresent()) {
            try {
                LOGGER.info("Validating User : {} credentials.", loginRequestDto.getUsername());
                headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
                MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
                map.add("username", loginRequestDto.getUsername());
                map.add("password", loginRequestDto.getPassword());
                map.add("client_id", clientId);
                map.add("grant_type", tokenGrant);
                HttpMessageConverter<?> formHttpMessageConverter = new FormHttpMessageConverter();
                HttpMessageConverter<?> stringHttpMessageConverternew = new StringHttpMessageConverter();
                List<HttpMessageConverter<?>> converters = new ArrayList<>();
                converters.add(formHttpMessageConverter);
                converters.add(stringHttpMessageConverternew);
                restTemplate.setMessageConverters(converters);
                HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
                String url = keycloakHost.concat(keycloakUrlAuth);
                ResponseEntity<String> responseEntity =
                        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
                ObjectMapper objectMapper = new ObjectMapper();
                keycloakResponse = objectMapper.readValue(
                        responseEntity.getBody(),
                        KeycloakLoginResponseDto.class);
                LOGGER.info("Successfully validated User : {} credentials.", loginRequestDto.getUsername());
                return keycloakResponse;
            } catch (RestClientException e) {
                String errorMessage = e.getMessage();
                if (errorMessage.contains("401")) {
                    LOGGER.error("Disabled User : {} has tried to login", loginRequestDto.getUsername());
                    throw new AuthenticationException(Constant.ResponseCode.INVALID_CREDENTIALS,
                            messageSource.getMessage(
                                    String.valueOf(Constant.ResponseCode.INVALID_CREDENTIALS),
                                    new Object[]{},
                                    LocaleContextHolder.getLocale()));
                } else if (errorMessage.contains("400")) {
                    LOGGER.error("Disabled User : {} has tried to login", loginRequestDto.getUsername());
                    throw new AuthenticationException(Constant.ResponseCode.USER_DISABLED, messageSource.getMessage(
                            String.valueOf(Constant.ResponseCode.USER_DISABLED),
                            new Object[]{loginRequestDto.getUsername()},
                            LocaleContextHolder.getLocale()));
                }
                throw e;
            }
        }else {
            LOGGER.error("Disabled User : {} has tried to login", loginRequestDto.getUsername());
            throw new AuthenticationException(Constant.ResponseCode.INVALID_USER_NAME, messageSource.getMessage(
                    String.valueOf(Constant.ResponseCode.INVALID_USER_NAME),
                    new Object[]{loginRequestDto.getUsername()},
                    LocaleContextHolder.getLocale()));
        }
    }

    public KeycloakLoginResponseDto getRefreshToken(RefreshTokenRequestDto refreshTokenRequestDto) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        LOGGER.info("Getting new access token for User : {}.", refreshTokenRequestDto.getUserName());
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("refresh_token", refreshTokenRequestDto.getRefreshToken());
        map.add("client_id", clientId);
        map.add("grant_type", refreshTokenGrant);
        HttpMessageConverter<?> formHttpMessageConverter = new FormHttpMessageConverter();
        HttpMessageConverter<?> stringHttpMessageConverternew = new StringHttpMessageConverter();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(formHttpMessageConverter);
        converters.add(stringHttpMessageConverternew);
        restTemplate.setMessageConverters(converters);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        String url = keycloakHost.concat(keycloakUrlAuth);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        String body = responseEntity.getBody();
        KeycloakLoginResponseDto keycloakResponse = null;
        if (body != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            keycloakResponse = objectMapper.readValue(body,
                    KeycloakLoginResponseDto.class);
            LOGGER.info("User : {} got new token at {}.", refreshTokenRequestDto.getUserName(),
                    System.currentTimeMillis());

        }
        return keycloakResponse;
    }


}
