import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Comparator;
//贪心法合并区间，需要排序
public class A802_merge_region {
    private static int[] a;
    private static ArrayList<int []> list = new ArrayList<int []>();
    public static void main(String[] args) throws IOException {
        BufferedReader b1 = new BufferedReader(new InputStreamReader(System.in));
        String s1 = b1.readLine();
        int n = Integer.valueOf(s1);
        for (int i = 0; i < n; i++) {
            a = new int[2];
            String s2 = b1.readLine();
            String []s3 = s2.split(" ");
            a[0] = Integer.valueOf(s3[0]);
            a[1] = Integer.valueOf(s3[1]);
            list.add(a);
        }
        // list.sort(new Comparator<int []>() {
        //     @Override
        //     public int compare(int []o1,int[]o2){
        //         return o1[0]-o2[0];
        //     }
        // });
        list.sort((int []o1,int []o2)->{return o1[0]-o2[0];});
        ArrayList<int[]> res=new ArrayList<>();
        int r =Integer.MIN_VALUE;
        int l = Integer.MIN_VALUE;
        //注意此时已经是有序的list了
        for(int []a:list){
            //如果下一个区间的左端大于新的的右端，说明出现新的区间
            if(a[0]>r){
                if(l!=Integer.MAX_VALUE){
                    res.add(new int[]{l,r});
                }
                l = a[0];r=a[1];
            }
            //不断更新右侧边界，左侧已经是排好序的了
            else{r = Math.max(r,a[1]);}
        }
        BufferedWriter r1 = new BufferedWriter(new OutputStreamWriter(System.out));
        r1.write(String.valueOf(res.size()));
        r1.flush();
    }
}
