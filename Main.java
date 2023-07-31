import java.util.Scanner;

//34. 在排序数组中查找元素的第一个和最后一个位置
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{5,7,7,8,8,10};
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入目标值：");
        int target = scan.nextInt();
        int left = left_bound(array,target);
        int right = right_bound(array,target);
        System.out.println("["+left+","+right+"]");
    }
    
    public static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 如果越界，target 肯定不存在，返回 -1
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    public static int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || right >= nums.length) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }
}