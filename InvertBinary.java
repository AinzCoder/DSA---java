class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val=x;}; 
}

public class InvertBinary {
    public TreeNode invertTree(TreeNode root){
        if(root==null) return null;

        //recursive call for subtrees
        // Invert left and right subtrees
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        //replace the values of left and right subtrees
        root.left = right;
        root.right = left;
        return root;
    }
    // Inorder Traversal
    public void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void main(String []args){
        InvertBinary bin = new InvertBinary();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        root=bin.invertTree(root);
        bin.inorder(root);;

    }

}
