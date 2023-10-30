package lab4;

import java.util.Comparator;

public class NodeComperatorByG implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		Double g1 = o1.getG();
		Double g2 = o2.getG();
		return g1.compareTo(g2);
	}

}