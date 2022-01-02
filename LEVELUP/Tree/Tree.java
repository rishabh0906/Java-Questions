
import java.util.*;

public class Tree {

    class TreeNode {

        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.val = value;
        }
    }

    public void burnSubTree(TreeNode root, int time, ArrayList<ArrayList<Integer>> ans) {

        if (root == null)
            return;

        if (time == ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(time).add(root.val);

        burnSubTree(root.left, time + 1, ans);
        burnSubTree(root.right, time + 1, ans);
    }

    public int burningTree(TreeNode root, TreeNode target, ArrayList<ArrayList<Integer>> ans) {

        if (root == null)
            return -1;

        if (root == target) {

            burnSubTree(root, 0, ans);
            return 1;
        }

        int left = burningTree(root.left, target, ans);
        int right = burningTree(root.right, target, ans);

        if (left != -1) {

            if (ans.size() == left) {
                ans.add(new ArrayList<>());
            }
            ans.get(left).add(root.val);
            burnSubTree(root.right, left + 1, ans);
            return left + 1;
        }
        if (right != -1) {
            if (ans.size() == right) {
                ans.add(new ArrayList<>());
            }
            ans.get(right).add(root.val);
            burnSubTree(root.left, right + 1, ans);
            return right + 1;
        }

        return -1;
    }

    public ArrayList<ArrayList<Integer>> burnTree(TreeNode root, TreeNode target) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        burningTree(root, target, ans);

        return ans;
    }

    // inorder and preorder
    public TreeNode ConstructTree_02(int[] inorder, int si, int ei, int[] preorder, int sp, int ep) {

        if (sp > ep)
            return null;
        int value = preorder[sp];
        TreeNode root = new TreeNode(value);
        int idx = -1;
        for (int i = si; i <= ei; i++) {
            if (inorder[i] == value) {
                idx = i;
                break;
            }
        }
        int left_ele = idx - si;
        root.left = ConstructTree_02(inorder, si, idx - 1, preorder, sp + 1, sp + left_ele);
        root.right = ConstructTree_02(inorder, idx + 1, ei, preorder, sp + left_ele + 1, ep);

        return root;
    }

    private int idx = 0;

    public TreeNode ConstructTree(int[] inorder, int[] preorder, int start, int end) {

        if (start > end)
            return null;

        int value = preorder[this.idx++];
        TreeNode root = new TreeNode(value);

        int rootidx = -1;
        for (int i = start; i <= end; i++) {

            if (inorder[i] == value) {
                rootidx = i;
                break;
            }
        }
        root.left = ConstructTree(inorder, preorder, start, rootidx - 1);
        root.right = ConstructTree(inorder, preorder, rootidx + 1, end);

        return root;
    }

    public TreeNode ConstructTree(int[] inorder, int[] preorder) {
        int n = inorder.length;
        this.idx = 0;
        return ConstructTree(inorder, preorder, 0, n - 1);
    }

    // inorder and postorder
    public TreeNode ConstructTree_03(int[] inorder, int si, int ei, int[] postorder, int sp, int ep) {
        if (sp > ep)
            return null;

        int value = postorder[ep];
        TreeNode root = new TreeNode(value);

        int idx = -1;
        for (int i = si; i <= ei; i++) {

            if (inorder[i] == value) {
                idx = i;
                break;
            }
        }

        int left_count = idx - si;

        root.left = ConstructTree_03(inorder, si, idx - 1, postorder, sp, sp + left_count - 1);
        root.right = ConstructTree_03(inorder, idx + 1, ei, postorder, sp + left_count, ep - 1);
        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return ConstructTree_03(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    // bst from preorder
    public TreeNode construct5(int[] pre, int lower_limit, int upper_limit, int[] idx) {
        int i = idx[0];
        if (i >= pre.length || pre[i] < lower_limit || pre[i] > upper_limit)
            return null;

        TreeNode root = new TreeNode(pre[i]);
        idx[0]++;

        root.left = construct5(pre, lower_limit, pre[i], idx);
        root.right = construct5(pre, pre[i], upper_limit, idx);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] idx = new int[1];
        return construct5(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, idx);
    }

    // Serialise and Deserialise bst

    // leet 449 =====================================================

    public class Codec {

        public void getPre(TreeNode root, StringBuilder sb) {
            if (root == null)
                return;

            sb.append(root.val);
            sb.append(" ");

            getPre(root.left, sb);
            getPre(root.right, sb);

        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();

            getPre(root, sb);

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals(""))
                return null;

            String[] arr = data.split(" ");

            int[] preorder = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                preorder[i] = Integer.parseInt(arr[i]);
            }

            return bstFromPreorder(preorder);
        }
    }

    // Serialize and Deserialize BT

    public class Codec2 {

        public void getPre(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("% ");
                return;
            }

            sb.append(root.val + " ");

            getPre(root.left, sb);
            getPre(root.right, sb);
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();

            getPre(root, sb);

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode makeTree(String[] arr, int[] idx) {
            int i = idx[0];
            if (arr[i].equals("%")) {
                idx[0]++;
                return null;
            }

            int rv = Integer.parseInt(arr[i]);
            TreeNode root = new TreeNode(rv);
            idx[0]++;

            root.left = makeTree(arr, idx);
            root.right = makeTree(arr, idx);

            return root;
        }

        public TreeNode deserialize(String data) {
            if (data.equals(""))
                return null;

            String[] arr = data.split(" ");

            return makeTree(arr, new int[1]);
        }
    }

}
