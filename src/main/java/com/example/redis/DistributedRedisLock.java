package com.example.redis;

import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RLock;

public class DistributedRedisLock {
   //���������л�ȡredisson����
    private static Redisson redisson = RedissonManager.getRedisson();
    private static final String LOCK_TITLE = "redisLock_";
   //����
    public static boolean acquire(String lockName){
       //����key����
        String key = LOCK_TITLE + lockName;
       //��ȡ������
        RLock mylock = redisson.getLock(key);
       //��������������������ʱ�䣬��ֹ�����Ĳ���
        mylock.lock(2, TimeUnit.MINUTES); 
        System.err.println("======lock======"+Thread.currentThread().getName());
       //�����ɹ�
        return  true;
    }
  //�����ͷ�
    public static void release(String lockName){
       //�����Ǻͼ���ʱ��ͬһ��key
        String key = LOCK_TITLE + lockName;
       //��ȡ������
        RLock mylock = redisson.getLock(key);
      //�ͷ�����������
        mylock.unlock();
        System.err.println("======unlock======"+Thread.currentThread().getName());
    }
}