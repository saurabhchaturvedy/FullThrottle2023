import java.util.Arrays;

public class TwoSumII {


    public int[] twoSum(int[] arr, int target) {
        if (arr.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = arr.length - 1;
        int sum = 0;

        while (left < right) {

            sum = arr[left] + arr[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }


    public static void main(String[] args) {


        int[] arr = {2, 4, 6, 8};

        TwoSumII twoSumII = new TwoSumII();
        int[] ints = twoSumII.twoSum(arr, 8);

        Arrays.stream(ints).forEach(System.out::println);

    }
}
