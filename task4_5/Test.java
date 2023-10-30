package task4_5;

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
		Node nodeP = new Node("P");
		Node nodeQ = new Node("Q");
		Node nodeR = new Node("R");
		nodeS.addEdge(nodeD, 3.0);
		nodeS.addEdge(nodeE, 9.0);
		nodeS.addEdge(nodeP, 1.0);
		nodeB.addEdge(nodeA, 2.0);
		nodeC.addEdge(nodeA, 2.0);
		nodeD.addEdge(nodeB, 1.0);
		nodeD.addEdge(nodeC, 8.0);
		nodeD.addEdge(nodeE, 2.0);
		nodeE.addEdge(nodeH, 1.0);
		nodeE.addEdge(nodeR, 9.0);
		nodeF.addEdge(nodeC, 5.0);
		nodeF.addEdge(nodeG, 5.0);
		nodeH.addEdge(nodeP, 4.0);
		nodeH.addEdge(nodeQ, 4.0);
		nodeP.addEdge(nodeQ, 15.0);
		nodeQ.addEdge(nodeR, 3.0);
		nodeR.addEdge(nodeF, 5.0);
		ISearchAlgo algo = new UniformCostSearchAlgo();
		Long st = System.currentTimeMillis();
		Node result = algo.execute(nodeS, "S", "G");
		Long et = System.currentTimeMillis();
		System.out.println("Run in: " + (int) (et - st) + " miliseconds");
		System.out.println(NodeUtils.printPath(result));
	}
}
