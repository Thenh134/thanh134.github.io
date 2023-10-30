package lab4;

public class Task3 {

	IInformedSearchAlgo gbfs = new GreedyBestFirstSearchAlgo();
	IInformedSearchAlgo ass = new AStarSearchAlgo();

	public boolean isAdmissibleH(Node root, String goal) {
		double h = gbfs.execute(root, goal).getH();
		double hStar = ass.execute(root, goal).getG();

		System.out.print("H:" + h + "--------" + "H*:" + hStar);

		return h <= hStar && h >= 0;
	}
}