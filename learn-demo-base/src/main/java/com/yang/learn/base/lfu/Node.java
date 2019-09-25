package com.yang.learn.base.lfu;

/**
 * @author coffezcat
 * @title: Node
 * @description: TODO
 * @date 2019-09-25 17:22
 */
public class Node<V> implements Comparable<Node>{

    V val;
    long timestamp;
    Integer count;


    public Node(V val){
        this.val = val;
        this.count=1;
        this.timestamp = System.currentTimeMillis();
    }


    public V getVal(){
        this.count++;
        this.timestamp=timestamp;
        return val;
    }


    @Override
    public int compareTo(Node o) {
        if(o.getCount()>this.count){
            return -1;
        }else if(o.getCount()<this.count){
            return 1;
        }else{
            if(o.getTimestamp()>this.getTimestamp()){
                return -1;
            }else if(o.getTimestamp()<this.getTimestamp()){
                return 1;
            }else{
                return 0;
            }
        }

    }

    public long getTimestamp() {
        return timestamp;
    }

    public Integer getCount() {
        return count;
    }
}
