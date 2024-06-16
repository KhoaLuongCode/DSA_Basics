public class Main {
    public static void main(String args[]){

        // Create a binary search tree
        BinarySearchTree bst = new BinarySearchTree();

        // Start insert the numbers in
        bst.insert(40);
        bst.insert(45);
        bst.insert(25);
        bst.insert(43);
        bst.insert(27);
        bst.insert(15);
        bst.insert(4);
        bst.insert(69);

        // InOrder
        System.out.println("Inorder Traversal: " );
        bst.inOrderRec();
        System.out.println();

        // PreOrder
        System.out.println("PreOrder Traversal: " );
        bst.preOrderRec();
        System.out.println();

        // PostOrder
        System.out.println("PostOrder Traversal: " );
        bst.postOrderRec();
        System.out.println();

        System.out.println("Search method:");
        // Search method: Returns true when 4 is searched because the tree contains 4
        System.out.println(bst.search(4));
        System.out.println("BST does contain 4");

        // Search method: Returns false when 69 is searched because the tree does not contain 69
        System.out.println(bst.search(69));
        System.out.println("BST does not contain 69");

        // Delete method
        System.out.println(" ");
        System.out.println("Delete method: ");
        System.out.println("The number 4 now has been deleted: Case with no children ");
        bst.delete(4);
        bst.inOrderRec();
        System.out.println();

        System.out.println("The number 25 now has been deleted: Case with two children ");
        bst.delete(25);
        bst.inOrderRec();
        System.out.println();

        // Create tree method
        System.out.println("Create Tree Method: ");
        System.out.println("16, 44, and 42 were added to the binary search tree");
        int[] values = {16, 44, 42};
        bst.createTree(values);
        bst.inOrderRec();
        System.out.println();

        // kth smallest method
        System.out.println("Kth smallest method: ");
        System.out.println("Kth smallest method: k = 1");
        Node kthSmallest = bst.kthSmallest(1);
        System.out.println(kthSmallest.key);

        System.out.println(" ");
        System.out.println("Kth smallest method: Exceed the number of nodes in BST");
        Node kthSmallest1 = bst.kthSmallest(69);
        if (kthSmallest1 == null){
            System.out.println("Printed null because it doesn't exist");
        }

        System.out.println(" ");
        System.out.println("Kth smallest method: k = 3");
        Node kthSmallest2 = bst.kthSmallest(4);
        System.out.println(kthSmallest2.key);

    }
}
