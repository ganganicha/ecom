package com.example.ecom.controller;

import com.example.ecom.dto.KeycloakLoginResponseDto;
import com.example.ecom.dto.LoginRequestDto;
import com.example.ecom.dto.RefreshTokenRequestDto;
import com.example.ecom.service.impl.AuthenticateManagementService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.example.ecom.config.Constant.HttpCodes.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */


@RestController
public class AuthenticateController {

    @Autowired
    private AuthenticateManagementService authService;

    @ApiOperation(value = "add products ",
            response = Map.class, httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = HTTP_204_CODE, message = HTTP_204_MESSAGE,
            response = Map.class,
            examples = @Example(value =
                    {
                            @ExampleProperty(mediaType = APPLICATION_JSON_VALUE,
                                    value = "")
                    }
            )),
            @ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE, response = HashMap.class,
                    examples = @Example(value =
                            {
                                    @ExampleProperty(mediaType = APPLICATION_JSON_VALUE,
                                            value = "{\n"
                                                    + "    \"timestamp\": \"2020-05-21T06:56:26.020+0000\",\n"
                                                    + "    \"path\": \"/v1/profiles/{id}/approve\",\n"
                                                    + "    \"status\": 400,\n"
                                                    + "    \"error\": \"400 - bad request\",\n"
                                                    + "    \"requestId\": \"e9f9as3b\"\n"
                                                    + "}")
                            }
                    )),
            @ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
            @ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
            @ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE, response = Map.class,
                    examples = @Example(value =
                            {
                                    @ExampleProperty(mediaType = APPLICATION_JSON_VALUE,
                                            value = "{\n"
                                                    + "    \"timestamp\": \"2020-05-21T06:56:26.020+0000\",\n"
                                                    + "    \"path\": \"/v1/profiles/{id}/approve\",\n"
                                                    + "    \"status\": 404,\n"
                                                    + "    \"error\": \"404 - not found\",\n"
                                                    + "    \"requestId\": \"e9f9as3b\"\n"
                                                    + "}")
                            }
                    )),
            @ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
            @ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE)})
    @PostMapping("/login")
    public KeycloakLoginResponseDto authenticate(@RequestBody LoginRequestDto loginRequestDtO) throws IOException {
        return authService.authenticateInKeycloakSide(loginRequestDtO);
    }

    @ApiOperation(value = "add products ",
            response = Map.class, httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = HTTP_204_CODE, message = HTTP_204_MESSAGE,
            response = Map.class,
            examples = @Example(value =
                    {
                            @ExampleProperty(mediaType = APPLICATION_JSON_VALUE,
                                    value = "")
                    }
            )),
            @ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE, response = HashMap.class,
                    examples = @Example(value =
                            {
                                    @ExampleProperty(mediaType = APPLICATION_JSON_VALUE,
                                            value = "{\n"
                                                    + "    \"timestamp\": \"2020-05-21T06:56:26.020+0000\",\n"
                                                    + "    \"path\": \"/v1/profiles/{id}/approve\",\n"
                                                    + "    \"status\": 400,\n"
                                                    + "    \"error\": \"400 - bad request\",\n"
                                                    + "    \"requestId\": \"e9f9as3b\"\n"
                                                    + "}")
                            }
                    )),
            @ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
            @ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
            @ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE, response = Map.class,
                    examples = @Example(value =
                            {
                                    @ExampleProperty(mediaType = APPLICATION_JSON_VALUE,
                                            value = "{\n"
                                                    + "    \"timestamp\": \"2020-05-21T06:56:26.020+0000\",\n"
                                                    + "    \"path\": \"/v1/profiles/{id}/approve\",\n"
                                                    + "    \"status\": 404,\n"
                                                    + "    \"error\": \"404 - not found\",\n"
                                                    + "    \"requestId\": \"e9f9as3b\"\n"
                                                    + "}")
                            }
                    )),
            @ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
            @ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE)})
    @PostMapping("/refresh-token")
    public KeycloakLoginResponseDto refreshToken(@RequestBody RefreshTokenRequestDto refreshTokenRequestDtO)
            throws IOException {
        return authService.getRefreshToken(refreshTokenRequestDtO);
    }
}
