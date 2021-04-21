package my.play.ground;

import java.util.List;
import java.util.stream.Collectors;

public class TreeNodeApp {

    public void collect(List<TreeNode> list) {
        list.stream().map(n -> String.valueOf(n.val)).collect(Collectors.joining(","));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}