import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val=x;}
}

public class BinaryZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        if(root==null){
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<>();
        
        //add the root element with the delimeter to kick of the bfs loop
        LinkedList<TreeNode> node_queue = new LinkedList<>();
        node_queue.addLast(root);
        node_queue.addLast(null); //null acts as delimiter whenever you remove
        //  the null it means the current level is finished

        LinkedList<Integer> level_list = new LinkedList<>();// to store the level
        boolean is_order_left=true; //set the order initially it's set to left -> right

        while(node_queue.size()>0){
            TreeNode cur_Node = node_queue.pollFirst();
            if(cur_Node != null){
                //addFirst - you no need to reverse the order
                //addLast - you no need to reverse the order
                if(is_order_left)
                    level_list.addLast(cur_Node.val);
                else
                    level_list.addFirst(cur_Node.val);
                //add the childern of root node
                if(cur_Node.left != null)
                    node_queue.addLast(cur_Node.left);
                if(cur_Node.right != null)
                    node_queue.addLast(cur_Node.right);
            }
            else{
                //we finish the scan of one level
                result.add(level_list);
                level_list=new LinkedList<Integer>();
                //prepare for the next level
                if(node_queue.size()>0)
                    node_queue.addLast(null);
                is_order_left = !is_order_left; //flip direction
            }
        }
        return result;
    } 
    public static void main(String[] args) {

        BinaryZigZag tree = new BinaryZigZag();

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = tree.zigzagLevelOrder(root);

        System.out.println("Zigzag Level Order Traversal:");
        System.out.println(result);
    }

}
