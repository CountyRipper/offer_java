import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private int capacity;
    private Map<Integer,linknode> m1 = new HashMap<>();
    linknode head;
    linknode end;
    int size=0;
    class linknode{
        int key;
        int value;
        linknode next;
        linknode prev;
        public linknode(){}
        public linknode(int _key, int _value){
            key = _key; value=_value;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new linknode();
        end = new linknode();
        head.next=end;
        end.prev=head;
    }
    
    public int get(int key) {
        if(m1.get(key)!=null){
            // 移动到头部
            linknode cur = m1.get(key);
            movetohead(cur);
            return m1.get(key).value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        linknode n = m1.get(key);
        if(n!=null){
            //modify
            n.value = value;
            movetohead(n);
        }
        else{
            
            //insert
            n = new linknode(key,value);
            m1.put(key, n);
            if(capacity==size){
                //需要删除
                removelast();
            }
            addtohead(n);
        }
    }
    public void addtohead(linknode n){
        n.next = head.next;//head 的下一个node相关操作
        head.next.prev = n; 
        head.next = n;
        n.prev = head;
        size++;
    }
    public void movetohead(linknode n){
        //浅拷贝
        //删除
        n.prev.next=n.next;
        n.next.prev = n.prev;
        //加到头部
        head.next.prev=n;
        n.next = head.next;
        head.next = n;
        n.prev = head;
        
    }
    public void removelast(){
        //确保head和end之间至少有一个node
        try {
            m1.remove(end.prev.key);
            end.prev.prev.next=end;
            end.prev=end.prev.prev;
            size--;
        } catch (Exception e) {
            System.err.println(e.toString());
            
        }
    }
}
public class lc146 {
    
}
