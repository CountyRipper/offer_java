import java.util.Scanner;

public class zj1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int[] tmps = new int[n];
        for (int i = 0; i < n; i++) {
            tmps[i] = Integer.parseInt(nk[i + 1]);
        }
        int vn = 0;
        int m_day = 0;
        int days = -1;
        for (int j = 0; j < n; j++) {
            if (vn == 0) {
                if (tmps[j] >= -10 && tmps[j] <= 30) {
                    days = 0;
                    vn = 1;
                }
            } else {
                if (tmps[j] >= -10 && tmps[j] <= 30) {
                    days++;
                    vn = vn * 2;
                } else {
                    days++;
                    if (vn <= 4) {
                        vn = 0;
                        if (days > m_day) {
                            m_day = days;
                        }
                        days = -1;
                    }
                    else{
                        vn=vn/2;
                        if(vn<=4){
                            vn=0;
                            if(days>m_day){
                                m_day =days;
                            }
                        }
                    }
                }
            }
        }
        if (vn >= 1) {
            if (days > m_day) {
                m_day = days;
            }
        }
        System.out.println(m_day);
    }
}
