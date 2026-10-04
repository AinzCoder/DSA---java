import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val=x;}
}

public class BinaryRightSizeView {

    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        //using Queue<TreeNode> because we do not need to use addLast, addFirst methods considered to 
        //LinkedList<TreeNode> Queue is faster
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size(); // gets the size of the queue in each level

            for(int i=0;i<levelSize;i++){
                TreeNode curNode = queue.poll();
                //add last node's value of each level to the  result list
                if(i==levelSize-1){
                    result.add(curNode.val);
                }
                //add child nodes to the queue to the next level
                if(curNode.left!=null){
                    queue.add(curNode.left);
                }
                if(curNode.right!=null){
                    queue.add(curNode.right);
                }
            }
        }
        return result;
    } 
    public static void main(String[] args) {

        BinaryRightSizeView tree = new BinaryRightSizeView();

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        List<Integer> result = tree.rightSideView(root);

        System.out.println("Right Side View:");
        System.out.println(result);
    }
}
