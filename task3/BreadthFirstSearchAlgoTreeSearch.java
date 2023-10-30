package task3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import task1_2.ISearchAlgo;
import task1_2.Node;

public class BreadthFirstSearchAlgoTreeSearch implements ISearchAlgo {

	Queue<Node> frontier = new LinkedList<>();

	@Override
	public Node execute(Node root, String goal) {
		if (root.getLabel().equals(goal))
			return root;
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal))
				return currentNode;
			List<Node> nodes = currentNode.getChildrenNodes();
			for (Node e : nodes) {
				frontier.add(e);
				e.setParent(currentNode);
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		if (root.getLabel().equals(goal) && root.getLabel().equals(start))
			return root;
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal))
				return currentNode;

			List<Node> nodes = currentNode.getChildrenNodes();
			for (Node e : nodes) {
				if (e.getLabel().equals(start)) {
					frontier.clear();
					e.setParent(null);
				} else {
					e.setParent(currentNode);
				}
				frontier.add(e);

			}
		}
		return null;
	}

}
