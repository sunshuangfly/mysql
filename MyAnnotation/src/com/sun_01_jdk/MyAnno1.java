package com.sun_01_jdk;

public @interface MyAnno1 {
	/**
	 * ��ʽ:���η� ����ֵ���� ������() default Ĭ��ֵ
	 * ���η�:public abstract,Ĭ������ֻ����
	 * ����ֵ����:��������,String,Class,ע��,ö��,�Լ��������͵�һά����
	 * ������:�Զ���
	 * Ĭ��ֵ:����ʡ��
	 * 
	 * @return
	 */
	public abstract String username() default "Ĭ��ֵ";
	public int age();
	public Class clazz();
	public MyAnno2 anno();
	public Color color();
	public String[] hobbies();
	
}
//ö��:�൱�ڶ���
enum Color {
	RED,BLUE;
}
