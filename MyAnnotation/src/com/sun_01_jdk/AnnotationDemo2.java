package com.sun_01_jdk;

public class AnnotationDemo2 {

	
}

//���1:jdk1.5��ʾ��д����ķ���
class Animal_2 {
	public void init() {
		
	}
}

class Cat extends Animal_2 {
	@Override
	public void init() {
		
	}
}
//���2:jdk1.6��ʾ����ʵ�ֽӿ������ķ���
interface Parent_2 {
	public void init();
}

class Man implements Parent_2 {

	@Override
	public void init() {
		
	}
	
}
