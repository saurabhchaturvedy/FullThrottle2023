import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {


    public int[][] mergeIntervals(int[][] intervals) {

        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Stack<int[]> stack = new Stack<>();

        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] preInterval = stack.peek();
            if (intervals[i][0] <= preInterval[1]) {
                preInterval[1] = Math.max(intervals[i][1], preInterval[1]);
            } else {
                //Add the interval onto the stack if not
                stack.add(new int[]{intervals[i][0], intervals[i][1]});
            }


        }


        return stack.toArray(new int[stack.size()][2]);
    }


    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] ints = mergeIntervals.mergeIntervals(intervals);
        Arrays.stream(ints).forEach(System.out::println);

        for (int[] x : ints) {
            for (int t : x) {
                System.out.print(t + " ");
            }
        }
    }
}
