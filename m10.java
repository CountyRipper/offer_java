
/**
 * m10
 */
public class m10 {
    
    public static void main(String[] args) {
        int []ar = {2,2,2,0,1};
        System.out.println(minarray(ar));
    }
    public static int minarray(int[] numbers){
        int left=0;
        int right=numbers.length-1;
        int mid = (left+right)/2;
        while(left<right){
            if(right-left==1) return Math.min(numbers[right], numbers[left]);
            if(numbers[right]==numbers[mid]&&numbers[mid]==numbers[right]){
                int min=numbers[left];
                for (int i = left; i <= right; i++) {
                    if(numbers[i]<min){
                        min=numbers[i];
                        break;
                    }
                }
                return min;
            }
            if(numbers[mid]>numbers[right]){
                left=mid;
                mid=(right+left)/2;
            }
            else{
                right=mid;
                mid=(right+left)/2;
            }
            
        }
        return numbers[left];
    }
}