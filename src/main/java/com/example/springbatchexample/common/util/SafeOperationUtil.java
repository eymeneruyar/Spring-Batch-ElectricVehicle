package com.example.springbatchexample.common.util;

public class SafeOperationUtil {

    public static boolean isNullOrEmpty(String message){
        return message == null || message.isEmpty();
    }

    public static Integer getInteger(String message){
        return isNullOrEmpty(message) ? 0 : Integer.getInteger(message);
    }

}
