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
public class RBTreeMap<Key extends Comparable<Key>, Value> implements TreeMap<Key, Value>{

    private int size = 0;
    private int capacity;
    private Node root = null;

    public RBTreeMap(int capacity){
        this.capacity = capacity;
    }

    @Override
    public Value search(Key key) {
        return null;
    }

    @Override
    public void insert(Key key, Value value) {
        //find spot to insert
        if(root == null){ root = new Node(key, value, true); }
        else if(){

        }
    }

    /**
     * @param node1 A Node to measure
     * @param node2 A Node to measure
     *
     * @return a boolean representing whether node1 is less than node2.
     */
    private boolean isLess(Node node1, Node node2){
        return node1.getKey().compareTo(node2.getKey()) < 0;
    }

    private void getChildren(){
        //left children are always uneven

    }

    /**
     * @param rotationNode the parent to rotate left
     */
    private void rotateLeft(Node rotationNode){
        rotationNode.rightChild
    }

    /**
     * @param rotationNode the parent to rotate left
     */
    private void rotateRight(Node rotationNode){

    }

    private void scan(){

    }

    @Override
    public Value remove(Key key) {
        return null;
    }

    //grandparents child !=
    private void rotate(Node node){

    }

    private boolean isRoot(Node node){
        return node == root;
    }

    /**
     * When countin paths, don't include the starting point
     */
}
