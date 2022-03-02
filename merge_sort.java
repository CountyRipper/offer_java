import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class merge_sort {
    public static void main(String[] args) throws IOException{
        BufferedReader b1 = new BufferedReader(new InputStreamReader(System.in));
        String s1 = b1.readLine();
        int n = Integer.valueOf(s1);
        String s2 = b1.readLine();
        String s3[] = s2.split(" ");
        Integer a[] = new Integer[n];
        for (int i = 0; i < s3.length; i++) {
            a[i] = Integer.valueOf(s3[i]);
        }
        merge_sort(a, 0, n-1 );
        BufferedWriter w1 = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < a.length; i++) {
            w1.write(a[i].toString());
            w1.write(" ");
        }
        w1.flush();
    }
    public static void merge_sort(Integer q[],int l, int r){
        if(l>= r) return;
        int mid = (l+r)>>1;
        merge_sort(q, l, mid);
        merge_sort(q, mid+1, r);
        Integer tmp[] = new Integer[(r-l)+1];
        int n =0;
        int i =l, j = mid+1;
        while(i<=mid&&j<=r){
            if(q[i]<=q[j]){tmp[n++]=q[i++];}
            else tmp[n++]=q[j++];
        }
        while(i<=mid) tmp[n++] = q[i++];
        while(j<=r) tmp[n++] = q[j++];
        for (i=l, j = 0; i <=r ; j++,i++) {
            q[i] = tmp[j];
        }
    }
}
