package ctci.Chapter9;

import java.util.ArrayList;
/**
 * @author JasonYang
 * Implement an algorithm to print all valid combination of n-pairs of parentheses.
 */

public class CtCI_9_6 {
	public static void main(String[] args){
		for(String parenthese : validParentheses(3)){
			System.out.println(parenthese);
		}
	}
	
	private static ArrayList<String> validParentheses(int n){
		if(n < 0){
			return null;
		}
		
		ArrayList<String> res = new ArrayList<String>();
		char[] parenthese = new char[2 * n];
		_validParentheses(res, n, n, parenthese, 0);
		return res;
	}
	
	private static void _validParentheses(ArrayList<String> parentheseList, int leftCount, int rightCount, char[] parenthese, int count){
		// Illegal case
		if(leftCount < 0 || rightCount < 0){
			return;
		}
		// Base case: there are no left and right parentheses left.
		if(leftCount == 0 && rightCount == 0){
			parentheseList.add(String.valueOf(parenthese));
		}
		
		if(leftCount > 0){
			parenthese[count] = '(';
			_validParentheses(parentheseList, leftCount - 1, rightCount, parenthese, count + 1);
		}
		if(rightCount > leftCount){
			parenthese[count] = ')';
			_validParentheses(parentheseList, leftCount, rightCount - 1, parenthese, count + 1);
		}
	}
}
