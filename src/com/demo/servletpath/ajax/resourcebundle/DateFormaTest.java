package com.demo.servletpath.ajax.resourcebundle;

import org.junit.Test;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by WangTest on 2016/12/25.
 */
public class DateFormaTest {
    @Test
    public void fun1() {
        DateFormat df1=DateFormat.getDateInstance();// 年月日
        DateFormat df2=DateFormat.getTimeInstance();//小时 分钟 秒
        DateFormat df3=DateFormat.getDateTimeInstance(); //都有

        Date date=new Date();
        System.out.println(df1.format(date));
        System.out.println(df2.format(date));
        System.out.println(df3.format(date));
    }
}
