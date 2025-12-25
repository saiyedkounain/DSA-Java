/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //hashmap to map the og node with the copy
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        //edge case
        if(node == null) return null;

        return clone(node);   
    }

    private Node clone(Node node){
        //if already in the map? then return the copy from the map itself
        if(map.containsKey(node)){
            return map.get(node);
        }

        //if not, make a copy and map it with the og ndoe
        Node copy = new Node(node.val);
        map.put(node, copy);

        // now add the og node's neighbors to our copy node recursively
        for(Node nei: node.neighbors){
            copy.neighbors.add(clone(nei));
        }

        return copy;
    }
}
