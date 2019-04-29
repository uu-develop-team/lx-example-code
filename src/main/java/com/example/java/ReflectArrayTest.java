package com.example.java;

import java.lang.reflect.Array;

public class ReflectArrayTest {

	public static void main(String[] args) throws Exception {
		String[] arg = (String[]) Array.newInstance(String.class, 3);
		Array.set(arg, 0, "123");
		Array.set(arg, 1, "456");
		System.out.println(Array.get(arg, 0));
		
		//int 数组class对像
		Class arrayClass = Class.forName("[I");
		//String数组
		Class arrayClass1 = Class.forName("[Ljava.lang.String");
		
		System.out.println(arrayClass1.isArray());
		
		arrayClass1.getComponentType();//获取数组中的类型
	}
}
