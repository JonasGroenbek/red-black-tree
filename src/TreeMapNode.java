/**
 * An interface for a generic TreeMap
 * Why doesn't java interfaces allow protected method scope?
 */
public interface TreeMapNode<Key, Value, Node> {
    Node getParent();
    Node getRightChild();
    Node getLeftChild();
    Key getKey();
    Value getValue();
    void setKey(Key key);
    void setValue(Value value);
    void setParent(Node parent);
    void setRightChild(Node rightChild);
    void setLeftChild(Node leftChild);
}
