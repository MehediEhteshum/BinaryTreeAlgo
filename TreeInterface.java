import java.util.*;

public interface TreeInterface {
    // Will return empty list if node has no children
    public List<Node> getChildren(Node node);
    public List<Node> getChildrenWithStrVal(Node node);
      
    // Will return null if node is the root of the tree
    public Node getParent(Node node);
    public List<Node> getAncestors(Node node);
    public String getConcatAncestors(Node node);
    
    public boolean isInTree(Node node);
}