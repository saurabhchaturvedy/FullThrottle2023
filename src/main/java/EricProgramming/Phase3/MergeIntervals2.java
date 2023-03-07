import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals2 {


    private static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length < 2) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedIntervals = new ArrayList<>();

        int[] previousInterval = intervals[0];

        int i = 1;

        while (i < intervals.length) {
            int[] interval = intervals[i];
            if (interval[0] <= previousInterval[1]) {
                previousInterval[1] = Math.max(interval[1], previousInterval[1]);
            } else {
                mergedIntervals.add(previousInterval);
                previousInterval = interval;
            }

            i = i + 1;
        }

        mergedIntervals.add(previousInterval);
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }


    public static void main(String[] args) {

        int[][] arr = {{1, 4}, {2, 5}, {7, 9}};
    }
}
