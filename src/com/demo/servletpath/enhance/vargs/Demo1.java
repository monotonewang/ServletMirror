package com.demo.servletpath.enhance.vargs;

import org.junit.Test;

public class Demo1 {
	
	@Test
	public void run(){		//System.out.println(add(3,4));

		//add();
		//add(1);
		System.out.println(add(1,3));
		System.out.println(add(1,3,6));
	}
	
	/**
	 * 可变参数
	 * @param nums
	 * @return
	 */
	public int add(int...nums){
		int sum = 0;
		for(int i=0;i<nums.length;i++){
			sum += nums[i];
		}
		return sum;
	}
	
	/*public int add(int a,int b){
		return a+b;
	}
	
	public int add(int a,int b,int c){
		return a+b+c;
	}*/
	
}
