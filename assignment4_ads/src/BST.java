import java.util.LinkedList;
import java.util.Queue;

public class BST <K extends Comparable<K>, V>{
    private Node root;
    private int size;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key=key;
            this.val=val;
        }
    }
    public void put(K key, V val){
        root = put(root, key, val);
    }
    private Node put(Node x, K key, V value) {
        if (x == null) {
            size++;
            return new Node(key, value);
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.val = value;
        }

        return x;
    }
    public V get(K key){
        Node x = root;

        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }

        return null;
    }
    public void delete(K key){
        root = delete(root, key);
    }
    private Node delete(Node x, K key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                size--;
                return x.left;
            }

            if (x.left == null) {
                size--;
                return x.right;
            }

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
            size--;
        }

        return x;
    }
    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);
        return x;
    }

    private Node min(Node x) {
        while (x.left != null) {
            x = x.left;
        }

        return x;
    }
    public Iterable<K> iterator(){
        Queue<K> queue = new LinkedList<K>();
        inorder(root, queue);
        return queue;
    }
    private void inorder(Node x, Queue<K> queue) {
        if (x == null) {
            return;
        }

        inorder(x.left, queue);
        queue.add(x.key);
        inorder(x.right, queue);
    }

    public int size() {
        return size;
    }
}
