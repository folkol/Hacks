import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TreeNodeTest {
    @Test
    public void testAddNode() throws Exception {
        TreeNode root = new TreeNode(100);
        root.add(10);

        assertTrue(root.contains(10));
    }
}