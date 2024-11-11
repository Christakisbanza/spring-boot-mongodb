package com.mongoDB.aula_mongoDB.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
    public static String decodeParam(String txt){
        try {
            return URLDecoder.decode(txt,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            return " ";
        }
    }

    public static Date convertDate(String txtDate, Date defaultValDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return simpleDateFormat.parse(txtDate);
        } catch (ParseException e) {
            return defaultValDate;
        }
    }
}
