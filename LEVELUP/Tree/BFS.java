import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
    class TreeNode {

        Integer value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public ArrayList<Integer> LeftView(TreeNode root) {

        LinkedList<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> nodes = new ArrayList<>();
        q.add(root);
        while (q.size() != 0) {

            int size = q.size();
            boolean first = true;
            while (size-- > 0) {

                TreeNode top = q.removeFirst();
                if (first) {
                    nodes.add(top.value);
                    first = false;
                }

                if (top.left != null) {
                    q.addLast(top.left);
                }

                if (top.right != null) {
                    q.addLast(top.right);
                }

            }

        }

        return nodes;

    }

    public void RightView(TreeNode root, int level, ArrayList<Integer> ans) {
        if (root == null)
            return;

        if (level == ans.size())
            ans.add(root.value);

        RightView(root.right, level + 1, ans);
        RightView(root.left, level + 1, ans);
    }

    public ArrayList<Integer> RightView(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        RightView(root, 0, ans);

        return ans;
    }


    public void VerticalView(TreeNode root){
        
    }
}
