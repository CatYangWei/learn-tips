package com.yang.learn.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author yangweia
 * @title
 * @date 2019年04月02日
 * @since v1.0.0
 */
public class BloomFilterExample {
    public static void main(String[] args) {
        BloomFilter<Integer> bloom = com.google.common.hash.BloomFilter.create(Funnels.integerFunnel(),10000000);

    }
}
