package task1_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgoGraphSearch implements ISearchAlgo {

	Stack<Node> frontier = new Stack<>();
	List<Node> explored = new ArrayList<>();

	@Override
	public Node execute(Node root, String goal) {
		if (root.getLabel().equals(goal))
			return root;
		frontier.push(root);
		explored.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.pop();
			System.out.print(currentNode + " ");
			List<Node> nodes = currentNode.getChildrenNodes();
			for (Node e : nodes) {
				if (!explored.contains(e) && !frontier.contains(e)) {
					explored.add(e);
					frontier.push(e);
					e.setParent(currentNode);
				}
				if (e.getLabel().equals(goal))
					return e;
			}
			System.out.println(frontier.toString());
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		if (root.getLabel().equals(start) && root.getLabel().equals(goal)) {
			return root;
		}
		frontier.push(root);
		explored.add(root);
		while (!frontier.isEmpty()) {
			Node currrentNode = frontier.pop();
			System.out.print(currrentNode + " ");
			List<Node> nodes = currrentNode.getChildrenNodes();
			for (Node e : nodes) {
				if (e.getLabel().equals(start)) {
					frontier.clear();
					e.setParent(null);
					frontier.push(e);
					explored.add(e);
				}
				if (!explored.contains(e) && !frontier.contains(e)) {
					explored.add(e);
					frontier.push(e);
					e.setParent(currrentNode);
				}
				if (e.getLabel().equals(goal))
					return e;
			}
			System.out.println(frontier.toString());
		}
		return null;
	}

}
