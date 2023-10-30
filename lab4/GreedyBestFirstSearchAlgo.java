package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	private static PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComperatorByH());
	static private List<Node> explored = new ArrayList<>();

	@Override
	public Node execute(Node root, String goal) {
		if (root.getLabel().equals(goal))
			return root;
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal))
				return currentNode;
			System.out.print(currentNode);
			explored.add(currentNode);
			List<Node> nodes = currentNode.getChildrenNodes();
			for (Node n : nodes) {
				if (!frontier.contains(n) && !explored.contains(n)) {
					frontier.add(n);
					n.setParent(currentNode);
				}
			}
			System.out.println(frontier.toString());
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		if (root.getLabel().equals(goal) && root.getLabel().equals(goal))
			return root;
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal) && explored.contains(new Node(start)))
				return currentNode;
			if (currentNode.getLabel().equals(start)) {
				frontier.clear();
				currentNode.setParent(null);
			}
			System.out.print(currentNode);
			explored.add(currentNode);
			List<Node> nodes = currentNode.getChildrenNodes();
			for (Node n : nodes) {
				if (!frontier.contains(n)) {
					frontier.add(n);
					n.setParent(currentNode);
				}
			}
			System.out.println(frontier.toString());
		}
		return null;
	}

}