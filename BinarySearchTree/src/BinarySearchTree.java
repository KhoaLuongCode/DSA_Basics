public class BinarySearchTree {

    private Node rootNode;

    private int k;

    public BinarySearchTree() {
        rootNode = null;
    }

    public void createTree(int[] values){
        for (int value : values) {
            insert(value);
        }
    }

    public void insert(int key) {

        Node nodeInserted = new Node(key);

        if (rootNode == null){
            rootNode = nodeInserted;
        }
        else {
            insertHelperMethod(rootNode, key);
        }
    }

    // A helper method that contains the root-node in the parameter in order to call recursively the method
    private Node insertHelperMethod(Node node, int key){

        if (node == null) {
            return new Node(key);
        }

        if (key < node.key){
            node.left = insertHelperMethod(node.left, key);
        }
        if (key > node.key){
            node.right = insertHelperMethod(node.right, key);
        }

        return node;
    }

    public boolean search(int key){

        Node nodeSearch = searchTree(rootNode, key);

        if (nodeSearch == null){
            return false;
        }
        else{
            return true;
        }
    }


    private Node searchTree(Node node, int key) {
        Node traverse = node;
        while (traverse != null) {
            if (key == traverse.key) {
                return traverse;
            } else if (key < traverse.key) {
                traverse = traverse.left;
            } else {
                traverse = traverse.right;
            }
        }
        return null;
    }

    public Node delete(int key) {
        // Find the node and its parent.
        Node parent = null;
        Node traverse = rootNode;
        while (traverse != null && traverse.key != key) {
            parent = traverse;
            if (key < traverse.key) {
                traverse = traverse.left;
            }
            else {
                traverse = traverse.right;
            }
        }
        // Delete the node
        if (traverse == null) // no such key
            return null;
        else {
            deleteHelperMethod(traverse, parent);
            return rootNode;
        }
    }

    //  A helper method that contains the root-node in the parameter in order to call recursively the method
    public void deleteHelperMethod(Node nodeToDelete, Node parent){
        // case that has at most one child
        if (nodeToDelete.left == null || nodeToDelete.right == null){
            // have to create a reference to the delete child to connect to the parent
            Node childOfNodeToDelete = null;

            // case if has child left and no child right
            if (!(nodeToDelete.left == null)){
                childOfNodeToDelete = nodeToDelete.left;
            }
            // case if has child right and no child left
            else if (!(nodeToDelete.right == null)){
                childOfNodeToDelete = nodeToDelete.right;
            }

            // connect child to parent
            if (nodeToDelete.key < parent.key){
                parent.left = childOfNodeToDelete;
            }
            else if (nodeToDelete.key > parent.key){
                parent.right = childOfNodeToDelete;
            }
            else if(nodeToDelete == rootNode){
                rootNode = childOfNodeToDelete;
            }
        }
        // third case two children
        else {
            // Find the minimum in the right tree and its parent
            Node replacementParent = nodeToDelete;
            Node replacement = nodeToDelete.right;

            while (replacement.left != null) {
                replacementParent = replacement;
                replacement = replacement.left;
            }

            nodeToDelete.key = replacement.key;

            deleteHelperMethod(replacement, replacementParent);
        }
    }

    public void inOrderRec(){
        inOrderHelpermethod(rootNode);
    }

    public void inOrderHelpermethod(Node node){

        // base case node == null
        if (node == null){
            return;
        }

        inOrderHelpermethod(node.left);
        System.out.println(node.key);
        inOrderHelpermethod(node.right);
    }

    public void preOrderRec(){
        preOrderHelpermethod(rootNode);
    }

    public void preOrderHelpermethod(Node node){

        // base case node == null
        if (node == null){
            return;
        }

        System.out.println(node.key);
        preOrderHelpermethod(node.left);
        preOrderHelpermethod(node.right);
    }

    public void postOrderRec(){
        postOrderHelpermethod(rootNode);
    }

    public void postOrderHelpermethod(Node node){

        // base case node == null
        if (node == null){
            return;
        }

        postOrderHelpermethod(node.left);
        postOrderHelpermethod(node.right);
        System.out.println(node.key);
    }

    public void setCount(int k){
        this.k = k;
    }

    public int getCount(){
        return k;
    }

    public Node kthSmallest(int k){
        setCount(0);
        return kthSmallestHelper(rootNode, k);
    }

   private Node kthSmallestHelper(Node node, int k){

       // base case node == null
       if (node == null){
           return null;
       }

       // traversing to the left
       Node smallestInTheLeft = kthSmallestHelper(node.left, k);

       // Find the smallest number in the whole binary search tree
       if(smallestInTheLeft != null) {
           return smallestInTheLeft;
       }

       setCount(getCount() + 1);
       if(getCount() == k) {
           return node;
       }

       return kthSmallestHelper(node.right, k);
   }

}