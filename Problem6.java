package GeneralTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Level 6 
Given a number n, generate all distinct ways to write n as the sum 
of positive integers. For example, with n = 4, the options are 4, 
3 + 1, 2 + 2, 2 + 1 + 1, and 1 + 1 + 1 + 1. (Note that 3+1 and 1+3 
are considered the same and thus only 3+1 is a part of the result).
You can output your results as an array of strings 
(["4","3+4", "2+2", "2+1+1", "1+1+1+1"]).
 */
public class Problem6 {

    public static List<String> getSummingInts(List<Integer> list, List<String> result) {
        if (list == null || list.isEmpty() || result == null) {
            return null;
        }
        
        int firstInt = list.get(0);
        for (int j = 1; j < firstInt/2 + 1; j++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(firstInt - j);
            newList.add(j);
            
            List<Integer> i = new ArrayList<>(list);
            for (int k = 1; k < i.size(); k++) {
                newList.add(i.get(k));
            }
            String sum = list2String(newList);
            if (!result.contains(sum)) {
                result.add(sum);
            }
            getSummingInts(newList, result);
        }

        return result;
    }
    
    private static String list2String(List<Integer> list) {
        List<Integer> intList = new ArrayList<>(list);
        Collections.sort(intList);
        StringBuilder sumString = new StringBuilder();
        for (Integer i : intList) {
            sumString.append(i);
            sumString.append("+");
        }
        if (sumString.length() > 1) {
            sumString.replace(sumString.length() - 1, sumString.length(), "");
        }
        return sumString.toString();
    }

    public static List<String> getSumInts(Integer n) {
        if (n == null) {
            return null;
        }
        return getSummingInts(Arrays.asList(new Integer[] {n}), new ArrayList<String>());
    }

    public static void main(String[] args) {
        int i = 4;
        List<String> sums = getSumInts(i);
        System.out.println(Arrays.toString(sums.toArray()));
    }
}

