package com.demo.servletpath.enhance2.proxy;

//代理
//王婆这个人老聪明了，她太老了，是个男人都看不上她，但是她有智慧经验呀，他作为一类女人的代理！
public class Wp implements KindWoman {

	private KindWoman woman;

	public Wp() {
		//默认的话是潘金莲的代理
		this.woman = new Pjl();
	}

	public Wp(KindWoman woman) {
		//她可以是KindWomam的任何一个女人的代理，只要你是这一类型
		this.woman = woman;
	}

	public void throwEye() {
		//在这里做操作，可以控制是否调用真实行为。

		woman.throwEye();

		//在这个位置，可以在真实行为调用完成后，在做操作。
	}

	public void doSomething() {
		woman.doSomething();
	}

}
