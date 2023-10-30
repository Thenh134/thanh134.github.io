package task1_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgoGraphSearch implements ISearchAlgo {

	Queue<Node> frontier = new LinkedList<>();
	List<Node> explored = new ArrayList<>();

	@Override
	public Node execute(Node root, String goal) {
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			System.out.print(currentNode.toString() + " ");
			if (currentNode.getLabel().equals(goal)) {
				return currentNode;
			}
			List<Node> nodes = currentNode.getChildrenNodes();
			explored.add(currentNode);
			for (Node e : nodes) {
				if (!explored.contains(e) && !frontier.contains(e)) {
					frontier.add(e);
					e.setParent(currentNode);
				}
			}
			System.out.println(frontier.toString());
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		frontier.add(root);
		boolean starter = false;
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			System.out.print(currentNode.toString());
			if (currentNode.getLabel().equals(goal)) {
				return currentNode;
			}
			if (currentNode.getLabel().equals(start)) {
				starter = true;
				currentNode.setParent(null);
			}
			List<Node> nodes = currentNode.getChildrenNodes();
			explored.add(currentNode);
			for (Node e : nodes) {
				if (!explored.contains(e) && !frontier.contains(e)) {
					if (starter) {
						frontier.clear();
						starter = false;
					}
					frontier.add(e);
					e.setParent(currentNode);
				}
			}
			System.out.print(frontier.toString());
			System.out.println();
		}
		return null;
	}

}
