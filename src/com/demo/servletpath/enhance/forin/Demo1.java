package com.demo.servletpath.enhance.forin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 增强for循环
 * @author Administrator
 *
 */
public class Demo1 {
	
	@Test
	public void run(){
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		System.out.println("============================================");
		
		for (String str : list) {
			System.out.println(str);
		}
		
		System.out.println("============================================");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
