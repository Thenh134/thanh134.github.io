package lab4;

import java.util.Comparator;

public class NodeComperatorByH implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		Double h1 = o1.getH();
		Double h2 = o2.getH();
		if (h1.compareTo(h2) == 0) {
			return o1.getLabel().compareTo(o2.getLabel());
		}
		return h1.compareTo(h2);
	}

}