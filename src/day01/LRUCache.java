package day01;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer,Integer> l=new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(l.containsKey(key)){
            int result=l.get(key);
            l.remove(key);
            l.put(key,result);
            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(l.containsKey(key)){
            l.remove(key);
        }else if(l.size()>=capacity){
            int first=l.entrySet().iterator().next().getKey();
            l.remove(first);
        }
        l.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(1,0);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
