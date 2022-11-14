import java.util.Scanner;

public class heap_sort {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        String[] str = s1.nextLine().split(" ");
        int[] nums = new int[str.length];
        for(int i = 0; i<nums.length;i++){
            nums[i] = Integer.parseInt(str[i]);
        }
        s1.close();
        heapSort(nums);
        for (int i : nums) {
            System.out.print(i+" ");
        }
        
    }
    public static void heapSort(int []nums){
        int N = nums.length;
        //构造一个大根堆
        for(int i=N/2-1;i>=0;i--){
            adjustHeap(nums, i, N);
        }
        for(int i = N-1;i>0;i--){
            int tmp = nums[0];//获取最大值
            nums[0] = nums[i];//末尾节点交换到最上层
            nums[i] = tmp;
            adjustHeap(nums, 0, i);//继续构建大根堆从0到i
        }
    }
    public static void adjustHeap(int[] nums, int start, int length){
        //从start到end的默认叶子节点或者子树已经被调整好的父结点为调整对象,一定是满二叉树
        int max = start;
        int l = 2*start+1;
        int r = 2*start+2;
        if(l<length&&nums[l]>nums[max]){
            max = l;//如果左边结点最大就上浮
        }
        if(r<length&&nums[r]>nums[max]){
            max = r;
        }
        if(max !=start){
            int tmp = nums[start];
            nums[start] = nums[max];
            nums[max] = tmp;//让该结点成为一个子大根堆顶点
            adjustHeap(nums, max, length);//往下递归调整结点
        }
    }
    
}
