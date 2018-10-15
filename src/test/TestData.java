package test;

import nodes.GNode;
import nodes.Node;

public class TestData {
	public static Node test_graph = 
		new Node("A", new GNode[] {
    		new Node("B", new GNode[] {
                new Node("E"),
                new Node("F")
    		}),
    		new Node("C", new GNode[] {
                new Node("G"),
                new Node("H"),
                new Node("I")
            }),
    		new Node("D", new GNode[] {
                new Node("J")
    		})
    	});
}
