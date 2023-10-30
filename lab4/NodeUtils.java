package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NodeUtils {
	public static List<String> printPath(Node node) {
		if (node != null) {
			List<String> result = new ArrayList<>();
			result.add(node.getLabel());
			Node tmp;
			while ((tmp = node.getParent()) != null) {
				result.add(tmp.getLabel());
				node = tmp;
			}
			Collections.reverse(result);
			return result;
		} else
			return new ArrayList<>(Arrays.asList("Khong ton tai duong di"));
	}
}