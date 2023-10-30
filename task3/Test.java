package task3;

import task1_2.ISearchAlgo;
import task1_2.Node;
import task1_2.NodeUtils;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
//		nodeS.addEdge(nodeC, 4);
//		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		ISearchAlgo algo = new DepthFirstSearchTreeSearch();
		Long st = System.currentTimeMillis();
		Node result = algo.execute(nodeS, "C", "G");
		Long et = System.currentTimeMillis();
		System.out.println("Run in: " + (int) (et - st));
		System.out.println(NodeUtils.printPath(result));
	}
}
