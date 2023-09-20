package com.kalai.junittest;

public class StringUtils {


    public static Integer StringToInt(String str) {

        if(str == null || str.trim().length() == 0)
            throw new IllegalArgumentException("string contains null values or empty string");

        return Integer.valueOf(str);
    }
}
