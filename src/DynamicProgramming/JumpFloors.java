package DynamicProgramming;

public class JumpFloors {
    private static int result = 0;

    public static int jumpFloor(int number) {
        if (number <= 1)
            return 1;
        return jumpFloor(number - 1) + jumpFloor(number - 2);
    }

    public static int dynamicProgramming(int number) {
        int[] result = new int[number + 1];
        result[0] = result[1] = 1;
        for (int i = 2; i < number + 1; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[number];
    }

    public static int dynamicProgrammingOptimize(int number) {
        int a = 1, b = 1, c = 0;
        for (int i = 2; i <= number; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(dynamicProgrammingOptimize(7));
    }
}
