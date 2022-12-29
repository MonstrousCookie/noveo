package Array;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {

        int[] colors = {2,0,2,1,1,0};

        System.out.println(Arrays.toString(colors));

        sortColors(colors);

        System.out.println(Arrays.toString(colors));

    }

    // O(N^2) Time
    // O(1) Space
    public static void sortColors(int[] colors) {
        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[j] < colors[i]) {
                    int temp = colors[i];
                    colors[i] = colors[j];
                    colors[j] = temp;
                }
            }
        }
    }

}
