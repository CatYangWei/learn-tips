package com.yang.learn.cache.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

import java.net.URL;

/**
 * @author coffezcat
 * @title: XmlGetStarted
 * @description: TODO
 * @date 2019-09-23 11:17
 */
public class XmlGetStarted {
    public static void main(String[] args) {
        //获取配置资源
        URL configUrl =  new XmlGetStarted().getClass().getResource("/cache.xml");
        //从xmlConfig构造一个CacheManger并且初始化
        Configuration xmlConfig = new XmlConfiguration(configUrl);
        CacheManager cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        cacheManager.init();
        Cache<String,String> cache = cacheManager.getCache("c1",String.class,String.class);
        cache.put("K","V");
        System.out.println(cache.get("K"));


    }
}
