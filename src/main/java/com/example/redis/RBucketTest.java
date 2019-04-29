package com.example.redis;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

public final class RBucketTest {
	
	public static void main(String[] args) {
		Config config = new Config();
		
		SingleServerConfig singleServerConfig = config.useSingleServer();
		singleServerConfig.setAddress("127.0.0.1:6379");
		singleServerConfig.setPassword("12345");
		
		RedissonClient redissonClient = Redisson.create(config);
		
		RBucket<String> bucket = redissonClient.getBucket("myBucket");
		bucket.set("ÄãºÃ£¡");
		bucket.set("123");
		bucket = redissonClient.getBucket("myBucket");
		System.out.println(bucket.get());
		
		redissonClient.shutdown();
	}

}