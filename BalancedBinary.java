class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val=x;}
}

public class BalancedBinary {
    public boolean isBalanced(TreeNode root){
        if(root==null) return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight)+1;
    }
    public static void main(String[] args){
        BalancedBinary tree = new BalancedBinary();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        boolean result = tree.isBalanced(root);
        System.out.println(result);
    }
}
