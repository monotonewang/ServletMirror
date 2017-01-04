package com.demo.servletpath.enhance2.proxy;

//水浒传是这样写的：西门庆被潘金莲用竹竿敲了一下，西门庆看痴迷了，被王婆看到了，就开始撮合两人好事，王婆作为潘金莲的代理人收了不少好处费，那我们假设一下：
//如果没有王婆在中间牵线，这两个不要脸的能成事吗？难说得很
public class Xmq {

	public static void main(String[] args) {
	
		KindWoman woman = new Wp();

		woman.throwEye();//真实执行的是潘金莲，但是我们看不到，所以屏蔽了真实行为。

		woman.doSomething();//   //看到没有表面是王婆在做，其实是潘金莲


		//西门庆勾引贾氏
		JiaShi jiaShi = new JiaShi();
		woman = new Wp(jiaShi);
		woman.doSomething();
		woman.throwEye();
	}
}
