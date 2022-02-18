import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class quik_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader b1 = new BufferedReader(new InputStreamReader(System.in));
        String s1 = b1.readLine();
        int n = Integer.valueOf(s1);
        String str = b1.readLine();
        String a[]=str.split(" ");
        Integer v[] = new Integer[n];
        for(int i = 0; i < a.length; i++){
            v[i] = Integer.valueOf(a[i]);
        }
        //或者包装bufferedwriter
        quik_sort(v,0,v.length-1);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < v.length; i++) {
            //writer.write(a[i]);
            writer.write(v[i].toString());
            writer.write(" ");
        }
        writer.flush();
    }
    public static void quik_sort(Integer a[],int l, int r){
        if(l>=r) return;
        int i = l-1, j = r+1;
        int x = a[(l+r)>>1];
        while(i<j){
            while(a[++i]<x){}
            while(a[--j]>x){}
            if(i<j){
                int t = a[i];
                a[i] = a[j];
                a[j] =  t;
            }
        }
        quik_sort(a,l,j);
        quik_sort(a,j+1,r);
    }
}
