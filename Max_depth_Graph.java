class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}

public class Max_depth_Graph {
   
    private int maxDepth(TreeNode root){

        if(root==null){
            return 0;
        }
        else{
            int leftMax=maxDepth(root.left);
            int rightMax=maxDepth(root.right);
            return java.lang.Math.max(leftMax,rightMax)+1;
        }
    }
    public static void main(String[] args){
        Max_depth_Graph tree = new Max_depth_Graph();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        int depth = tree.maxDepth(root);

        System.out.println("Maximum Depth = " + depth);
    }
}
