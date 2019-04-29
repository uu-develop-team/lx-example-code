package com.example.threadLock;

public class TestBaseThreadLocal {

	private static ThreadLocal<String> ll2 = new ThreadLocal<String>();
	
	static {
		ll2.set("ll2");
	}
	
	private static ThreadLocal<Integer> ll = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 100;
		};
	};
	
	public static void get(){
		System.out.println(ll.get());
		System.out.println(ll2.get());
	}
	public static void set() {
		ll2.set(ll2.get()+"test");
		ll.set(ll.get()+10);
	}
}
