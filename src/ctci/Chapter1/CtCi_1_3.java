package ctci.Chapter1;
import java.util.Map;
import java.util.HashMap;

/**
 * Given two strings, write a method to decide 
 * if one is permutation of the other.
 * 
 * @author Long Yang
 *
 */
public class CtCi_1_3 {
	private static boolean isPermutation(String str1, String str2){
		if(str1 == null && str2 == null){
			return true;
		}
		if(str1 == null || str2 == null || str1.length() != str2.length()){
			return false;
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char ch : str1.toCharArray()){
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch) + 1);
			}else{
				map.put(ch, 1);
			}
		}
		for(char ch : str2.toCharArray()){
			if(map.containsKey(ch)){
				if(map.get(ch) > 0){
					map.put(ch, map.get(ch) - 1);
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(isPermutation("asdf","fdasa"));
		System.out.println(isPermutation("fdasfdsa","asdfasdf"));
	}
}
