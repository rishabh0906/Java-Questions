public class BST {

    public static class TreeNode {

        Integer value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public static TreeNode insert(TreeNode root, int val) {

        if (root == null)
            return new TreeNode(val);

        if (root.value < val) {
            root.right = insert(root.right, val);
        } else if (root.value > val) {
            root.left = insert(root.left, val);
        }

        return root;
    }

    public static TreeNode inorderSuccessor(TreeNode root) {

        TreeNode curr = root;
        while (curr.left != null) {

            curr = curr.left;
        }

        return curr;
    }

    public static TreeNode delete(TreeNode root, int value) {
        if (root == null)
            return null;

        if (root.value < value) {
            root.right = delete(root.right, value);
        } else if (root.value > value) {
            root.left = delete(root.left, value);
        } else {

            // Leaf value
            if (root.left == null && root.right == null)
                return null;

            // Having one child
            if (root.left == null || root.right == null) {
                if (root.left == null) {
                    TreeNode temp = root.right;
                    root = null;
                    return temp;
                }
                TreeNode temp = root.left;
                root = null;
                return temp;

            }

            // Both Child

            TreeNode successor = inorderSuccessor(root.right);
            root.value = successor.value;
            root.right = delete(root.right, successor.value);

            return root;

        }

        return root;
    }

}