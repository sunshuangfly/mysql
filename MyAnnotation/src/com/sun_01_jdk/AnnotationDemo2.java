package com.sun_01_jdk;

public class AnnotationDemo2 {

	
}

//情况1:jdk1.5表示复写父类的方法
class Animal_2 {
	public void init() {
		
	}
}

class Cat extends Animal_2 {
	@Override
	public void init() {
		
	}
}
//情况2:jdk1.6表示方法实现接口声明的方法
interface Parent_2 {
	public void init();
}

class Man implements Parent_2 {

	@Override
	public void init() {
		
	}
	
}
