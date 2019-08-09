package date0808;
import javaUtil.Node;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {

        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        System.out.println(cloneGraph(node1));
    }

    public static Node cloneGraph(Node node) {
        // map<old, new>
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> nodesToCopy = new LinkedList<>();
        Node newRoot = new Node(node.val, new ArrayList<>());
        map.put(node, newRoot);
        nodesToCopy.offer(node);
        while (!nodesToCopy.isEmpty()) {
                Node curNode = nodesToCopy.poll();
                Node curClone = map.get(curNode);
                for (Node neighbor : curNode.neighbors) {
                    Node neighborClone = map.get(neighbor);
                    if (neighborClone == null) {
                        neighborClone = new Node(neighbor.val, new ArrayList<>());
                        map.put(neighbor, neighborClone);
                        nodesToCopy.offer(neighbor);
                    }
                    curClone.neighbors.add(neighborClone);
                }
        }
        return newRoot;
    }
}
