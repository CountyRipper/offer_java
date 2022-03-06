import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class repair {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(System.in));
        String s1 = r1.readLine();
        int n = Integer.valueOf(s1);
        String s2 = r1.readLine();
        String s3[] = s2.split(" ");
        Integer v[] = new Integer[n];
        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.valueOf(s3[i]);
        }
        Long res = repairnum(v);
        BufferedWriter w1 = new BufferedWriter(new OutputStreamWriter(System.out));
        w1.write(res.toString());
        w1.flush();
    }
    static long repairnum(Integer a[]){
        count = 0;
        merge_sort(a, 0, a.length-1);
        return count;
    }
    static void merge_sort(Integer a[], int l, int r){
        if(l>=r) return ;
        int mid = (l+r)/2;
        merge_sort(a, l, mid);
        merge_sort(a, mid+1, r);
        Integer tmp[] = new Integer[r-l+1];
        int m = 0;
        int i=l, j= mid+1;
        while(i<=mid&&j<=r){
            if(a[i]<=a[j]) tmp[m++] = a[i++];
            else{
                tmp[m++] = a[j++];
                //核心代码，如何求有多少个逆序对
                //如果出现一个逆序对，就用count加上i到左半边剩余的数(这些都是逆序的)
                //右边则不用管，因为我们只针对当前右边的每一个数判断左边的逆序个数
                count+=(mid-i+1);
            }
        }
        while(i<=mid){
            tmp[m++] = a[i++];
            //count+=(j-i);            
        }
        while(j<=r) tmp[m++] = a[j++];
        for(i = 0; i< (r-l+1); i++){
            a[l+i] = tmp[i];
        }
    }
}
