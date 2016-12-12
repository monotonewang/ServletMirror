package com.demo.servletpath.jspel.utils;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by 7 on 2016/12/6.
 */
public class IntrospectorTest {
    @Test
    public void run() throws Exception{
        String proName="class";
        User user = new User();
        // 获取类的信息
        BeanInfo info = Introspector.getBeanInfo(user.getClass());
        // 获取属性的描述
        PropertyDescriptor[] pds = info.getPropertyDescriptors();

        // 循环遍历，获取属性的名称
        for (PropertyDescriptor pd : pds) {
//             System.out.println(pd.getName());
            if(!proName.equals(pd.getName())){
                // 获取写的方法
                Method m = pd.getWriteMethod();
                m.invoke(user, "admin");
            }
        }

        System.out.println(user.getName());
        System.out.println(user.getPassword());
    }
}

class User {
    String name;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}