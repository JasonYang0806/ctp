package commonStructure;

import java.util.ArrayList;

public class GraphAjacentTable<E>
{
	// Fields:
	private ArrayList<Node<E>> nodeList;

	// Constructor:
	public GraphAjacentTable()
	{
		nodeList = new ArrayList<Node<E>>();
	}

	// Methods
	public ArrayList<Node<E>> getNodeList()
	{
		return nodeList;
	}
}