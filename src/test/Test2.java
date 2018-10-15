package test;
import java.util.stream.Collectors;

import nodes.GNode;
import nodes.Node;

public class Test2 {
	public static void main(String[] args) {
		Node test_node = TestData.test_graph;
        System.out.println("Test 2");
        System.out.print("Graph: ");
        Node.prettyPrintGraph(test_node);
        StringBuilder sb = new StringBuilder();

        sb.append("paths(A) = ( ");
        test_node.paths(test_node).stream()
        	.forEach((s) -> {
        		sb.append("(");
        		sb.append(s.stream()
        			.map(GNode::getName)
        			.collect(Collectors.joining(", ")));
        		sb.append(") ");
        	});
        sb.append(" )");
        
        System.out.println(sb.toString());
	}
}
