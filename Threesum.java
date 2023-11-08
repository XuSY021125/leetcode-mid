import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Threesum {
    public static void main(String[] args) {
        int[] array = new int[]{-4,-2,2,7,6,11,15};
        Arrays.sort(array);
        System.out.println(threesum(array));
    }
    public static List<List<Integer>> threesum(int[] array){
        List<List<Integer>> nums = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0){
                break;
            }
            if (i > 0 && array[i] == array[i-1]){
                continue;
            }
            int left = i + 1,right = array.length - 1;
            while (left < right){
                int sum = array[i] + array[left] + array[right];
                if (sum == 0) {
                    nums.add(Arrays.asList(array[i], array[left], array[right]));
                    while (left < right && array[left] == array[left + 1]) {
                        left++;
                    }
                    while (left < right && array[right] == array[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if (sum < 0){
                    left++;
                }
                else if (sum > 0){
                    right--;
                }
            }
        }
        return nums;
    }
}