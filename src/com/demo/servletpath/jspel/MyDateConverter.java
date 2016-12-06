package com.demo.servletpath.jspel;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 7 on 2016/12/6.
 */
public class MyDateConverter implements Converter {
    @Override
    public Object convert(Class aClass, Object o) {
        // 把输入的字符串，转换成日期类型，返回
        String dDate = (String) o;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(dDate);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("转换日期错误");
        }
        return date;
    }
}
