package nodes;

import java.util.ArrayList;

public class Node implements GNode {
    private String name;
    private GNode[] children;

    /**
     * Constructor for the Node class.
     * @param name A String specifying the name of the new Node.
     * @param children An array of child Nodes of the new Node.
     */
    public Node(String name) {
        this.name = name;
        this.children = new GNode[0];
    }    
    
    /**
     * Constructor for the Node class.
     * @param name A String specifying the name of the new Node.
     * @param children An array of child Nodes of the new Node.
     */
    public Node(String name, GNode[] children) {
        this.name = name;
        this.children = children;
    }

    /**
     * Get the name of this Node.
     * @return The name of this Node.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the children of this Node.
     * @return The array of children belonging to this Node.
     */
    public GNode[] getChildren() {
        return this.children;
    }

    /**
     * Prints a string representation of this graph to stdout.
     * @param node Start node of the graph to be printed.
     */
    public static void prettyPrintGraph(GNode node) {
    	StringBuilder sb = new StringBuilder();
    	
    	Node.doPrintGraph(node, sb, 0, false);
    	
    	System.out.println(sb.toString());
    }
    
    /**
     * Recursive function used to build up the graph representation.
     * @param node Current node.
     * @param sb StringBuilder used to build up the graph representation.
     */
    public static void doPrintGraph(GNode node, StringBuilder sb, int depth,
    		boolean last)
    {
    	sb.append("\n");
    	
    	if (depth > 0) {
    		for (int i=1; i<depth; i++) {
        		sb.append("│ ");	
    		}

    		if (!last) {
    			sb.append("├─");	
    		} else {
    			sb.append("└─");
    		}
    	}

    	sb.append(node.getName());
    	
    	GNode[] children = node.getChildren();
    	
    	for (int i=0; i<children.length; i++) {
    		if (i == children.length-1) {
    			Node.doPrintGraph(children[i], sb, depth+1, true);
    		} else {
    			Node.doPrintGraph(children[i], sb, depth+1, false);
    		}
    	}
    }
    
    /**
     * Walk the entire graph starting at the passed in node, returning all
     * nodes found.
     * @param node Initial node.
     * @return All nodes in the graph.
     */
    public ArrayList<GNode> walkGraph(GNode node) {
        ArrayList<GNode> all_nodes = new ArrayList<GNode>();

        Node.doWalkGraph(node, all_nodes);

        return all_nodes;
    }

    /**
     * Recursive function used to walk the graph.
     * @param node The current node.
     * @param nodes ArrayList reference that all nodes will be added to.
     */
    public static void doWalkGraph(GNode node, ArrayList<GNode> nodes) {
    	// New node, add it to the list.
        nodes.add(node);
       
        // Run the recursive helper function for each child of this node.
        for (GNode child : node.getChildren()) {
            Node.doWalkGraph(child, nodes);
        }
    }
    
    /**
     * Returns an ArrayList containing an ArrayList<GNode> for each
     * path through the graph starting at the passed in node.
     * @param node
     * @return ArrayList<ArrayList<GNode>>
     */
    public ArrayList<ArrayList<GNode>> paths(GNode node) {
    	ArrayList<ArrayList<GNode>> all_paths =
    			new ArrayList<ArrayList<GNode>>();
    	ArrayList<GNode> stack = new ArrayList<GNode>();
    	
    	Node.doPaths(node, all_paths, stack);
    	
    	return all_paths;
    }
    
    /**
     * Recursive function used to walk the graph and build out the paths.
     * @param node Current node in the graph.
     * @param paths List of paths built during traversal of the graph.
     * @param stack Current path being traversed.
     */
    public static void doPaths(GNode node, ArrayList<ArrayList<GNode>> paths,
    		ArrayList<GNode> stack) {
    	// Found a new node, add it to the stack.
    	stack.add(node);

    	GNode[] children = node.getChildren();
    	
    	if (children.length > 0) {
    		// Loop through the children, running the recursive doPaths on each.
        	for (GNode child : children) {
            	Node.doPaths(child, paths, stack);
        	}
    	} else {
    		// We've reached the end of a path.
    		// Shallow copy the current stack into paths.
    		paths.add(new ArrayList<GNode>(stack));
    	}

    	// We have completed traversal of this node and its children, remove it
    	// from the stack.
    	stack.remove(stack.size()-1);
    }
}
