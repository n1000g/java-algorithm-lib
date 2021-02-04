package test;

import leetcode.*;
import utils.StringUtils;
import utils.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 *      1,2,3,null,4,null,5,null,null,6,7,null,null,null,8
 *
 *                            1
 *                          /  \
 *                         2    3
 *                         \     \
 *                          4     5
 *                               / \
 *                              6   7
 *                                   \
 *                                    8
 */
public class SearchQuestionTests {

    public static final Solution102 q102 = new Solution102();
    public static final Solution433 q433 = new Solution433();
    public static final Solution22 q22 = new Solution22();

    public static final String binaryTreeString = "1,2,3,null,4,null,5,null,null,6,7,null,null,null,8";

    public static final TreeNode root = StringUtils.stringToBinaryTree(binaryTreeString);

    public static void main(String[] args) {
        test102();
        // test433();
        test22();
    }

    private static void test102() {
        List<List<Integer>> level = q102.levelOrder(root);
        System.out.println("level : ");
        System.out.println(Arrays.toString(level.toArray()));
    }

    private static void test22() {
        List<String> strings = q22.generateParenthesis(4);
        System.out.println("strings : ");
        System.out.println(Arrays.toString(strings.toArray()));
    }
}
