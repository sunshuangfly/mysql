package com.sun_01_jdk;

public @interface MyAnno1 {
	/**
	 * 格式:修饰符 返回值类型 属性名() default 默认值
	 * 修饰符:public abstract,默认是且只能是
	 * 返回值类型:基本类型,String,Class,注解,枚举,以及以上类型的一维数组
	 * 属性名:自定义
	 * 默认值:可以省略
	 * 
	 * @return
	 */
	public abstract String username() default "默认值";
	public int age();
	public Class clazz();
	public MyAnno2 anno();
	public Color color();
	public String[] hobbies();
	
}
//枚举:相当于多例
enum Color {
	RED,BLUE;
}
