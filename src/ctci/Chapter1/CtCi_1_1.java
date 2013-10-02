package ctci.Chapter1;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structure.
 * 
 * @author Long Yang
 *
 */
public class CtCi_1_1 {
	// Running time: O(n), Space cost: O(n)
	private static boolean isUnique(String str){
		if(str == null || str.length() == 0){
			return true;
		}
		
		Set<Character> set = new HashSet<Character>();
		for(char ch : str.toCharArray()){
			if(set.contains(ch)){
				return false;
			}else{
				set.add(ch);
			}
		}
		return true;
	}
	
	/*
	 * Running time: O(n), Space cost: O(1)
	 * Limits: str only contains lower case characters
	 */
	private static boolean isUnique1(String str){
		if(str == null || str.length() == 0){
			return true;
		}
		
		int value = 0;
		for(char ch : str.toCharArray()){
			int tmp = ch - 'a';
			if((value & (1 << tmp)) == 1){
				return false;
			}else{
				value |= (1 << tmp);
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(isUnique("adsfadfg"));
		System.out.println(isUnique("asdf"));
		String str = null;
		System.out.println(isUnique(str));
		str = "";
		System.out.println(isUnique(str));
		
		// isUnique1 test
		System.out.println(isUnique1("adsfadfg"));
		System.out.println(isUnique1("asdf"));
		str = null;
		System.out.println(isUnique1(str));
		str = "";
		System.out.println(isUnique1(str));
	}
}
