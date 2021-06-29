public class Node {
  public int key;
  public String value;

  // assuming the tree will be binary
  Node lChild;
  Node rChild;

  public Node (int key, String value)
  {
    this.key = key;
    this.value = value;
  }

  public String toString ()
  {
    return "Node - key: " + key + ", value: " + value;
  }
}
