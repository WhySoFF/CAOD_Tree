public class Tree {

    private Node root = null;

    void add(int key) {
        if(root == null) {
            root = new Node(key);
        } else {
            pushElem(key, root);
        }
    }

    private void pushElem(int key, Node current) {
        if(key < current.key) {
            if(current.leftChild == null) {
                current.leftChild = new Node(key);
            }
            else
                pushElem(key, current.leftChild);
        } else if (key > current.key) {
            if(current.rightChild == null) {
                current.rightChild = new Node(key);
            }
            else
                pushElem(key, current.rightChild);
        }
    }

    private Node search(int key, Node current) {
        if(key == current.key) {
            return current;
        } else if(key < current.key) {
            if(current.leftChild == null)
                return null;
            else
                return search(key, current.leftChild);
        } else {
            if(current.rightChild == null)
                return null;
            else
                return search(key, current.rightChild);
        }
    }

    boolean contains(int key) {
        return search(key, root) != null;
    }

    private void recursiveForward(Node current) {
        System.out.printf("%d ", current.key);
        if(current.leftChild != null) {
            recursiveForward(current.leftChild);
        }
        if(current.rightChild != null) {
            recursiveForward(current.rightChild);
        }
    }

    void forwardTraversal() {
        System.out.println("\nForward traversal : \n");
        recursiveForward(root);
    }

    private void recursiveSimmetric(Node current) {

        if(current.leftChild != null) {
            recursiveSimmetric(current.leftChild);
        }
        System.out.printf("%d ", current.key);
        if(current.rightChild != null) {
            recursiveSimmetric(current.rightChild);
        }
    }

    void simmetricTraversal() {
        System.out.println("\nSimmetric traversal : \n");
        recursiveSimmetric(root);
    }

    private void recursiveBackward(Node current) {
        if(current.leftChild != null) {
            recursiveBackward(current.leftChild);
        }
        if(current.rightChild != null) {
            recursiveBackward(current.rightChild);
        }
        System.out.printf("%d ", current.key);
    }

    void backwardTraversal() {
        System.out.println("\nBackward traversal : \n");
        recursiveBackward(root);
    }

    private int searchReplace(Node current) {
        while(current.rightChild != null) {
            current = current.rightChild;
        }
        return current.key;
    }

    private Node deleteNode(int key, Node current) {
        if(key == current.key) {
            if(current.leftChild == null && current.rightChild == null) {
                return null;
            }
            if (current.rightChild == null) {
                return current.leftChild;
            }
            if(current.leftChild == null) {
                return current.rightChild;
            }
            int replaceKey = searchReplace(current.leftChild);
            current.key = replaceKey;
            current.leftChild =  deleteNode(replaceKey, current.leftChild);
            return current;
        } else if(key < current.key) {
            current.leftChild = deleteNode(key, current.leftChild);
            return current;
        }
        current.rightChild = deleteNode(key, current.rightChild);
        return current;
    }

    void delete(int key) {
        if(contains(key))
            root = deleteNode(key, root);
    }


    class Node {
        Node leftChild;
        Node rightChild;
        int key;

        Node(int key) {
            this.key = key;
            leftChild = null;
            rightChild = null;
        }
    }
}