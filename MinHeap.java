import java.util.ArrayList;
import java.util.List;

/* Simple min heap implementation in Java */
public class MinHeap {

    private List<Integer> list;
    
    public MinHeap() {
        list = new ArrayList<>();
    }

    private void popMinHeapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = i;
        
        if (withinList(left) && list.get(left) < list.get(min)) {
            min = left;
        }
        if (withinList(right) && list.get(right) < list.get(min)) {
            min = right;
        }
        if (min != i) {
            swap(i, min);
            popMinHeapify(min);
        }
    }

    private void addMinHeapify(int i) {
        int parent = (int) Math.floor((i - 1)/2);
        if (withinList(parent) && list.get(parent) > list.get(i)) {
            swap(parent, i);
            addMinHeapify(parent);
        }
    }

    private void swap(int a, int b) {
        if (withinList(a) && withinList(b)) {
            Integer temp = list.get(a);
            list.set(a, list.get(b));
            list.set(b, temp);
        }
    }

    private boolean withinList(int index) {
        return index < list.size();
    }   
 
    public void push(Integer i) {
        list.add(i);
        addMinHeapify(list.size() - 1);
    }

    public Integer pop() {
        if (list.isEmpty()) {
            return null;
        }
        Integer min = list.remove(0);
        popMinHeapify(0);
        return min;
    }
    
    public Integer peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
}
