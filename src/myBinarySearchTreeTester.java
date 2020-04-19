import static org.junit.Assert.*;
import org.junit.Test;

public class myBinarySearchTreeTester {
    /* Test #1:
     *  The purpose of testing insert is to see if insert will know when to not add new nodes if given duplicates.
     * The reason I chose this test is because in normal Binary search trees, duplicates are allowed as long as they are
     * NOT in both left and right subtrees. Duplicates are not allowed so, I expect my test to work when given many duplicates
     * to throw it off.
     * TEST RESULT: PASSED
     * Original tree before insertion:
     *                  4
     *              /       \
     *             2         5
     *            /   \       \
     *           1     3       8
     *
     * Original tree after insertion:
     *                 4
     *              /       \
     *             2         5
     *            /   \       \
     *           1     3       8
     *          /             /
     *         0             6
     *
     * */
    @Test
    public void testInsert(){
        int[] A = {4,5,2,8,3,1};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(A);
        tree.insert(6);
        tree.insert(0);
        tree.insert(2);

        int[] expected = {4,5,2,8,6,3,1,0};
        myBinarySearchTreeNode treeResult = new myBinarySearchTreeNode(expected);


        // checking if the root node matches the expected root
        assertEquals(treeResult.myValue, tree.myValue);
        //checking the left branch of the root (4)---> (2)
        assertEquals(treeResult.left.myValue, tree.left.myValue);
        //checking the left branch of the left subtree (2)-->(1)
        assertEquals(treeResult.left.left.myValue, tree.left.left.myValue);
        //checking the right branch of the left subtree(2) ---> (3)
        assertEquals(treeResult.left.right.myValue, tree.left.right.myValue);
        //checking the left branch of the left subtree (1)---> (0)
        assertEquals(treeResult.left.left.left.myValue, tree.left.left.left.myValue);
        //checking the right branch of the root(4)--->(5)
        assertEquals(treeResult.right.myValue, tree.right.myValue);
        //checking the right branch of the right subtree(5)--->(8)
        assertEquals(treeResult.right.right.myValue, tree.right.right.myValue);
        //checking the left branch of the right subtree (8)--->(6)
        assertEquals(treeResult.right.right.left.myValue, tree.right.right.left.myValue);
    }

    /* Test #2:
     * This test will check if the height method is working correctly if the method
     * is given 1 value. The purpose of this is make sure that the recursive call recognizes
     * that there is only 1 node. So, the height should be 0(since there is only the ROOT).
     * I expect the test to fail because there is no case in which the method returns anything
     * when there's NULL branches.
     * Expect height for the root node(0) : 0
     * Actual height: 1
     * TEST RESULT: FAIL
     */
    @Test
    public void testHeight(){
        int[] A = {0};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(A);
        int result = 0;
        assertEquals(result, tree.height());
    }

    /* Test #3:
    * This test checks to see if the depth method will correctly calculate the depth of a node(X).
    * This is important because it let's us know just how far out tree of data extends to. I expect
    * the test to pass.
    * TEST RESULT: PASSED
    * Original Tree:
    *           5
    *         /   \
    *       1      6
    *     /  \      \
    *     0  2       8
    *                 \
    *                  9
    * Expected Depth for node(2): 2
    * Actual Depth : 2
    *  */
    @Test
    public void testDepth(){
        int[] A = {5,1,6,0,8,2,9};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(A);
        int result = 2;
        assertEquals(result, tree.depth(2));
    }

    /* Test #4:
    *  This tests the size method, I'm testing it given a tree with 15 nodes.
    * The reason I'm using such a large tree is because I expect the method to find every single
    * one to calculate the size. If it fails, then it missed nodes that may/maynot hold
    * important data. So, I expect the test to pass.
    * TEST RESULT: PASSED
    *
    * */
    @Test
    public void testSize(){
        int[] A = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(A);
        int result = 15;
        assertEquals(result, tree.size());
    }

    /* Test #5:
     * This last test also checks the size method again except this time I'm giving it a tree of size 40.
     * I want to test the limitations and runtime of the method, so it may take longer to find the tree size.
     * I expect the test to fail.
     * TEST RESULT: PASSED
     * */
    @Test
    public void testSize2(){
        int[] A = {1,2,3,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
                     21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(A);
        int result = 40;
        assertEquals(result, tree.size());

    }






















}
