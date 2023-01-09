package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {

        int[] arr = {18, 15, 11, 4, 4, 1, 33};

        System.out.println(Arrays.toString(arr));
        
        bucketSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void bucketSort(int[] arr) {

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        List<Integer>[] buckets = new List[max + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length; i++) {
            buckets[arr[i]].add(arr[i]);
        }

        for (int i = 0; i < buckets.length; i++) {
            buckets[i].sort(null);
        }

        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }

    }

}
