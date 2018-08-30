import java.util.Arrays;

public class Code_12_MaxGap {

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bucketId = 0;
        for (int i = 0; i < len; i++) {
            bucketId = getBucketId(nums[i], len, min, max);
            mins[bucketId] = hasNum[bucketId] ? Math.min(mins[bucketId], nums[i]) : nums[i];
            maxs[bucketId] = hasNum[bucketId] ? Math.max(maxs[bucketId], nums[i]) : nums[i];
            hasNum[bucketId] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;

    }

    public static int getBucketId(int num, int len, int min, int max) {
        return (int) ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 50;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Bingo!!" : "Shit!!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println(Arrays.toString(arr));
        System.out.println(maxGap(arr));
    }


    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
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
