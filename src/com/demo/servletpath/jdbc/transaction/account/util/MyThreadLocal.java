package com.demo.servletpath.jdbc.transaction.account.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 7 on 2016/12/12.
 */
public class MyThreadLocal<T> {

	private Map<Thread, T> map;

	private MyThreadLocal() {
		map = new HashMap<Thread, T>();
	}

	public void set(T t) {
		map.put(Thread.currentThread(), t);
	}

	public T get() {

		return map.get(Thread.currentThread());
	}
}


