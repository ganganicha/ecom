package com.example.ecom.controller;

import com.example.ecom.domain.Product;
import com.example.ecom.dto.ProductCreateRequest;
import com.example.ecom.service.impl.ProductManagementService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.example.ecom.config.Constant.HttpCodes.*;
import static com.example.ecom.config.Constant.RequestMappings.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */


@RestController
@RequestMapping(value = PRODUCT_ROOT_PATH, produces = {APPLICATION_JSON_VALUE})
@Api(value = PRODUCT_ROOT_PATH)
public class ProductController {

    @Autowired
    private ProductManagementService productManagementService;

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
    @PostMapping(ADD_PRODUCT)
    public Product addProduct(@RequestHeader(value = "Authorization", required = true) String token,
                              @Valid @RequestBody ProductCreateRequest product) {
        return productManagementService.addProduct(product, token);
    }

    @ApiOperation(value = "Approve product to enable sale ",
            response = Map.class, httpMethod = "PUT")
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
    @PutMapping(APPROVE_PRODUCT)
    public Product approveItem(@RequestHeader(value = "Authorization", required = true) String token,
                               @PathVariable(value = "product_id", required = true) long productId) {
        return productManagementService.approveProduct(productId, token);
    }

    @ApiOperation(value = "get product details based on role",
            response = Map.class, httpMethod = "GET")
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
    @GetMapping()
    public List<?> getProduct(@RequestHeader(value = "Authorization", required = true) String token,
                              @RequestParam(value = "product_id", required = false) Optional<Long> productId,
                              @RequestParam(value = "page_size", required = false) Optional<Integer> pageSize,
                              @RequestParam(value = "page_no", required = false) Optional<Integer> pageNo) {
        return productManagementService.customerViewProductsById(productId, token, pageNo, pageSize);
    }


}
