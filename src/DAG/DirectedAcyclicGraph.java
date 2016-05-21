package DAG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedAcyclicGraph {
	Map<String, Node> listOfNodes;
	Node s, d, head;

	public DirectedAcyclicGraph() {
		// TODO Auto-generated constructor stub
		listOfNodes = new HashMap<String, Node>();
	}

	public boolean addEdge(String source, String destination) {

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

		if (!checkCycle(s, d))
			return false;
		
		return true;
	}

	public boolean checkCycle(Node source, Node dest) {

		source.out.add(d);
		dest.in.add(s);
			
		for (Map.Entry<String, Node> entry : listOfNodes.entrySet()) {
			if (entry.getValue().in.size() == 0) {
				head = entry.getValue();
				break;
			}
		}

		List<Node> nodesVisited = new ArrayList<Node>();

		nodesVisited.add(head);

		if (depthFirstSearch(head, nodesVisited))
			return true;
		else {
			s.out.remove(d);
			d.in.remove(s);
			return false;
		}
	}

	public boolean depthFirstSearch(Node a, List<Node> nodesVistied) {
		if (a.out.size() == 0)
			return true;
		else {
			for (Node i : a.out) {
				//System.out.println("Parent "+a.name+" Child "+i.name);
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
