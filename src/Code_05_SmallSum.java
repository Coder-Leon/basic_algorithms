import java.util.Arrays;

public class Code_05_SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int middle = left + ((right - left) >> 1);
        return mergeSort(arr, left, middle) + mergeSort(arr, middle + 1, right)
                + merge(arr, left, middle, right);
    }

    public static int merge(int[] arr, int left, int middle, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = middle + 1;
        int res = 0;
        while (p1 <= middle && p2 <= right) {
            res += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0; // 计算每次分治后的最小和
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 50;
        int maxValue = 100;
        boolean succeed = true;
        // test case
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }
        System.out.println(succeed ? "Bingo!!!" : "Shit!!!");

        int arr[] = generateRandomArray(maxSize, maxValue);
        System.out.println(Arrays.toString(arr));
        System.out.println(smallSum(arr));
    }


    // for test
    private static int comparator(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    // for test
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

}
