package Recursion;

import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        allPermutation(a, 0, a.length - 1);

    }

    private static void allPermutation(int[] a, int cursor, int k) {
        for (int i = cursor; i <= k; i++) {
            swap(a, cursor, i);
            System.out.println(Arrays.toString(a));
            // 保证交换之前的序列还是 {1, 2, 3, 4}
            swap(a, cursor, i);
        }
    }

    private static void swap(int[] a, int cursor, int i) {
        int temp = a[cursor];
        a[cursor] = a[i];
        a[i] = temp;
    }
}
