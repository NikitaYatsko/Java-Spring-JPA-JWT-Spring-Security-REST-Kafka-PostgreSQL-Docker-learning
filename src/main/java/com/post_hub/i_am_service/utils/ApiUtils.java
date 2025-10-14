package com.post_hub.i_am_service.utils;

import com.post_hub.i_am_service.model.constants.ApiConstants;

public class ApiUtils {
    public static String getMethodName() {
        try {
            return Thread.currentThread().getStackTrace()[1].getMethodName();
        } catch (Exception e) {
            return ApiConstants.UNDEFINED;
        }
    }
}
