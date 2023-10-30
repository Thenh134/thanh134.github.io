package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import task1_2.ISearchAlgo;
import task1_2.Node;

public class DepthFirstSearchTreeSearch implements ISearchAlgo {

	Stack<Node> frontier = new Stack<>();
	List<Node> explored = new ArrayList<>();

	@Override
	public Node execute(Node root, String goal) {
		if (root.getLabel().equals(goal)) {
			return root;
		}
		frontier.push(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.pop();
			System.out.print(currentNode + " ");
			if (currentNode.getLabel().equals(goal)) {
				System.out.println();
				return currentNode;
			}
			List<Node> nodes = currentNode.getChildrenNodes();
			for (Node e : nodes) {
				frontier.push(e);
				e.setParent(currentNode);
			}
			System.out.println(frontier.toString());
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node nodeStart = new Node(start);
		if (root.getLabel().equals(goal) && root.getLabel().equals(start))
			return root;
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.pop();
			explored.add(currentNode);
			System.out.print(currentNode + " ");
			if (explored.contains(nodeStart) && currentNode.getLabel().equals(goal))
				return currentNode;
			if (currentNode.getLabel().equals(start)) {
				frontier.clear();
				currentNode.setParent(null);
			}
			List<Node> nodes = currentNode.getChildrenNodes();
			for (Node e : nodes) {
				frontier.push(e);
				e.setParent(currentNode);
			}
			System.out.println(frontier.toString());
		}
		return null;
	}

}
