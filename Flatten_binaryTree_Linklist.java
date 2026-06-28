class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


public class Flatten_binaryTree_Linklist{
    private static TreeNode flattenTree(TreeNode node){
        if(node == null){
            return null;
        }

        // If leaf node, return itself
        if(node.left == null && node.right == null){
            return node;
        }

        // Flatten left and right
        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        // If left subtree exists, rearrange
        if(leftTail != null){
            leftTail.right=node.right;
            node.right=node.left;
            node.left=null;
        }
        return rightTail==null? leftTail:rightTail;
    }
    private static void flatten(TreeNode root){
        flattenTree(root);

    }
     private static void printList(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println("null");
    }
    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        System.out.println("Before Flatten:");
        printList(root);
        printList(root.left);

        flatten(root);

        System.out.println("After Flatten:");
        printList(root);
    }
}