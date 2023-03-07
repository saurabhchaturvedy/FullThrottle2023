import java.util.Arrays;

public class MoveZeroes {


    public void moveZeroes(int[] arr) {
        if (arr.length < 2) return;

        int left = 0;
        int right = 1;

        while (right < arr.length) {
            if (arr[left] != 0) {
                left++;
                right++;
            } else if (arr[right] == 0) {

                right++;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        System.out.print(arr);
    }


    public static void main(String[] args) {

        int[] arr = {1, 3, 0, 5, 0, 7, 0, 0, 8, 9, 13, 0, 4};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
