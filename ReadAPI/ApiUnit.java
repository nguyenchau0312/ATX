package com.atid.app.atx.ReadAPI;

public class ApiUnit {
    private ApiUnit() {}


    //public static final String BASE_URL = "http://192.168.1.63:3804/";
    public static final String BASE_URL = "http://66.66.66.52:3804/";
    public static final String BASE_Token = "https://id.kiotviet.vn";
    public static final String BASE_Product = "https://public.kiotapi.com";


    public static WebApi getNVService() {

        return RetrofitClient.getClient(BASE_URL).create(WebApi.class);
    }
    public static WebApi getToketService() {

        return RetrofitClient.getClient(BASE_Token).create(WebApi.class);
    }
    public static WebApi getTokentProduct() {

        return RetrofitClient.getClient(BASE_Product).create(WebApi.class);
    }

}
