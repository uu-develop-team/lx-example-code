package com.example.redis;

public class TestRedisLock {

	private static int i=0;
	
	public static void main(String[] args) {
		Runnable runn = new Runnable() {
			public void run() {
				try {
					play();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		while(true) {
			new Thread(runn).start();
		}
		
	}
	
	private static void play() throws Exception {
		String lockName = "test";
		DistributedRedisLock.acquire(lockName);
		Thread.sleep(1000);
		System.out.println(i++);
		DistributedRedisLock.release(lockName);
	}
	
}
