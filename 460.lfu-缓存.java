import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU 缓存
 */

// @lc code=start
class LFUCache {

    int minfreq, capacity;
    Map<Integer, Node> nodemap;
    Map<Integer, Integer> freqMap;

    public LFUCache(int capacity) {
        this.minfreq = 0;
        this.capacity = capacity;
        nodemap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {

    }
    
    public void put(int key, int value) {

    }
}

class Node {
    int key;
    int val;
    int freq;

    Node(int key, int val, int freq) {
        this.freq = freq;
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

