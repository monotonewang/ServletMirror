package com.demo.servletpath.enhance.generic;

import org.junit.Test;

import java.util.Arrays;


/**
 * 泛型的集合遍历
 * @author Administrator
 *
 */
public class GenericTest2 {
	
	/**
	 * 测试
	 */
	@Test
	public void run1(){
		Integer [] arr = new Integer[]{1,2,3,4,5,6,7};
		change(arr,1,3);
		System.out.println(Arrays.toString(arr));
		
		String [] strarr = new String[]{"aa","bb","cc","dd","ee","ff"};
		change(strarr,1,3);
		System.out.println(Arrays.toString(strarr));
	}
	
	/**
	 * 	自定义泛型方法
	 * 	* 声明泛型	<T>	放在返回值之前
	 */
	public <T> void change(T[] arr, int idx1, int idx2){
		T temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	/**
	 * 修改下标是idx1和idx2两个位置元素
	 * @param strarr
	 * @param idx1
	 * @param idx2
	 */
	/*
	public void change(String[] strarr, int idx1, int idx2) {
		String temp = strarr[idx1];
		strarr[idx1] = strarr[idx2];
		strarr[idx2] = temp;
	}*/

	/**
	 * 修改下标是idx1和idx2两个位置元素
	 * @param arr
	 * @param idx1
	 * @param idx2
	 */
	/*
	public void change(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}*/
	
	
	/**
	 * 
	 */
	@Test
	public void run2(){
		String [] strarr = new String[]{"aa","bb","cc","dd","ee","ff","hh"};
		// 打印的结果：ff ee dd cc bb aa
		reset(strarr);
		System.out.println(Arrays.toString(strarr));
	}
	
	/**
	 * 颠倒所有的元素
	 * @param arr
	 */
	public <T> void reset(T[] arr){
		for(int i=0;i<arr.length/2;i++){
			T temp = arr[i];
			arr[i] = arr[arr.length - 1 -i];
			arr[arr.length - 1 -i] = temp;
		}
	}
	
}






