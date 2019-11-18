package com.infodart.salman.controllers;

public class Api_Utils {

    private Api_Utils() {}

    public static final String BASE_URL = "http://14.141.50.214:9031/grocery-hero/admin/api/";

    public static Api_Interface getAPIService(){
        return BaseService.getClient(BASE_URL).create(Api_Interface.class);
    }
}
