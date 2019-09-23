package com.yang.learn.cache.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;

import java.time.Duration;
import java.util.BitSet;
import java.util.HashMap;

public class GetStarted {
    public static void main(String[] args) {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()//生命一个cacheBuilder
                .withCache("myCache",CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(String.class,String.class,ResourcePoolsBuilder.heap(20).disk(20, MemoryUnit.MB)))//声明一个cache
                .build(true);


      Cache<String,String> myCache =  cacheManager.getCache("myCache",String.class,String.class);//获取这个cache
      myCache.put("key1","v1");//使用
      System.out.println(myCache.get("key1"));
      //移除
      cacheManager.removeCache("myCache");
      cacheManager.close();
    }
}
