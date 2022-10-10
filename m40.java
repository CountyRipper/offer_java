import java.util.Arrays;

public class m40{
    public static void main(String[] args) {
        int []arr = {3,2,1,5,4,7,2,4,6,8};
        int k = 4;
        int []res = getLeastNumbers(arr, k);
        for (int i : res) {
            System.out.print(Integer.toString(i)+" ");
        }
    }
    static int[] getLeastNumbers(int[] arr, int k) {
        if(k>=arr.length) return arr;
        return quickSort(arr, k, 0, arr.length-1);
    }
    static int[] quickSort(int[] nums,int k,int l,int r){
        int i=l,j=r;
        while(i<j){
            while(i<j&&nums[j]>=nums[l]){j--;}
            //nums[i] = nums[j];
            while(i<j&&nums[i]<=nums[l]){i++;}
            swap(nums, i, j);
            //nums[j] = nums[i];
        }
        swap(nums, i, l);
        //nums[j] = nums[l];
        if(i>k) return quickSort(nums, k, l, i-1);
        if(i<k) return quickSort(nums, k, i+1, r);
        return Arrays.copyOf(nums, k);
    }
    static void swap(int[] nums,int i, int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j] = t;
    }

    
}
