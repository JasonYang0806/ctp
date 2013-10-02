package ctci.Chapter3;

import java.util.Stack;

/**
 * How wound you design a stack which, in addition to push and pop, 
 * also has a function 'min' which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 * 
 * @author Long Yang
 * 
 */
public class CtCi_3_2 {
	public static void main(String[] args){
		MinStack minStack = new MinStack();
		int[] test = {-1, 3,34,123,-12,432,45,12,-123,342,-1232};
		for(int elem : test){
			System.out.println("**********" + elem + "**********");
			minStack.push(elem);
			if(!minStack.stack.isEmpty() && (Math.random() * 10 < 5)){
				System.out.println(minStack.pop());
			}
			System.out.println("min: " + minStack.min());
		}
	}
	
	private static class MinStack{
		Stack<Integer> stack;
		Stack<Integer> min;
		
		public MinStack(){
			stack = new Stack<Integer>();
			min = new Stack<Integer>();
		}
		
		public void push(int element){
			stack.push(element);
			if(min.isEmpty() || element < min.peek()){
				min.push(element);
			}
		}
		
		public int pop(){
			if(stack.peek() == min.peek()){
				min.pop();
			}
			return stack.pop();
		}
		
		public int min(){
			if(min.isEmpty()){
				return Integer.MAX_VALUE;
			}
			return min.peek();
		}
	}
}
