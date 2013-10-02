package commonStructure;

import java.util.LinkedList;

public class Node<E>
{
	// Fields
	private E val;
	private LinkedList<Node<E>> adjacnetList;

	// Constructor
	public Node(E val)
	{
		this.val = val;
		adjacnetList = new LinkedList<Node<E>>();
	}

	public Node(Node<E> node)
	{
		this.val = node.getValue();
		this.adjacnetList = node.getAdjacentList();
	}

	// Method
	public void addAdjacentNode(Node<E> node)
	{
		adjacentList.add(node);
	}

	public E getValue()
	{
		return val;
	}

	public LinkedList<Node<E>> getAdjacentList()
	{
		return adjcentList;
	}
}