package ctci.Chapter9;

import java.util.ArrayList;
/**
 * 
 * @author JasonYang
 * Subject: Write a method to compute all permutations of a string.
 */
public class CtCI_9_5 {
	public static void main(String[] args){
		String input = "abb";
		ArrayList<String> permutation = permutation(input);
		for(String s : permutation){
			System.out.println(s);
		}
		System.out.println(permutation.size());
	}
	
	private static ArrayList<String> permutation(String str){
		if(str == null){
			return null;
		}
		
		ArrayList<String> res = new ArrayList<String>();
		// 1. Add "" into the result ArrayList.
		res.add("");
		int len = str.length();
		ArrayList<String> tmpList = new ArrayList<String>();
		
		for(int i = 0; i < len; i++){
			for(String s : res){
				for(int j = 0; j <= i; j++){
					tmpList.add(s.substring(0, j) + str.charAt(i) + s.substring(j, i));
				}
			}
			res.clear();
			res.addAll(tmpList);
			tmpList.clear();
		}
		return res;
	}
}
