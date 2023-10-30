package task4_5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import task1_2.Edge;
import task1_2.ISearchAlgo;
import task1_2.Node;

public class UniformCostSearchAlgo implements ISearchAlgo {

	PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComperator());
	Set<Node> explored = new HashSet<>();

	@Override
	public Node execute(Node root, String goal) {
		double pathCost = 0;
		root.setPathCost(pathCost);
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			System.out.print(currentNode + ":" + currentNode.getPathCost() + " ");
			if (currentNode.getLabel().equals(goal))
				return currentNode;
			explored.add(currentNode);
			List<Edge> edges = currentNode.getChildren();
			for (Edge e : edges) {
				Node nodeEnd = e.getEnd();
				if (!explored.contains(nodeEnd) && !frontier.contains(nodeEnd)) {
					nodeEnd.setPathCost(currentNode.getPathCost() + e.getWeight());
					nodeEnd.setParent(currentNode);
					frontier.add(nodeEnd);
				} else if (frontier.contains(nodeEnd)
						&& nodeEnd.getPathCost() > (currentNode.getPathCost() + e.getWeight())) {
					nodeEnd.setPathCost(currentNode.getPathCost() + e.getWeight());
					nodeEnd.setParent(currentNode);
				}
			}
			System.out.println(frontier.toString());
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		double pathCost = 0;
		root.setPathCost(pathCost);
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(start)) {
				currentNode.setPathCost(0.0);
				frontier.clear();
				currentNode.setParent(null);
			}
			System.out.print(currentNode + ":" + currentNode.getPathCost() + " ");
			if (currentNode.getLabel().equals(goal))
				return currentNode;
			explored.add(currentNode);
			List<Edge> edges = currentNode.getChildren();
			for (Edge e : edges) {
				Node nodeEnd = e.getEnd();
				if (!explored.contains(nodeEnd) && !frontier.contains(nodeEnd)) {
					nodeEnd.setPathCost(currentNode.getPathCost() + e.getWeight());
					nodeEnd.setParent(currentNode);
					frontier.add(nodeEnd);

				} else if (frontier.contains(nodeEnd)
						&& nodeEnd.getPathCost() > (currentNode.getPathCost() + e.getWeight())) {
					nodeEnd.setPathCost(currentNode.getPathCost() + e.getWeight());
					nodeEnd.setParent(currentNode);
				}
			}
			System.out.println(frontier.toString());
		}
		return null;
	}

//	public boolean compareNode(Node node) {
//		Iterator<Node> iteratorNode = frontier.iterator();
//		while (iteratorNode.hasNext()) {
//			Node e = iteratorNode.next();
//			if (e.getLabel().equals(node.getLabel()))
//				return node.getPathCost() < e.getPathCost();
//		}
//		return false;
//	}

}
