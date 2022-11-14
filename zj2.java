import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class zj2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        int max = Integer.parseInt(str1[1]);
        String[] str2 = scanner.nextLine().split(" ");
        String[] symbols = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        HashMap<String,Integer>map = new HashMap<>();
        for(String s:str2){
            if(map.containsKey(s)){
                int count = map.get(s);
                map.put(s, count+1);
            }
            else{
                map.put(s, 1);
            }
            ArrayList<Integer> langkeys = new ArrayList<>();
            ArrayList<Integer> shortkeys = new ArrayList<>();
            for(String ss:map.keySet()){
                if(map.get(ss)==2){
                    shortkeys.add(Integer.parseInt(ss));
                }
                else if(map.get(ss)>2){
                    langkeys.add(Integer.parseInt(ss));
                    shortkeys.add(Integer.parseInt(ss));
                }

            }
            int max_len=0;
            String max_pair="0, 0";
            for(int langkey:langkeys){
                for(int shortkey:shortkeys){
                    if(langkey!=shortkey){
                        int allcount = langkey*3+shortkey*2;
                        if(allcount<=max){
                            if(allcount>max_len){
                                max_len = allcount;
                                max_pair = String.valueOf(langkey)+" "+String.valueOf(shortkey);
                            }
                        }
                    }
                    
                }
            }
            System.out.println(max_pair);
        }    
    }   
}
