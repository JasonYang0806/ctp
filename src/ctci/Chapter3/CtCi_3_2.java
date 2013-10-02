package java.ctci.Chapter3;

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
		System.out.println("Hello World");
//		MinStack minStack = new MinStack();
//		int[] test = {-1, 3,34,123,-12,432,45,12,-123,342,-1232};
//		for(int elem : test){
//			System.out.println("**********" + elem + "**********");
//			minStack.push(elem);
//			if(Math.random() % 10 > 5){
//				System.out.println("pop: " + minStack.pop());
//			}
//			System.out.println("min: " + minStack.min());
//		}
	}
	
	public static class MinStack{
		Stack<Integer> stack;
		Stack<Integer> min;
		
		public MinStack(){
			stack = new Stack<Integer>();
			min = new Stack<Integer>();
		}
		
		public void push(int element){
			stack.push(element);
			if(element < min.pop()){
				min.push(element);
			}
		}
		
		public int pop(){
			if(stack.pop() == min.pop()){
				min.pop();
			}
			return stack.pop();
		}
		
		public int min(){
			return min.pop();
		}
	}
}
