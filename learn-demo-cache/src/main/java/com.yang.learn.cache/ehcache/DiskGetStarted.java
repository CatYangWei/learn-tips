package com.yang.learn.cache.ehcache;

import org.ehcache.Cache;
import org.ehcache.PersistentCacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;

import java.io.File;

/**
 * @author coffezcat
 * @title: DiskGetStarted
 * @description: TODO
 * @date 2019-09-23 14:32
 */
public class DiskGetStarted {

    private static final Integer SIZE = 100000;
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        PersistentCacheManager persistentCacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence(new File(getStoragePath(), "myData")))//序列化到磁盘的路径
                .withCache("persistent-cache", CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                        ResourcePoolsBuilder.newResourcePoolsBuilder()
                                .heap(SIZE*2)
                                .disk(500, MemoryUnit.MB, true)
                        )//声明单个cache的配置
                )
                .build(true);

        Cache<Long,String> cache = persistentCacheManager.getCache("persistent-cache",Long.class, String.class);
        for (int i=0;i<SIZE;i++){
            //cache.put(Long.valueOf(i),String.valueOf(i));
            System.out.println(cache.get(Long.valueOf(i)));
        }
        System.out.println("cost time:"+(System.currentTimeMillis()-begin));
        persistentCacheManager.close();

    }


    public static String getStoragePath(){
        return "E:\\data\\encache_data";
    }
}
