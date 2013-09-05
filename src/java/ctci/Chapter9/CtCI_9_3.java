package CTCI_Chapter_9;

/**
 * 
 * @author longyang
 * Subject: A magic index in an array A[1...n-1] is defined to be an index such that A[i] = i.
 * 			Given a sorted array of distinct integers, write a method to find a magic index, if
 * 			one exists, in array A.
 * 			FOLLOW UP
 * 			What if the values are not distinct.
 */
import java.util.ArrayList;
public class ctci_9_3 {
	public static void main(String[] args){
//		int[] A = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
//		System.out.println(magicIndex(A));
		
		int[] A = {-10,-5,2,2,2,3,4,7,9,12,13,13,13,13,13,13,13};
		ArrayList<Integer> res = magicIndexFollowUp(A);
		for(int magicIndex : res){
			System.out.println(magicIndex);
		}
	}
	
	/**
	 * Find magic index in a sorted array A with all distinct integers.
	 */
	public static int magicIndex(int[] A){
		return _magicIndex(A, 0, A.length - 1);
	}

	public static int _magicIndex(int[] A, int start, int end){
		if(start < 0 || end > A.length - 1 || start > end){
			return -1;
		}else{
			int mid = (start + end) / 2;
			if(A[mid] == mid){
				return mid;
			}else if(A[mid] > mid){
				return _magicIndex(A, start, mid - 1);
			}else{
				return _magicIndex(A, mid + 1, end);
			}
		}
	}
	
	/**
	 * FOLLOW UP
	 * Find magic index in a sorted array A where exists duplicated integers
	 */
	public static ArrayList<Integer> magicIndexFollowUp(int[] A){
		ArrayList<Integer> res = new ArrayList<Integer>();
		_magicIndexFollowUp(A, 0, A.length - 1, res);
		return res;
	}
	
	public static void _magicIndexFollowUp(int[] A, int start, int end, ArrayList<Integer> magicIndexList){
		if(start < 0 || end > A.length - 1 || start > end){
			return;
		}
		
		int mid = (start + end) / 2;
		if(A[mid] == mid){
			magicIndexList.add(mid);
		}else{
			int left_end = Math.min(A[mid], mid - 1);
			int right_start = Math.max(A[mid], mid + 1);
			_magicIndexFollowUp(A, start, left_end, magicIndexList);
			_magicIndexFollowUp(A, right_start, end, magicIndexList);
		}
	}	
	
}
