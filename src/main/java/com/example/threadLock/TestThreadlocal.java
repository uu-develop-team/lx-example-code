package com.example.threadLock;

public class TestThreadlocal {
	
	public static void main(String[] args) throws Exception {
		Runnable runnable = new Runnable() {	
			public void run() {
				TestBaseThreadLocal.set();
				TestBaseThreadLocal.get();
			}
		};
		Thread t1 = new Thread(runnable);
		t1.start();
		Thread t2 = new Thread(runnable);
		t2.start();
		TestBaseThreadLocal.get();
	}
}
