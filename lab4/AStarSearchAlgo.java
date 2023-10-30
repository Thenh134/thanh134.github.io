package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.plaf.basic.BasicMenuUI;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComperatorByG());
	List<Node> explored = new ArrayList<>();

	@Override
	public Node execute(Node root, String goal) {
		root.setG(0 + root.getH());
		if (root.getLabel().equals(goal))
			return root;
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal))
				return currentNode;
			System.out.print(currentNode);
			explored.add(currentNode);
			List<Edge> edges = currentNode.getChildren();
			for (Edge e : edges) {
				Node node = e.getEnd();
				if (!frontier.contains(node) && !explored.contains(node)) {
					node.setG((currentNode.getG() - currentNode.getH()) + e.getWeight() + node.getH());
					node.setParent(currentNode);
					frontier.add(node);
				} else if (node.getG() > ((currentNode.getG() - currentNode.getH()) + e.getWeight() + node.getH())) {
					node.setG(((currentNode.getG() - currentNode.getH()) + e.getWeight() + node.getH()));
					node.setParent(currentNode);
				}
			}
			System.out.println(frontier.toString());
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		root.setG(0 + root.getH());
		if (root.getLabel().equals(goal) && root.getLabel().equals(start))
			return root;
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal) && explored.contains(new Node(start))) {
				return currentNode;}
			else if (currentNode.getLabel().equals(start)) {
				currentNode.setParent(null);
				currentNode.setG(currentNode.getH());
				frontier.clear();
			}
			System.out.print(currentNode);
			explored.add(currentNode);
			List<Edge> edges = currentNode.getChildren();
			for (Edge e : edges) {
				Node node = e.getEnd();
				if (!frontier.contains(node) && !explored.contains(node)) {
					node.setG((currentNode.getG() - currentNode.getH()) + e.getWeight() + node.getH());
					node.setParent(currentNode);
					frontier.add(node);
				} else if (node.getG() > ((currentNode.getG() - currentNode.getH()) + e.getWeight() + node.getH())) {
					node.setG(((currentNode.getG() - currentNode.getH()) + e.getWeight() + node.getH()));
					node.setParent(currentNode);
				}
			}
			System.out.println(frontier.toString());
		}
		return null;
	}

}