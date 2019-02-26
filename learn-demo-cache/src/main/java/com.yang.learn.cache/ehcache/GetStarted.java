package com.yang.learn.cache.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

public class GetStarted {
    public static void main(String[] args) {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("mycache",CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(String.class,String.class,ResourcePoolsBuilder.heap(20))).build(true);
      Cache<String,String> myCache =  cacheManager.getCache("mycache",String.class,String.class);
      myCache.put("key1","v1");
      System.out.println(myCache.get("key1"));

    }
}
