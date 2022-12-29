package HashMap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {

    private final int size;
    private final List<List<int[]>> map;

    public MyHashMap() {
        this.size = 10000;
        this.map = new ArrayList<>(this.size);
        for (int i = 0; i < this.size; i++) {
            this.map.add(new ArrayList<>());
        }
    }

    private int hash(int key) {
        return key % this.size;
    }

    // O(1) Time
    // O(N) Space
    public void put(int key, int value) {
        int h = this.hash(key);
        List<int[]> bucket = this.map.get(h);
        for (int[] entry : bucket) {
            if (entry[0] == key) {
                entry[1] = value;
                return;
            }
        }
        bucket.add(new int[]{key, value});
    }

    // O(1) Time
    // O(N) Space
    public int get(int key) {
        int h = this.hash(key);
        List<int[]> bucket = this.map.get(h);
        for (int[] entry : bucket) {
            if (entry[0] == key) {
                return entry[1];
            }
        }
        return -1;
    }

    // O(1) Time
    // O(N) Space
    public void remove(int key) {
        int h = this.hash(key);
        List<int[]> bucket = this.map.get(h);
        for (int i = 0; i < bucket.size(); i++) {
            int[] entry = bucket.get(i);
            if (entry[0] == key) {
                bucket.remove(i);
                return;
            }
        }
    }

}
