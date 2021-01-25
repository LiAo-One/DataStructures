package com.liao.linkedelist;

/**
 * <p>
 * 双向链表
 * </p>
 *
 * @author LiAo
 * @since 2021/1/16
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();

        DoubleHeroNode heroNode1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode heroNode2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode heroNode3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode heroNode4 = new DoubleHeroNode(4, "公孙胜", "入云龙");

        System.out.println("执行添加======>");

        linkedList.addByOrder(heroNode2);
        linkedList.addByOrder(heroNode1);
        linkedList.addByOrder(heroNode4);
        linkedList.addByOrder(heroNode3);

        System.out.println("遍历节点======>");

        linkedList.list();

       /* System.out.println("执行删除======>");

        linkedList.del(4);*/

        System.out.println("遍历节点======>");

        linkedList.list();

        System.out.println("执行修改");

        DoubleHeroNode heroNode5 = new DoubleHeroNode(3, "林冲", "豹子头");
        linkedList.upd(heroNode5);

        System.out.println("遍历节点======>");

        linkedList.list();
    }
}

class DoubleLinkedList {
    // 头节点
    private final DoubleHeroNode heroNode = new DoubleHeroNode(0, "", "");

    public DoubleHeroNode getHeroNode() {
        return heroNode;
    }

    // 添加节点
    public void add(DoubleHeroNode heroNode) {
        DoubleHeroNode temp = getHeroNode();

        while (temp.next != null) {
            temp = temp.next;
        }

        /*heroNode.next = temp.next;*/
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 遍历节点
    public void list() {

        DoubleHeroNode temp = getHeroNode().next;

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 修改
    public void upd(DoubleHeroNode heroNode) {
        // 获取头部节点
        DoubleHeroNode temp = getHeroNode().next;
        // 当前节点不为空 则遍历节点
        while (temp != null) {
            // 当前节点的字节点符合
            if (temp.no == heroNode.no) {
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
                // 跳出循环
                break;
            }
            // 节点后移
            temp = temp.next;
        }
    }

    // 删除
    public void del(int on) {
        // 获取头部节点
        DoubleHeroNode temp = getHeroNode().next;
        // 当前节点不为空 则遍历节点
        while (temp != null) {
            // 删除的情况为当前节点
            if (temp.no == on) {
                // 当前节点的上一个节点的next 指向当前节点的下一个节点
                temp.pre.next = temp.next;
                // 判断是否为最后一个节点 如果为最后一个节点、、
                // 就不需要将当前节点的下一个节点的pre 指向当前节点的上一个节点
                if (temp.next != null){
                    // 当前节点的下一个节点的pre 指向当前节点的上一个节点
                    temp.next.pre = temp.pre;
                }
                // 跳出循环
                return;
            }
            // 节点后移
            temp = temp.next;
        }
    }

    // 根据好汉的排名添加节点
    public void addByOrder(DoubleHeroNode heroNode) {
        // 辅助节点获取头部节点
        DoubleHeroNode temp = getHeroNode();
        // 默认false 即默认新添加的节点在链表不存在
        boolean flag = false;
        // 遍历列表
        while (temp.next != null) {
            // 如果新添加的节点编号大于当前节点的子节点的编号 则返回
            if (temp.next.no > heroNode.no) {
                // 此时说明 新节点的编号位于 temp与下一个节点之间
                // 退出循环
                break;
            } else if (temp.next.no == heroNode.no) {
                // 修改flag状态 新添加的节点编号已存在
                flag = true;
                // 退出循环
                break;
            }
            // 节点后移 作为下一次判断条件
            temp = temp.next;
        }

        // 节点已存在
        if (flag) {
            System.out.println("该节点已存在" + heroNode.no);
        } else {
            // 判断当前节点是否为最后一个节点
            if (temp.next != null){
                // 不是最后一个节点 将当前节点的下一个节点的pre指向新节点
                temp.next.pre = heroNode;
            }
            // 新节点的子节点指向 当前节点的子节点
            heroNode.next = temp.next;
            // 当前节点的子节点指向新节点
            temp.next = heroNode;
            // 新节点的父节点指向当前节点
            heroNode.pre = temp;
        }
    }
}

/**
 * <p>
 * 模拟双向链表
 * </p>
 *
 * @author LiAo
 * @since 2021/1/15
 */
class DoubleHeroNode {

    // 好汉编号
    public int no;
    // 姓名
    public String name;
    // 昵称
    public String nickName;
    // 下一个节点
    public DoubleHeroNode next;
    // 上一个节点
    public DoubleHeroNode pre;

    public DoubleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DoubleHeroNode{");
        sb.append("no=").append(no);
        sb.append(", name='").append(name).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
