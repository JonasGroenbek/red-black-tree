import java.lang.IllegalArgumentException;

/**
 *
 * This is an implementation of a binary red-black tree
 *
 * A red black tree has following criteria:
 * - A node is either red or black
 * - The root and leaves are black
 * - If a node is red, then its children are black
 * - All paths from a node to its null descendants contain the same number of black nodes
 *
 * @author Jonas Thorhauge Grønbek
 */
public class RBTree<Key extends Comparable<Key>, Value> implements TreeMap<Key, Value>{

    private int size = 0;
    private int capacity;
    private Node root = null;

    public RBTree(int capacity){
        this.capacity = capacity;
    }

    @Override
    public Value search(Key key) {
        Node segregator = root;
        while(segregator != null){
            if(segregator.key == key){
                return segregator.value;
            }
            if(lessThan(key, segregator.key)){
                segregator = segregator.leftChild;
            } else {
                segregator = segregator.rightChild;
            }
        }
        return null;
    }

    //does not produce correct red black values
    @Override
    public void insert(Key key, Value value) throws IllegalArgumentException{
        if(key == null) throw new IllegalArgumentException("Node keys cannot be null");
        //no root
        if(root == null){
            root = new Node(key, value, true, null, null, null);
            return;
        }

        Node segregator = root;

        while(segregator != null) {
            //if key is equals to segregator, then the key already exist in correct position, just update the value
            if (segregator.key == key) {
                segregator.value = value;
                break;
            }
            //less than segre<gator
            if(lessThan(key, segregator.key)){
                if(segregator.leftChild == null) {
                    //RB value wrong
                    Node newNode = new Node(key, value, !segregator.isBlack, segregator, null,null);
                    segregator.leftChild = newNode;
                    break;
                } else if(lessThan(key, segregator.leftChild.key)) {
                    segregator = segregator.leftChild;
                } else {
                    Node newNode = new Node(key, value, segregator.leftChild.isBlack, segregator, segregator.leftChild,null);
                    segregator.leftChild.parent = newNode;
                    segregator.leftChild = newNode;
                    break;
                }
            //greater than segregator
            } else {
                if(segregator.rightChild == null) {
                    //RB value wrong
                    Node newNode = new Node(key, value, !segregator.isBlack, segregator, null,null);
                    segregator.rightChild = newNode;
                    break;
                } else if(lessThan(key, segregator.rightChild.key)) {
                    segregator = segregator.leftChild;
                } else {
                    Node newNode = new Node(key, value, segregator.rightChild.isBlack, segregator,null, segregator.rightChild);
                    segregator.rightChild.parent = newNode;
                    segregator.rightChild = newNode;
                    break;
                }
            }
        }
    }

    @Override
    public Value remove(Key key) {
        return null;
    }

    /**
     * @param key1 A Node to measure
     * @param key2 A Node to measure
     *
     * @return a boolean representing whether node1 is less than node2.
     */
    private boolean lessThan(Key key1, Key key2){
        return key1.compareTo(key2) < 0;
    }

    /**
     * This function rotates a note to the left by substituting the right child in it's place and setting it as it's
     * left child. The former left child of the new parent will be set as the former parents right child
     *
     * @param rotationNode the parent to rotate left
     */
    private void rotateLeft(Node rotationNode){
        rotationNode.rightChild.parent = rotationNode.parent;
        rotationNode.parent = rotationNode.rightChild;
        rotationNode.rightChild = rotationNode.rightChild.leftChild;

    }

    /**
     * This function rotates a note to the right by substituting the left child in it's place and setting it as it's
     * right child. The former right child of the new parent will be set as the former parents left child
     *
     * @param rotationNode the parent to rotate left
     */
    private void rotateRight(Node rotationNode){
        rotationNode.leftChild.parent = rotationNode.parent;
        rotationNode.parent = rotationNode.leftChild;
        rotationNode.leftChild = rotationNode.leftChild.rightChild;
    }

    private void scan(){

    }

    //grandparents child !=
    private void rotate(Node node){

    }

    private boolean isRoot(Node node){
        return node == root;
    }

    class Node /* implements TreeMapNode<Key, Value, Node> */ {
        private boolean isBlack;
        private Key key;
        private Value value;
        private Node rightChild;
        private Node leftChild;
        //not sure whether to include the parent in the Node is considered canonical
        private Node parent;

        Node(Key key, Value value, boolean isBlack, Node parent, Node leftChild, Node rightChild) {
            this.key = key;
            this.value = value;
            this.isBlack = isBlack;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
        /*
        @Override
        public Key getKey(){ return key; }

        @Override
        public Value getValue() { return value; }

        @Override
        public Node getParent(){ return parent; }

        @Override
        public Node getRightChild() { return rightChild; }

        @Override
        public Node getLeftChild() { return leftChild; }

        @Override
        public void setKey(Key key) {
            this.key = key;
        }

        @Override
        public void setValue(Value value) {
            this.value = value;
        }

        @Override
        public void setRightChild(Node rightChild){
            this.rightChild = rightChild;
        }

        @Override
        public void setLeftChild(Node leftChild){
            this.leftChild = leftChild;
        }

        @Override
        public void setParent(Node parent){
            this.parent = parent;
        }
        */
    }

}

class Main {
    public static void main(String[] args) {
        RBTree<Integer, String> rbtree = new RBTree(10);
        rbtree.insert(5, "svensen");
        rbtree.insert(4, "svensen");
        rbtree.insert(2, "svensen");
        rbtree.insert(8, "svensen");
        rbtree.insert(10, "svensen");
        rbtree.insert(1, "hey");



    }
}
