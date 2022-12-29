package Array;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {

        int[] colors = {2,0,2,1,1,0};

        System.out.println(Arrays.toString(colors));

        heapSort(colors);

        System.out.println(Arrays.toString(colors));

    }

    // Time (N log(N))
    // Space (N log(N))
    public static void heapSort(int[] arr) {
        createHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void createHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void heapify(int[] arr, int heapSize, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, heapSize, largest);
        }
    }

}
