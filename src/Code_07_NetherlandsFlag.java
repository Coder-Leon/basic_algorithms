import java.util.Arrays;

public class Code_07_NetherlandsFlag {
    public static void partition(int[] arr, int num) {
        int left = -1;
        int right = arr.length;
        int cur = 0;
        while (cur < right) {
            if (arr[cur] < num) {
                swap(arr, ++left, cur++);
            } else if (arr[cur] == num) {
                cur++;
            } else {
                swap(arr, --right, cur);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray();
        System.out.println(Arrays.toString(arr));
        partition(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    // for test
    public static int[] generateRandomArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10);
        }
        return arr;
    }
}
