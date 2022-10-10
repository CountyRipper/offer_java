public class lc215{
    public static void main(String[] args) {
        int []arr = {3,2,1,5,6,4};
        int k = 2;
        int res = getLeastNumbers(arr, arr.length-k);
        System.out.println(res);
    }
    static int getLeastNumbers(int[] arr, int k) {
        //if(k>=arr.length) return null;
        quickSort(arr, k, 0, arr.length-1);
        return arr[k];

    }
    static void quickSort(int[] nums,int k,int l,int r){
        int i=l,j=r;
        int pivot = nums[l];
        while(i<j){
            while(i<j&&nums[j]>=pivot){j--;}
            nums[i] = nums[j];
            while(i<j&&nums[i]<=pivot){i++;}
            //swap(nums, i, j);
            nums[j] = nums[i];
        }
        //swap(nums, i, l);
        nums[j] = pivot;
        if(i>k)  quickSort(nums, k, l, i-1);
        if(i<k)  quickSort(nums, k, i+1, r);
        //return Arrays.copyOf(nums, k);
    }
    static void swap(int[] nums,int i, int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j] = t;
    }

    
}
