/**
 * This is a red-black tree node
 */
public class Node<Key extends Comparable<Key>, Value> implements TreeMapNode<Key, Value, Node> {
    private boolean isBlack;
    private Key key;
    private Value value;
    private Node rightChild = null;
    private Node leftChild = null;
    //not sure whether to include the parent in the Node is considered canonical
    private Node parent = null;

    Node(Key key, Value value, boolean isBlack){
        this.key = key;
        this.value = value;
        this.isBlack = isBlack;
    }

    Node(Key key, Value value, boolean isBlack, Node parent){
        this.key = key;
        this.value = value;
        this.isBlack = isBlack;
        this.parent = parent;
    }

    @Override
    Value getValue(){ return value; }

    @Override
    public void setKey(Key key) {

    }

    @Override
    protected void setValue(Value value) {

    }

    @Override
    protected Key getKey(){ return key; }

    @Override
    protected Node getParent(){ return parent; }

    @Override
    protected Node getRightChild() { return rightChild; }

    @Override
    protected Node getLeftChild() { return leftChild; }

    @Override
    protected void setRightChild(Node rightChild){
        this.rightChild = rightChild;
    }
    @Override
    protected void setLeftChild(Node leftChild){
        this.leftChild = leftChild;
    }
    @Override
    protected void setParent(Node parent){
        this.parent = parent;
    }

}
