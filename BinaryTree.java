public abstract class BinaryTree {
    Node root; // tree always has a root Node
    
    // add nodes to the tree
    public void addNode(int key, String value){
        Node newNode = new Node(key, value);
        if (this.root == null) {
            // tree is empty
            this.root = newNode;
        } else {
            // tree is not empty. add node.
            Node focusNode = this.root; // starting node
            Node parent; // newNode's future parent
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    // go to the left node.
                    focusNode = focusNode.lChild;
                    if (focusNode == null) {
                        // no node exists. so add to parent.
                        parent.lChild = newNode;
                        return; // node added under root left.
                    }
                } else {
                    // go to the right node.
                    focusNode = focusNode.rChild;
                    if (focusNode == null) {
                        // no node exists. so add to parent.
                        parent.rChild = newNode;
                        return; // node added under root right.
                    }
                }
            }
        }
    }
    
    public Node findNodeByKey (int key) {
        Node focusNode = root;
        
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                // go to left node
                focusNode = focusNode.lChild;
            } else {
                // go to right node
                focusNode = focusNode.rChild;
            }
            
            if (focusNode == null) {
                return null;
            }
        }
        
        return focusNode;
    }
    
    public abstract void traverseTree (Node node);
}