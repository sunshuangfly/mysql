package com.sun_01_jdk;

import java.util.ArrayList;
import java.util.List;
//���ƾ���ע��
@SuppressWarnings("serial")
public class AnnotationDemo3 implements java.io.Serializable{

	@SuppressWarnings({ "deprecation", "unused", "rawtypes" })
	public static void main(String[] args) {
		List list = new ArrayList<>();
		
		new Thread().stop();
	}
}
