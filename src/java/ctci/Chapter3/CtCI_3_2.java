import java.util.Stack;

public class minStack
{
	private Stack<int> stack = new Stack<int>();
	private Stack<int> minStack = new Stack<int>();

	public void push(int val)
	{
		if(val <= minimun)
		{
			minStack.push(val);
		}
		stack.push(val);
	}

	public int pop()
	{
		if(stack.peek() == minStack.peek())
		{
			minStack.pop();
		}
		return stack.pop();
	}

	public int min()
	{
		if(stack.isEmpty())
		{
			return Integer.MAXVALUE;
		}
		else
		{
			return minStack.peek();
		}
	}
}