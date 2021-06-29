import java.util.*;

class TestTree extends BinaryTree implements TreeInterface {
    static List<Node> nodeChildren;
    static List<Node> ancestors;
    
    @Override
    public void traverseTree (Node node) {
        if (!isInTree(node)) {
            // node not in tree.
            return;
        }
        // Uncomment any one to choose traverse method.
        
        // Preorder Traverse: root, left, right sequence
        System.out.println(node);
        traverseTree(node.lChild);
        traverseTree(node.rChild);
        
        // // Inorder Traverse: left, root, right sequence
        // traverseTree(node.lChild);
        // System.out.println(node);
        // traverseTree(node.rChild);
        
        // Postorder Traverse: left, right, root sequence
        // traverseTree(node.lChild);
        // traverseTree(node.rChild);
        // System.out.println(node);
    }
    
    @Override
    public List<Node> getChildren(Node node) {
        nodeChildren = new ArrayList<Node>();
        if (!isInTree(node)) {
            // node not in tree.
            System.out.println("node not in tree i.e. no children");
            return nodeChildren;
        }
        addToNodeChildren(node);
        return nodeChildren;
    }
    
    public static void addToNodeChildren (Node node) {
        if (node.lChild != null) {
            nodeChildren.add(node.lChild);
            addToNodeChildren(node.lChild);
        }
        if (node.rChild != null) {
            nodeChildren.add(node.rChild);
            addToNodeChildren(node.rChild);
        }
    }
    
    @Override
    public List<Node> getChildrenWithStrVal(Node node) {
        List<Node> allChildren = getChildren(node);
        List<Node> allChildrenWithStrVal = new ArrayList<Node>();
        for (Node n: allChildren) {
            if (n.value instanceof String) {
                allChildrenWithStrVal.add(n);
            }
        }
        return allChildrenWithStrVal;
    }
    
    @Override
    public Node getParent(Node node) {
        if (!isInTree(node)) {
            // node not in tree i.e. no parent.
            System.out.println("node not in tree i.e. no parent");
            return null;
        }
        
        if (node == this.root) {
            // root node has no parent.
            return null;
        }
        
        int key = node.key;
        Node focusNode = this.root;
        Node parent = null;
        
        while (focusNode != node) {
            parent = focusNode;
            if (key < focusNode.key) {
                // go to left node.
                focusNode = focusNode.lChild;
            } else {
                // go to right node.
                focusNode = focusNode.rChild;
            }
        }
        return parent;
    }
    
    @Override
    public List<Node> getAncestors(Node node) {
        ancestors = new ArrayList<Node>();
        if (!isInTree(node)) {
            // node not in tree.
            System.out.println("node not in tree i.e. no ancestors");
            return ancestors;
        }
        addToAncestors(node);
        return ancestors;
    }
    
    public void addToAncestors (Node node) {
        Node parent = getParent(node);
        if (parent != null) {
            ancestors.add(parent);
            addToAncestors(parent);
        }
    }
    
    @Override
    public String getConcatAncestors(Node node) {
        List<Node> allAncestors = getAncestors(node);
        String ancestorsStr = "Concatenate ancestors:";
        for (Node n: allAncestors) {
            ancestorsStr = ancestorsStr + "\n" + n;
        }
        return ancestorsStr;
    }
    
    @Override
    public boolean isInTree(Node node) {
        if (node == null) {
            // node is not in tree.
            return false;
        }
        
        Node focusNode = this.root;
        boolean inTree = true;
        while (focusNode != node) {
            if (node.key < focusNode.key) {
                // go to left
                focusNode = focusNode.lChild;
            } else {
                // go to right
                focusNode = focusNode.rChild;
            }
            
            if (focusNode == null) {
                // tree traversed. node not in tree.
                inTree = false;
            }
        }
        return inTree;
    }
}

public class Main {
  public static void main (String[] args)
  {
    // create tree
    TestTree testTree = new TestTree();
	testTree.addNode(45, "A");
	testTree.addNode(30, "B");
	testTree.addNode(20, "C");
	testTree.addNode(28, null);
	testTree.addNode(70, "E");
	testTree.addNode(80, "F");
	
// 	Node startNode = testTree.findNodeByKey(345); // invalid node
// 	Node startNode = testTree.findNodeByKey(45); // root node
// 	Node startNode = testTree.findNodeByKey(30); // leaf node
	Node startNode = testTree.findNodeByKey(20); // leaf node

	// tree traversing
	testTree.traverseTree(startNode);
	// get children with type String of a Node in the tree
	System.out.println(testTree.getChildrenWithStrVal(startNode));
	// concatenate ancestors toString
	System.out.println(testTree.getConcatAncestors(startNode));
  }
}
