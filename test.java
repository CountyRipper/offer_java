import java.lang.reflect.Method;

public class test{
    public static void main(String[] args) {
        String [] arr = {"n", "dgf","gefrd"};
        printarry(arr);
        stu s1 = new stu("lihua", 16);
        Class ref = s1.getClass();
        System.out.println(ref);
        Method[] mlist = ref.getDeclaredMethods();
        for (Method method : mlist) {
            System.out.println(method.getName());
        }
        int [] ai = {1,2,3,45,6,8};
        System.out.println(ai.length);
    }
    public  static <E> void printarry(E[] inputarr){
        for (E e : inputarr) {
            System.out.printf("%s ",e);
        }
        System.out.println();
    }
}
class stu{
    private String name;
    private int age;
    public stu(String name,int age){
        this.name=name;
        this.age=age;
    }
}
