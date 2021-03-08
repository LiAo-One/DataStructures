package com.liao.tree;

/**
 * <p>
 * 二叉树
 * </p>
 *
 * @author LiAo
 * @since 2021/3/8
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        // 创建一个二叉树
        BinaryTree binaryTree = new BinaryTree();

        // 创建各自节点
        HeroNode root = new HeroNode(1, "宋江1");
        HeroNode heroNode2 = new HeroNode(2, "宋江2");
        HeroNode heroNode3 = new HeroNode(3, "宋江3");
        HeroNode heroNode4 = new HeroNode(4, "宋江4");
        HeroNode heroNode5 = new HeroNode(5, "宋江5");

        // 根节点赋值给二叉树
        binaryTree.setRoot(root);
        root.left = heroNode2;
        root.right = heroNode3;
        heroNode3.right = heroNode4;
        heroNode3.left = heroNode5;

        System.out.println("前序遍历测试====>");// 12354
        binaryTree.preOrder();

        System.out.println("中序遍历测试====>");// 21534
        binaryTree.infixOrder();

        System.out.println("后序遍历测试====>");// 25431
        binaryTree.postOrder();

        System.out.println("前序查找测试====>");
        System.out.println(binaryTree.preOrderSearch(5));

        System.out.println("中序查找测试====>");
        System.out.println(binaryTree.infixOrderSearch(2));

        System.out.println("后序查找测试====>");
        System.out.println(binaryTree.postOrderSearch(5));

        System.out.println("执行删除====>");
        binaryTree.delNode(5);

        System.out.println("删除后遍历====>");
        binaryTree.preOrder();
    }
}

// 二叉树
class BinaryTree {

    // 根节点
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 节点删除
    public void delNode(int no) {
        if (this.root != null) {
            if (this.root.no == no) {
                this.root = null;
            } else {
                this.root.delNode(no);
            }
        }
    }


    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    // 后遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    // 前置遍历查找
    public HeroNode preOrderSearch(int no) {

        // 用于存储被查找的节点
        HeroNode resNode = null;

        if (this.root != null) {
            return this.root.preOrderSearch(no);
        }

        return null;
    }

    // 中置遍历查找
    public HeroNode infixOrderSearch(int no) {

        // 用于存储被查找的节点
        HeroNode resNode = null;

        if (this.root != null) {
            resNode = this.root.infixOrderSearch(no);
        }

        return resNode;
    }

    // 后置遍历查找
    public HeroNode postOrderSearch(int no) {

        // 用于存储被查找的节点
        HeroNode resNode = null;

        if (this.root != null) {
            resNode = this.root.postOrderSearch(no);
        }

        return resNode;
    }

}

// 定义节点
class HeroNode {

    public int no;

    public String name;

    public HeroNode left;

    public HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HeroNode{");
        sb.append("no=").append(no);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    // 节点删除
    public void delNode(int no) {

        // 删除左边
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        // 删除右边
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        // 向左递归
        if (this.left != null) {
            this.left.delNode(no);
        }

        // 向右递归
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    // 前序遍历
    public void preOrder() {

        // 先输出父节点
        System.out.println(this);
        // 向左递归遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 向右递归遍历
        if (this.right != null) {
            this.right.preOrder();
        }

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

    // 后遍历
    public void postOrder() {

        // 向左递归遍历
        if (this.left != null) {
            this.left.postOrder();
        }

        // 向右递归遍历
        if (this.right != null) {
            this.right.postOrder();
        }

        // 先输出父节点
        System.out.println(this);
    }

    // 前置遍历查找
    public HeroNode preOrderSearch(int no) {

        // 存储被查找的节点
        HeroNode resNode = null;

        // 比较当前节点是否为要查找的
        if (this.no == no) {
            return this;
        }

        // 判断当前节点的左节点是否为空 不为空则进行递归遍历
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }

        // 左递归之后判断不为空就返回 否则 右递归就会把结果覆盖
        if (resNode != null) {
            return resNode;
        }

        // 判断当前节点的右节点是否为空 不为空则进行递归遍历
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;
    }

    // 中置遍历查找
    public HeroNode infixOrderSearch(int no) {

        // 用于存储被查找的节点
        HeroNode resNode = null;

        // 判断当前节点的左节点是否为空 不为空则进行递归遍历
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }

        // 左递归之后判断不为空就返回 否则 右递归就会把结果覆盖
        if (resNode != null) {
            return resNode;
        }

        // 比较当前节点是否为要查找的
        if (this.no == no) {
            return this;
        }

        // 判断当前节点的右节点是否为空 不为空则进行递归遍历
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;
    }

    // 后置遍历查找
    public HeroNode postOrderSearch(int no) {

        // 用于存储被查找的节点
        HeroNode resNode = null;

        // 判断当前节点的左节点是否为空 不为空则进行递归遍历
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }

        // 左递归之后判断不为空就返回 否则 右递归就会把结果覆盖
        if (resNode != null) {
            return resNode;
        }

        // 判断当前节点的右节点是否为空 不为空则进行递归遍历
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }

        // 比较当前节点是否为要查找的
        if (this.no == no) {
            return this;
        }

        return resNode;
    }
}
