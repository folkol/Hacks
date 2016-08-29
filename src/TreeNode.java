public class TreeNode {
    TreeNode left;
    TreeNode right;
    private int i;

    public TreeNode(int i) {

        this.i = i;
    }

    public void add(int i) {
        TreeNode node = new TreeNode(i);
        node.left = this.left;
        this.left = node;
    }

    public boolean contains(int i) {
        return this.i == i
                || (left != null && left.contains(i))
                || (right != null && right.contains(i));
    }
}
