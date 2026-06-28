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


public class SameTree {

    private boolean sameTree(TreeNode p, TreeNode q){

        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        if(p.val !=q.val){
            return false;
        }
        return sameTree(p.left,q.left) && sameTree(p.right, q.right);
    }
    public static void main(String[] args) {

        SameTree obj = new SameTree();

        // Tree 1
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Tree 2
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean result = obj.sameTree(p, q);

        System.out.println(result);
    }
}
