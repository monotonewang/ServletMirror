package com.demo.servletpath.ajax.resourcebundle;


import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by WangTest on 2016/12/25.
 */
public class ResourceBundleTest {
    public static void main(String args[]) {
//        ResourceBundle resourceBundle=ResourceBundle.getBundle("message", Locale.US);
        ResourceBundle resourceBundle=ResourceBundle.getBundle("message", Locale.CHINA);
        String msg = resourceBundle.getString("msg");
        System.out.println(msg);
    }
}
