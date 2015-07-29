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

	public static List<List<Integer>> getSummingInts(List<Integer> list, List<List<Integer>> result) {
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
			
			result.add(newList);
			getSummingInts(newList, result);
		}

		return result;
	}
	
	public static List<String> getSumInts(Integer n) {
		if (n == null) {
			return null;
		}
		
		List<List<Integer>> result = getSummingInts(Arrays.asList(new Integer[] {n}), new ArrayList<List<Integer>>());
		return getStringResults(result);
	}
	
	private static List<String> getStringResults(List<List<Integer>> result) {
		if (result == null) {
			return null;
		}
		
		List<String> sumStrings = new ArrayList<String>();
		for (List<Integer> sumInts : result) {
			Collections.sort(sumInts);
			StringBuilder sumString = new StringBuilder();
			for (Integer i : sumInts) {
				sumString.append(i);
				sumString.append("+");
			}
			if (sumString.length() > 1) {
				sumString.replace(sumString.length() - 1, sumString.length(), "");
			}
			if (!sumStrings.contains(sumString.toString())) {
				sumStrings.add(sumString.toString());
			}
		}	
		return sumStrings;
	}

	public static void main(String[] args) {
		int i = 6;
		List<String> sums = getSumInts(i);
		System.out.println(Arrays.toString(sums.toArray()));
	}
}
