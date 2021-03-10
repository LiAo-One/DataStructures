package com.liao.tree.threadetree;

/**
 * <p>
 * 线索化二叉树
 * </p>
 *
 * @author LiAo
 * @since 2021/3/10
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, " tom1");
        HeroNode node2 = new HeroNode(3, "tom3");
        HeroNode node3 = new HeroNode(6, "tom6");
        HeroNode node4 = new HeroNode(8, "tom8");
        HeroNode node5 = new HeroNode(10, "tom10");
        HeroNode node6 = new HeroNode(14, "tom14");

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

        // 创建树
        BinaryTree binaryTree = new BinaryTree(root);

        // 执行线索化
        binaryTree.threadedNodes();

        // 打印节点 验证是否线索化成功
        System.out.println(node5.left.name);
        System.out.println(node5.right.name);

        binaryTree.threadedList();

    }
}

class BinaryTree {

    // 根节点
    private HeroNode root;

    // 指向当前节点的前驱节点的指针
    private HeroNode pre;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    public void threadedList(){
        HeroNode node  = root;

        while (node != null){
            // 循环的找到leftType==1的结点，第一个找到就是8结点
            // 后面随着遍历而变化，因为当leftType==1时，说明该结点是按照线索化
            // 处理后的有效结点
            while (node.leftType == 0){
                node = node.left;
            }
            // 打印当前节点
            System.out.println(node.no + "===>" + node.name);
            // 如果当前节点的右指针指向的后继节点，就一直输出
            while (node.rightType == 1){
                node = node.right;
                System.out.println(node.no + "===>" + node.name);
            }

            node = node.right;
        }
    }


    public void threadedNodes() {
        threadedNodes(root);
    }

    // 二叉树中序线索化
    public void threadedNodes(HeroNode node) {
        // 如果node 等于空 就无法线索化
        if (node == null) {
            return;
        }

        // 线索化左子树
        threadedNodes(node.left);

        // 线索化当前节点左指针指向前驱节点
        if (node.left == null) {
            // 左指针指向前驱节点
            node.left = pre;
            // 修改当前节点指针类型为前驱
            node.leftType = 1;
        }

        // 处理后继节点 此时pre 指向的是前一个节点
        if (pre != null && pre.right == null) {
            // 前驱节点的指针指向当前节点
            pre.right = node;
            // 修改前驱节点的右指针类型
            pre.rightType = 1;
        }

        // 每处理一个节点之后，让当前节点是下一个节点的前驱
        pre = node;

        // 线索化右子树
        threadedNodes(node.right);


    }
}

class HeroNode {
    public int no;

    public String name;

    public HeroNode left;

    public HeroNode right;

    // 为0 表示指向 左子节点 为1表示指向前驱节点
    public int leftType;

    // 为0 表示指向 左子节点 为1表示指向后继节点
    public int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    // 中序遍历
    public void infixOrder() {

        // 向左递归遍历
        if (this.left != null) {
            this.left.infixOrder();
        }

        // 先输出父节点
        System.out.println(this);

        // 向右递归遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
