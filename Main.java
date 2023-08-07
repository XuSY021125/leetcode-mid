import java.util.Arrays;
import java.util.Scanner;

//215.数组中的第K个最大元素
public class Main {
    public static void main(String[] args) {
        int[] array=new int[]{2,5,4,1,3,8,8,7,6,9,11};
        int i;
        System.out.println("原数组为：");
        System.out.println(Arrays.toString(array));
        quickSort(array,0,array.length-1);
        System.out.println("排序后数组为：");
        System.out.println(Arrays.toString(array));
        System.out.println("请输入要查找的第K个最大数字：");
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        System.out.println("第" + k +"个最大数字是" + number(array,k));
    }
    public static void swap(int[] array,int low,int high){
        int temp;
        temp=array[low];
        array[low]=array[high];
        array[high]=temp;
    }
    public static int quick(int[] array,int low,int high){
        int k=array[low];
        while (true){
            while (low<high && array[low]<k){
                low++;
            }
            while(low<high && array[high]>k){
                high--;
            }
            if(low>=high){
                break;
            }
            else{
                swap(array,low,high);
            }
            if(array[low]==array[high]){
                low++;
            }
        }
        return low;
    }

    public static void quickSort(int[] array,int low,int high){
        if(low<high){
            int k=quick(array,low,high);
            quickSort(array,low,k-1);
            quickSort(array,k+1,high);
        }
    }
    public static int number(int[] array,int k){
        int num = array[array.length - k];
        return num;
    }
}