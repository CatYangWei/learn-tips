package com.yang.learn.base.collections;



/**
 * @author coffezcat
 * @title: Boot
 * @description: TODO
 * @date 2019/5/31 14:48
 */
public class Boot {
    public static void main(String[] args) {
        Node<Integer> loHead = null, loTail = null;

        for(int i=1;i<=5;i++){
            Node<Integer> e = new Node<>(i);
            if (loTail == null)
                loHead = e;
            else
                //作为HEAD的尾巴
                loTail.next = e;
            loTail = e;
        }

        System.out.println(111);
    }
    static class Node<K>{
        K val;
        Node<K> next;

        public Node(K v){
            this.val = v;
        }
    }




}
