package test;

import java.util.stream.Collectors;

import nodes.GNode;
import nodes.Node;

public class Test1 {
    public static void main(String[] args) {
    	Node test_node = TestData.test_graph;
        System.out.println("Test 1");
        System.out.print("Graph: ");
        Node.prettyPrintGraph(test_node);
        StringBuilder sb = new StringBuilder();
        
        sb.append("walkGraph(A) = (");
        sb.append(test_node.walkGraph(test_node).stream()
        	.map(GNode::getName)
        	.collect(Collectors.joining(", ")));
        sb.append(")");
        
        System.out.println(sb.toString());
    }
}
