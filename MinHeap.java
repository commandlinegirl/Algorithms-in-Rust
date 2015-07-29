package GeneralTests;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    private List<Integer> list;
    
    public MinHeap() {
        list = new ArrayList<>();
    }

    private void popMinHeapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = i;
        
        if (left < list.size() && list.get(left) < list.get(min)) {
            min = left;
        }
        if (right < list.size() && list.get(right) < list.get(min)) {
            min = right;
        }
        
        if (min != i) {
            swap(i, min);
            popMinHeapify(min);
        }
    }

    private void addMinHeapify(int i) {
        int parent = (int) Math.floor((i - 1)/2);
        if (parent < list.size() && list.get(parent) > list.get(i)) {
            swap(parent, i);
            addMinHeapify(parent);
        }
    }

    private void swap(int a, int b) {
        Integer temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
    
    public void push(Integer i) {
        list.add(i);
        addMinHeapify(list.isEmpty() ? 0 : list.size() - 1);
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
    
    public Integer getMin() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
}
