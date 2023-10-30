package lab4;

import java.util.ArrayList;
import java.util.List;


public class Node {
	private String label;
	private Node parent; // for printing the path from the start node to goal node
	private double g;// cost from the Start node to this node
	private double h;// heuristic cost from this node to the Goal node
	private List<Edge> children = new ArrayList<Edge>();

	public Node(String label) {
		this.label = label;
	}
	
	public Node(String label,double h) {
		this.label = label;
		this.h = h;
	}
	
	

	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public Node getParent() {
		return parent;
	}



	public void setParent(Node parent) {
		this.parent = parent;
	}



	public double getG() {
		return g;
	}



	public void setG(double g) {
		this.g = g;
	}



	public double getH() {
		return h;
	}



	public void setH(double h) {
		this.h = h;
	}



	public List<Edge> getChildren() {
		return children;
	}



	public void setChildren(List<Edge> children) {
		this.children = children;
	}
	
	public List<Node> getChildrenNodes() {
		List<Node> result = new ArrayList<Node>();
		for (Edge edge : this.children) {
			result.add(edge.getEnd());
		}
		return result;
	}

	// an edge is generated using this node and "that" with the given cost
	public void addEdge(Node that, double cost) {
		Edge edge = new Edge(this, that, cost);
		this.children.add(edge);
	}

	// an edge is generated using this node and "that" with the given cost
	public void addEdge(Node that) {
		Edge edge = new Edge(this, that);
		this.children.add(edge);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.label + ":" + this.g;
	}

//	@Override
//	public int compareTo(Node o) {
//		return this.label.compareTo(o.label);
//	}
}