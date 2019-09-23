package com.yang.learn.cache.ehcache;

import org.ehcache.PersistentCacheManager;
import org.ehcache.clustered.client.config.builders.ClusteringServiceConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;

import java.net.URI;

/**
 * @author coffezcat
 * @title: ClusterGetStarted
 * @description: 集群配置
 * @date 2019-09-23 13:42
 */
public class ClusterGetStarted {
    public static void main(String[] args) {
        CacheManagerBuilder<PersistentCacheManager> clusteredCacheManagerBuilder =
                CacheManagerBuilder.newCacheManagerBuilder()
                        .with(ClusteringServiceConfigurationBuilder.cluster(URI.create("terracotta://localhost/my-application"))
                                .autoCreate(c -> c));
        PersistentCacheManager cacheManager = clusteredCacheManagerBuilder.build(true);
        cacheManager.close();
    }
}
