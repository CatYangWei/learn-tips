package com.yang.learn.base.datatype;

import com.yang.learn.base.lfu.Node;

import java.util.PriorityQueue;

/**
 * @author coffezcat
 * @title: PriorityQueen
 * @description: TODO
 * @date 2019-09-25 17:06
 */
public class PriorityQueueExample {
    public static void main(String[] args) {
        //用来存储元素
        PriorityQueue<Node<String>> priorityQueue = new PriorityQueue<>();

        Node<String> node1 = new Node<>("1");
        Node<String> node2 = new Node<>("2");
        node2.getCount();
        Node<String> node3 = new Node<>("3");
        priorityQueue.add(node2);
        priorityQueue.add(node1);
        priorityQueue.add(node3);


        System.out.println(priorityQueue.peek().getVal());
        System.out.println(priorityQueue.remove().getVal());


    }

}
