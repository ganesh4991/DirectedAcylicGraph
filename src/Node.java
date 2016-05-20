import java.util.ArrayList;
import java.util.List;

public class Node {
	String name;
	List<Node>out; 
	List<Node>in;
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
