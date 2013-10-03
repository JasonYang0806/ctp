package ctci.Chapter1;

/**
 * Implement a function void reverse(String str) which reverse a string.
 * 
 * @author Long Yang
 *
 */
public class CtCi_1_2 {
	private static String reverse(String str){
		if(str == null || str.length() == 0){
			return str;
		}
		
		char[] charArray = str.toCharArray();
		int head = 0, tail = str.length() - 1;
		while(head < tail){
			swap(charArray, head++, tail--);
		}
		return String.valueOf(charArray);
	}
	
	private static void swap(char[] charArray, int a, int b){
		char tmp = charArray[a];
		charArray[a] = charArray[b];
		charArray[b] = tmp;
	}
	
	public static void main(String[] args){
		System.out.println(reverse("abcd"));
		System.out.println(reverse("abcde"));
	}
}
