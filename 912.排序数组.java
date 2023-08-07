import java.util.Arrays;

//912.排序数组
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{5,4,7,9,4,1,3,2};
        sort(array);
        System.out.println("排序后的数组为："+ Arrays.toString(array));
    }
    public static int Selectsort(int[] array,int i){
        int min = i;
        while (i+1< array.length){
            if (array[min]>array[i+1]){
                min = i+1;
            }
            i++;
        }
        return min;
    }
    public static void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int j = Selectsort(array,i);
            if (j != i){
                swap(array,j,i);
            }
        }
    }
    public static void swap(int[] array,int a,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
