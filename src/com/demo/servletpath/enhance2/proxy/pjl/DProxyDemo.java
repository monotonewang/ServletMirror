package com.demo.servletpath.enhance2.proxy.pjl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 7 on 2017/1/4.
 */
//动态代理
public class DProxyDemo {

	public static void main(String[] args) {
		// woman是代理   JiaShi是被代理
		final KindWoman woman = new JiaShi();
		// 做一个Pjl的代理.这个已经不需要 王婆 这个媒人做代理了，直接是虚拟一个出来。
		//底层是用反射实现的，proxy只能为接口做代理。

		KindWoman proxy = (KindWoman) Proxy.newProxyInstance(woman.getClass().getClassLoader(), woman.getClass().getInterfaces(), new InvocationHandler() {

			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				return method.invoke(woman, args); //woman.方法名(参数)
			}
		});

		proxy.throwEye();

		final KindMan man = new Cgx();
		KindMan manProxy = (KindMan) Proxy.newProxyInstance(man.getClass().getClassLoader(), man.getClass().getInterfaces(), new InvocationHandler() {

			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				return method.invoke(man, args);
			}
		});

		manProxy.pz();

	}
}
