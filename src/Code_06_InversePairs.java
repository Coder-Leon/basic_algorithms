import java.util.Arrays;

public class Code_06_InversePairs {
    public static int inversePairs(int[] arr) {
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
        int count = 0;
        while (p1 <= middle && p2 <= right) {                // 1 2 3 2 4
            count += arr[p1] > arr[p2] ? (middle - p1 + 1) : 0;
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
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
        return count;
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
            if (inversePairs(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Bingo!!!" : "Shit!!!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println(Arrays.toString(arr));
        System.out.println(comparator(arr));
        System.out.println(inversePairs(arr));
    }


    // for test
    private static int comparator(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                count += arr[i] > arr[j] ? 1 : 0;
            }
        }
        return count;
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
