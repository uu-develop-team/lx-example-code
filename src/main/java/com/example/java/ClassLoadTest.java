package com.example.java;

public class ClassLoadTest {
	public static void main(String[] args) throws Exception {
		ClassLoader cl = ClassLoadTest.class.getClassLoader();
		Class clazz = cl.loadClass("com.example.java.Snippet");
		System.out.println(clazz.getName());
	}
}
