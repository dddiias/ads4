
public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<Integer, String>();

        bst.put(5, "five");
        bst.put(3, "three");
        bst.put(7, "seven");
        bst.put(2, "two");
        bst.put(4, "four");

        System.out.println("Size of BST: " + bst.size());

        System.out.println("Value associated with key 3: " + bst.get(3));

        bst.delete(3);

        System.out.println("Value associated with key 3 after deletion: " + bst.get(3));

        System.out.println("Size of BST after deletion: " + bst.size());

        System.out.println("Keys in BST in ascending order:");
        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }
    }

}