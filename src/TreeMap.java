/**
 * An interface specifying a generic tree-like API
 */
public interface TreeMap<Key extends Comparable<Key>, Value> {
    Value search(Key key);
    void insert(Key key, Value value);
    Value remove(Key key);
}
