package Recursion;


import java.util.Arrays;


public class full_permutation_of_numbers_without_duplicates {

    public static void permute(int[] num) {
        allPermutation(num, 0, num.length - 1);
    }

    private static void allPermutation(int[] a, int cursor, int k) {
        if (cursor == k) {
            System.out.println(Arrays.toString(a));
        }
        for (int i = cursor; i <= k; i++) {
            if (!judgeSwap(a, cursor + 1, k))
                continue;
            swap(a, cursor, i);
            System.out.println("--------------");
            System.out.println(Arrays.toString(a));
            System.out.println("--------------");
            allPermutation(a, cursor + 1, k);
            // 保证交换之后的顺序还是原来的顺序
            swap(a, cursor, i);
        }
    }

    private static void swap(int[] a, int cursor, int i) {
        int temp = a[cursor];
        a[cursor] = a[i];
        a[i] = temp;
    }

    private static boolean judgeSwap(int[] a, int cursor, int i) {
        for (int j = cursor; j < i; j++) {
            if (a[j] == a[i])
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
//        ArrayList<ArrayList<Integer>> result = permute(num);
//        for (ArrayList<Integer> integers : result) {
//            System.out.println(integers);
//        }
        permute(num);
    }
}
