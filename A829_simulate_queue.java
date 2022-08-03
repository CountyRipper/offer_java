import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A829_simulate_queue {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        int n  = Integer.valueOf(s1);
        for (int i = 0; i <n ; i++) {
            String s2 = s.nextLine();
            String []s3 = s2.split(" ");
            if(s3.length>1){
                if(s3[0].equals("push")){
                    q1.add(Integer.valueOf(s3[1]));
                }
            }
            else{
                if(s3[0].equals("empty")){
                    if(q1.isEmpty()) System.out.println("YES\n");
                    else System.out.println("NO\n");
                }
                if(s3[0].equals("pop")){
                    q1.remove();
                }
                if(s3[0].equals("query")) System.out.println(q1.peek());
            }
        }
        s.close();
    }
    
}
