package com.example.ecom.config;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

public class Constant {

    public static class ResponseCode {
        public static final int USER_DISABLED = 454;
        public static final int INVALID_CREDENTIALS = 450;
        public static final int INVALID_PRODUCT = 451;
        public static final int PRODUCT_ALREADY_APPROVED = 452;
        public static final int INVALID_USER_NAME = 453;
    }

    public static final class HttpCodes {
        public static final int HTTP_200_CODE = 200;
        public static final String HTTP_200_MESSAGE = "Successful";
        public static final int HTTP_201_CODE = 201;
        public static final int HTTP_204_CODE = 204;
        public static final String HTTP_204_MESSAGE = "No Content";
        public static final String HTTP_201_MESSAGE = "Resource Created Successfully";
        public static final int HTTP_400_CODE = 400;
        public static final String HTTP_400_MESSAGE = "Bad Request";
        public static final int HTTP_401_CODE = 401;
        public static final String HTTP_401_MESSAGE = "Unauthorized request";
        public static final int HTTP_403_CODE = 403;
        public static final String HTTP_403_MESSAGE = "Access Denied for the Service";
        public static final int HTTP_404_CODE = 404;
        public static final String HTTP_404_MESSAGE = "Resource Not Found";
        public static final int HTTP_409_CODE = 409;
        public static final String HTTP_409_MESSAGE = "Conflict";
        public static final int HTTP_415_CODE = 415;
        public static final String HTTP_415_MESSAGE = "Unsupported media type";
        public static final int HTTP_424_CODE = 424;
        public static final String HTTP_424_MESSAGE = "External call failed";
        public static final int HTTP_429_CODE = 429;
        public static final String HTTP_429_MESSAGE = "Rate limiting - "
                + "User has sent too many requests in a given amount of time";
        public static final int HTTP_500_CODE = 500;
        public static final String HTTP_500_MESSAGE = "Internal Server Errors";
        public static final int ERROR_409 = 409;
        public static final int ERROR_410 = 410;
        public static final int ERROR_411 = 411;
        public static final int ERROR_433 = 433;

    }

    public static class User{
        public static final String TABLE = "User";
        public static final String LOGIN_NAME = "login_name";
        public static final String EMAIL = "email";
        public static final String CONTACT_NUMBER = "contact_number";
        public static final String NAME = "name";
        public static final String ADDRESS = "address";
    }

    public static class Product{
        public static final String TABLE = "product";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String AVAILABLE_QTY = "avail_qty";
        public static final String SOLD_QTY = "sold_qty";
        public static final String SELLING_PRICE = "selling_price";
        public static final String FACE_VALUE = "face_value";
        public static final String APPROVED_STATUS = "approve_status";
        public static final String APPROVED_USER = "approve_user";
        public static final String CREATED_USER = "created_user";
        public static final String CREATED_DATE = "created_date";

    }

    public static final class RequestMappings {
        public static final String PRODUCT_ROOT_PATH = "v1/products";
        public static final String APPROVE_PRODUCT = "/{product_id}/approval";
        public static final String ADD_PRODUCT = "/add";
    }
}
