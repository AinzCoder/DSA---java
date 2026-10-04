class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Symmetric {
    public boolean isSymmetric(TreeNode root){
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }
    private boolean isMirror(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        return (left.val == right.val) 
            && isMirror(left.left, right.right) 
            && isMirror(left.right, right.left);
        //comparing the left child of the left tree and the right child of the right tree
        //comparing the right child of the left tree and the left child of the right tree
    }
   public static void main(String [] args){
    Symmetric tree = new Symmetric();

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);

    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);

    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);

    boolean result = tree.isSymmetric(root);

    System.out.println("Is Symmetric? " + result);
    
   } 
}
