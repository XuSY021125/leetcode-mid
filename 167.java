import java.util.Arrays;
import java.util.Scanner;

//167. 两数之和 II - 输入有序数组
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{2,7,11,15};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入目标值：");
        int target = scanner.nextInt();
        System.out.println(Arrays.toString(towsum(array,target)));
    }
    public static int[] towsum(int[] array,int target){
        int left = 0,right = array.length - 1;
        while (left < right){
            int sum = array[left] + array[right];
            if (sum == target){
                return new int[]{left + 1,right + 1};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}
