/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(node == null){
            return null;
        }
        
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        UndirectedGraphNode head = null;
        while(!queue.isEmpty()){
            UndirectedGraphNode tmpNode = queue.remove();
            if(!visited.contains(tmpNode)){
                visited.add(tmpNode);
                if(head == null){
                    head = new UndirectedGraphNode(tmpNode.label);
                    map.put(tmpNode, head);
                }
                UndirectedGraphNode copiedNode = map.get(tmpNode);
                for(UndirectedGraphNode n : tmpNode.neighbors){
                    UndirectedGraphNode copiedNeighborsNode;
                    if(map.containsKey(n)){
                        copiedNeighborsNode = map.get(n);
                    }else{
                        copiedNeighborsNode = new UndirectedGraphNode(n.label);
                        map.put(n, copiedNeighborsNode);
                    }
                    copiedNode.neighbors.add(copiedNeighborsNode);
                    queue.offer(n);
                }
            }
        }
        return head;
    }
}