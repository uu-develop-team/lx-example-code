package com.example.redis;

import org.redisson.Redisson;
import org.redisson.config.Config;

public class RedissonManager {
    private static Config config = new Config();
    //����redisso����
    private static Redisson redisson = null;
    //ʵ����redisson
	static{
	     config.useSingleServer().setAddress("127.0.0.1:6379").setPassword("12345");
	          //�õ�redisson����
	     redisson = (Redisson) Redisson.create(config);
	
	}
	//��ȡredisson����ķ���
    public static Redisson getRedisson(){
        return redisson;
    }
}