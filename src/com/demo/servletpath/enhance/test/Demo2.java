package com.demo.servletpath.enhance.test;

import java.util.Arrays;

public class Demo2 {

	public static void main(String[] args) {
		int [] arr = new int[]{11,22,33,44,55,66,77};
		
		int idx = Arrays.binarySearch(arr, 55);
		
		System.out.println(idx);
	}
	
}
