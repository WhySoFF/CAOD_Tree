public class Main {

    static Tree tree = new Tree();

    public static void main(String[] args) {
        tree.add(5);
        tree.add(2);
        tree.add(4);
        tree.add(3);
        tree.add(-3);
        tree.add(1);
        tree.add(8);
        tree.add(6);
        tree.add(7);

        tree.forwardTraversal();

        tree.simmetricTraversal();

        tree.delete(7);

        tree.simmetricTraversal();

        tree.delete(5);

        tree.simmetricTraversal();

        tree.forwardTraversal();
        tree.backwardTraversal();
    }
}