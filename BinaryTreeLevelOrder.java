import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val=x;}
}

public class BinaryTreeLevelOrder {

    static List<List<Integer>> ans = new ArrayList<>();

    public void order(TreeNode node,int level){
        if(ans.size() == level){
            ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(node.val);
        if(node.left!=null){
            order(node.left, level+1);
        }
        if(node.right!=null){
            order(node.right, level+1);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root==null) return ans;

        order(root, 0);
        return ans;
    }
    public static void main(String[] args){
        BinaryTreeLevelOrder tree = new BinaryTreeLevelOrder();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right= new TreeNode(6);

        List<List<Integer>> result = tree.levelOrder(root);

        System.out.println(result);
    } 
}
