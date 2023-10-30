package lab4;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S", 6);
		Node nodeA = new Node("A", 4);
		Node nodeB = new Node("B", 4);
		Node nodeC = new Node("C", 4);
		Node nodeD = new Node("D", 3.5);
		Node nodeE = new Node("E", 1);
		Node nodeF = new Node("F", 1);
		Node nodeG = new Node("G", 0);
		nodeS.addEdge(nodeA, 2);
		nodeS.addEdge(nodeB, 3);
		nodeA.addEdge(nodeC, 3);
		nodeB.addEdge(nodeC, 1);
		nodeB.addEdge(nodeD, 3);
		nodeC.addEdge(nodeE, 3);
		nodeC.addEdge(nodeD, 1);
		nodeD.addEdge(nodeF, 2);
		nodeE.addEdge(nodeG, 2);
		nodeF.addEdge(nodeG, 1);
//		IInformedSearchAlgo iInformedSearchAlgo = new GreedyBestFirstSearchAlgo();
//		IInformedSearchAlgo iInformedSearchAlgo = new AStarSearchAlgo();
		Task3 task3 = new Task3();
//		Node result = iInformedSearchAlgo.execute(nodeS, "G");
//		Node result = iInformedSearchAlgo.execute(nodeS, "E", "G");
//		Node result = iInformedSearchAlgo.execute(nodeS, "G");
//		Node result = iInformedSearchAlgo.execute(nodeS, "B", "G");
//		System.out.println(NodeUtils.printPath(result));
		System.out.println(task3.isAdmissibleH(nodeS, "G"));
	}
}