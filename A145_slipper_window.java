import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
//滑动窗口最大最小值，维持一个双端队列来支持最大最小值
public class A145_slipper_window {
    public static void main(String[] args) throws IOException {
        Scanner s1 = new Scanner(System.in);
        LinkedList<Integer> minq = new LinkedList<>();
        LinkedList<Integer> minp = new LinkedList<>();
        LinkedList<Integer> maxq = new LinkedList<>();
        LinkedList<Integer> maxp = new LinkedList<>();
        int n = s1.nextInt();
        int m = s1.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s1.nextInt();
        }
        s1.close();
        minq.add(a[0]);minp.add(0);
        maxq.add(a[0]);maxp.add(0);
        // min队列队首总是最小值
        // max队列队首总是最大
        for (int i = 1; i < m; i++) {
            if (maxq.getLast() > a[i]) {
                maxq.add(a[i]);
                maxp.add(i);
            } else {
                while (!maxq.isEmpty() && maxq.getLast() < a[i]) {
                    maxq.removeLast();
                    maxp.removeLast();
                }
                maxq.add(a[i]);
                maxp.add(i);
            }
            if (minq.getLast() < a[i]) {
                minq.add(a[i]);
                minp.add(i);
            } else {
                while (!minq.isEmpty() && minq.getLast() > a[i]) {
                    minq.removeLast();
                    minp.removeLast();
                }
                minq.add(a[i]);
                minp.add(i);
            }
        }
        // for min value
        for (int i = 0; i < n - m+1; i++) {
            while (!minq.isEmpty() && minq.getLast() > a[i + m - 1]) {
                minq.removeLast();
                minp.removeLast();
            }
            minq.add(a[i + m - 1]);
            minp.add(i + m - 1);
            while (minp.getFirst() < i) {
                minq.removeFirst();
                minp.removeFirst();
            }
            System.out.print(Integer.toString(minq.getFirst())+" ");
        }
        System.out.println();
                // for max value
        // 保证最大队列的值都比新加入的大（或者持平）
        for (int i = 0; i < n - m+1; i++) {
            while (!maxq.isEmpty() && maxq.getLast() < a[i + m - 1]) {
                maxq.removeLast();
                maxp.removeLast();
            }
            maxq.add(a[i + m - 1]);
            maxp.add(i + m + 1);
            while (maxp.getFirst() < i) {
                maxp.removeFirst();
                maxq.removeFirst();
            }
            System.out.print(Integer.toString(maxq.getFirst())+" ");
        }
        System.out.println();
    }
}
