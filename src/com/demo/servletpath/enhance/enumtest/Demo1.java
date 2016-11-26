package com.demo.servletpath.enhance.enumtest;

public class Demo1 {
	
}

enum Color{
	RED("红色"){
		@Override
		public void run2() {
			
		}
		
	},GREEN("绿色"){
		@Override
		public void run2() {
			
		}
	},BLUE("蓝色"){
		@Override
		public void run2() {
			
		}
	};
	private Color(String name){
		System.out.println(name);
	}
	
	public void run(){
		
	}
	
	public abstract void run2();
}