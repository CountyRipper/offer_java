import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class A830_dan_satck {
    public static void main(String []args) throws IOException{
        BufferedReader r1 = new BufferedReader(new InputStreamReader(System.in));
        String s1 = r1.readLine();
        int n  = Integer.valueOf(s1);
        String s2 = r1.readLine();
        String []s3 = s2.split(" ");
        //int []a = new int[s3.length];
        Stack<Integer> st = new Stack<>();
        BufferedWriter w1 = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            while(!st.empty()&&st.peek()>=Integer.valueOf(s3[i])){
                st.pop();
            }
            if(st.empty()){
                w1.write(Integer.toString(-1));
                w1.write(" ");
                st.add(Integer.valueOf(s3[i]));
            }
            else{
                //有比他小的值
                w1.write(Integer.toString(st.peek()));
                w1.write(" ");
                st.add(Integer.valueOf(s3[i]));
            }
        }
        w1.flush();
    }
}
