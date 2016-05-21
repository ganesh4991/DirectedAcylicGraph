package DAG;
import java.util.ArrayList;
import java.util.List;

// Node class to store the contents of each point in the graph
public class Node {
	String name;
	List<Node>out; // List of outward edges
	List<Node>in;	//list of inward edges
	Node(String n){
		name=n;
		out=new ArrayList<Node>();
		in=new ArrayList<Node>();
	}
	public void inLink(Node i){
		in.add(i);
	}
	public void outLink(Node i){
		out.add(i);
	}
}
