package ctci.Chapter9;

import java.util.ArrayList;

/**
 * @author longyang
 * Subject: Write a method to return all subsets of a set
 */
public class CtCI_9_4 {
	public static void main(String[] args){
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(int i = 1; i <= 2; i ++){
			input.add(1);
		}
		
		for(ArrayList<Integer> set : subsetDistinct(input)){
			System.out.print("<");
			for(int elem : set){
				System.out.print(elem + "  ");
			}
			System.out.println(">");
		}
	}
	
	/**
	 * Case 1: the elements inside the set are all distinct.
	 */
	private static ArrayList<ArrayList<Integer>> subsetDistinct(ArrayList<Integer> set){
		if(set == null){
			return null;
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		//Add empty set into the result set.
		res.add(new ArrayList<Integer>());
		ArrayList<Integer> tmpSet;
		ArrayList<ArrayList<Integer>> tmpResSet = new ArrayList<ArrayList<Integer>>();
		for(int elem : set){
			for(ArrayList<Integer> _set : res){
				tmpSet = (ArrayList<Integer>)_set.clone();
				tmpSet.add(elem);
				tmpResSet.add(tmpSet);
			}
			res.addAll(tmpResSet);
			tmpResSet.clear();
		}
		return res;
	}
}
