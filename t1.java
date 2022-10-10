import java.lang.ref.SoftReference;

class M{

}
public class t1 {
    public static void main(String[] args) {
        M m = new M();
        M m1 = m;
        System.out.println(m);
        m = null;
        
        System.gc();
        System.out.println(m1);
        //SoftReference<byte[]> = new SoftReference<>(new byte[1024*1024*10] );
    }
    
}
