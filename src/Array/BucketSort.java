package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {

        int[] arr = {18, 44, 33, 12, 22};

        System.out.println(Arrays.toString(arr));

        bucketSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void bucketSort(int[] arr) {

        // Find the maximum value in the array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create a list of buckets
        List<Integer>[] buckets = new List[max + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute the elements of the array into the buckets
        for (int i = 0; i < arr.length; i++) {
            buckets[arr[i]].add(arr[i]);
        }

        // Sort the elements within each bucket
        for (int i = 0; i < buckets.length; i++) {
            buckets[i].sort(null);
        }

        // Concatenate the sorted buckets back into the array
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

}
