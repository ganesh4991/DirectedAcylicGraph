package DAG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedAcyclicGraph {
	Map<String, Node> listOfNodes; // Store all the nodes in the graph
	Node s, d, head;	// Pointers for source, destination and head. Head is the first point in the map with 0 inward edges

	public DirectedAcyclicGraph() {
		// TODO Auto-generated constructor stub
		listOfNodes = new HashMap<String, Node>();
	}

	public boolean addEdge(String source, String destination) {
		
		//creating new nodes for source and destination if they don't exist
		if (listOfNodes.containsKey(source)) {
			s = listOfNodes.get(source);
		} else {
			s = new Node(source);
			listOfNodes.put(source, s);
		}

		if (listOfNodes.containsKey(destination)) {
			d = listOfNodes.get(destination);
		} else {
			d = new Node(destination);
			listOfNodes.put(destination, d);
		}

		// Checking for cycle in the graph based on this edge
		if (!checkCycle(s, d))
			return false;
		
		return true;
	}

	public boolean checkCycle(Node source, Node dest) {
		
		// Add edge to the graph
		source.out.add(d);
		dest.in.add(s);
		
		// Find the head
		for (Map.Entry<String, Node> entry : listOfNodes.entrySet()) {
			if (entry.getValue().in.size() == 0) {
				head = entry.getValue();
				break;
			}
		}

		// To check for cycle keep track of all the nodes visited in depth first search traversal
		List<Node> nodesVisited = new ArrayList<Node>();

		nodesVisited.add(head);

		//recursive call to find cycles. In case DFS returns true the edge mainains the constraints of DFS and need not be removed.
		if (depthFirstSearch(head, nodesVisited))
			return true;
		else {
			
			// remove the edge since it leads to a cycle.
			s.out.remove(d);
			d.in.remove(s);
			return false;
		}
	}

	// Recursive function for DFS traversal. Visit all the out edges of each node. If a single node is already present the false propagates all the way to the first call.
	public boolean depthFirstSearch(Node a, List<Node> nodesVistied) {
		if (a.out.size() == 0)
			return true;
		else {
			for (Node i : a.out) {
				if (nodesVistied.contains(i))
					return false;
				nodesVistied.add(i);
				if (depthFirstSearch(i, nodesVistied))
					nodesVistied.remove(i);
				else
					return false;
			}
		}
		return true;
	}
}
