package com.liao.linkedelist;

import java.util.Stack;

/**
 * <p>
 * 单链表
 * </p>
 *
 * @author LiAo
 * @since 2021/1/15
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "公孙胜", "入云龙");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.list(singleLinkedList.getHead());

        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);

        singleLinkedList.list(singleLinkedList.getHead());

        System.out.println("执行删除");

        /*singleLinkedList.del(4);*/

        singleLinkedList.list(singleLinkedList.getHead());

        System.out.println("执行修改");

        HeroNode heroNode5 = new HeroNode(3, "林冲", "豹子头");

        singleLinkedList.upd(heroNode5);

        singleLinkedList.list(singleLinkedList.getHead());

        System.out.println("执行查询");

        singleLinkedList.sel(3);

        System.out.println("有效节点为：====>" + singleLinkedList.getLength(singleLinkedList.getHead()));

        System.out.println("倒数第1个有效节点为：====>" + singleLinkedList.findLastIndexNode(singleLinkedList.getHead(), 1));

        singleLinkedList.reverseHeroNode(singleLinkedList.getHead());

        System.out.println("反转后的链表为====>");

        singleLinkedList.list(singleLinkedList.getHead());

        System.out.println("反向打印的数据为=====>");

        singleLinkedList.reversePrinting(singleLinkedList.getHead());


    }
}


/**
 * <p>
 * 管理好汉
 * </p>
 *
 * @author LiAo
 * @since 2021/1/15
 */
class SingleLinkedList {

    // 头结点
    private final HeroNode head = new HeroNode(0, "", "");

    // 返回头结点
    public HeroNode getHead() {
        return head;
    }

    // 添加节点
    public void add(HeroNode heroNode) {
        // 辅助节点 从头结点开始
        HeroNode temp = head;

        // 如果该节点的.next不为空 表明该节点不是最后一个
        while (temp.next != null) {
            // 如果没有找到最后 next后移
            // 判断的前一个节点的 next 赋值给辅助节点 作为下一次循环的判断条件 节点后移
            temp = temp.next;
        }
        // 退出循环 将节点加入到最后一个节点
        temp.next = heroNode;
    }

    // 根据好汉的排名添加节点
    public void addByOrder(HeroNode heroNode) {
        // 辅助节点获取头部节点
        HeroNode temp = head;
        // 默认false 即默认新添加的节点在链表不存在
        boolean flag = false;
        // 遍历列表
        while (temp.next != null) {
            // 如果新添加的节点编号大于当前节点编号 则返回
            if (temp.next.no > heroNode.no) {
                // 此时说明 新节点的编号位于 temp 与 temp.next之间
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
            // 新节点的子节点为第一个大于的新节点的子节点
            heroNode.next = temp.next;
            // 第一个大于该节点的子节点设置为 更新过后的新节点
            temp.next = heroNode;
        }
    }

    // 删除
    public void del(int on) {
        // 获取头部节点
        HeroNode temp = head;
        // 当前节点不为空 则遍历节点
        while (temp.next != null) {

            // 删除的情况为中间节点
            // 当前节点的字节点符合
            if (temp.next.no == on) {
                // 则当前节点的子节点的子节点 赋值给当前节点子节点
                // 被删除的节点没有其他的引用 被垃圾回收删除 达到删除
                temp.next = temp.next.next;
                // 跳出循环
                break;
            }

            // 节点后移
            temp = temp.next;
        }
    }

    // 查询
    public void sel(int on) {
        // 获取头部节点
        HeroNode temp = head;
        // 当前节点不为空 则遍历节点
        while (temp.next != null) {

            // 当前节点的字节点符合
            if (temp.next.no == on) {
                System.out.println(temp.next);
                // 跳出循环
                break;
            }
            // 节点后移
            temp = temp.next;
        }
    }

    // 修改
    public void upd(HeroNode heroNode) {
        // 获取头部节点
        HeroNode temp = head;
        // 当前节点不为空 则遍历节点
        while (temp.next != null) {
            // 当前节点的字节点符合
            if (temp.next.no == heroNode.no) {
                temp.next.name = heroNode.name;
                temp.next.nickName = heroNode.nickName;
                // 跳出循环
                break;
            }
            // 节点后移
            temp = temp.next;
        }
    }

    // 遍历节点 并统计有效个数
    public void list(HeroNode head) {
        // 判断头部节点是否为空 为空返回
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 创建辅助节点 从头部节点开始
        HeroNode temp = head.next;

        // 以节点的 temp 作为判断条件 不为空则打印
        while (temp != null) {
            // 不为空则打印
            System.out.println(temp);
            // 将判断不为空的节点的next赋值给辅助节点 作为下一次while判断的条件 节点后移
            temp = temp.next;
        }
    }

    /**
     * 遍历有效节点个数
     *
     * @param head 头结点
     * @return 长度
     */
    public int getLength(HeroNode head) {
        // 链表为空直接返回
        if (head.next == null) {
            return 0;
        }

        // 获取头结点
        HeroNode temp = head.next;
        // 计数
        int i = 0;
        // 遍历节点
        while (temp != null) {
            // 个数加一
            i++;
            // 节点后移
            temp = temp.next;
        }
        // 返回有效个数
        return i;
    }

    /**
     * 遍历单向节点倒数第K个节点
     *
     * @param head  节点头
     * @param index k
     * @return 倒数第k个节点
     */
    public HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            System.out.println("节点为空");
            return null;
        }
        int k = getLength(head) - index;
        HeroNode temp = head.next;

        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }

        return temp;
    }

    /**
     * 反转链表
     *
     * @param head 要反转的链表
     * @return 反转后的链表
     */
    public void reverseHeroNode(HeroNode head) {

        if (head.next == null || head.next.next == null) {
            System.out.println("只有一个节点或者为空");
        }
        // 辅助节点
        HeroNode temp = head.next;
        // 指向当前节点的下一个节点
        HeroNode next = null;
        // 新建一个节点存放反转的节点
        HeroNode revers = new HeroNode(0, "", "");
        // 遍历节点
        while (temp != null) {
            // 保存当前遍历到的节点及子节点
            next = temp.next;
            // 当前节点的子节点为反转节点的子节点
            temp.next = revers.next;
            // 反转的节点的子节点为已经赋值的当前节点
            revers.next = temp;
            // 后移节点
            temp = next;
        }
        head.next = revers.next;
    }

    // 反向打印链表
    public void reversePrinting(HeroNode head) {

        // 定义一个先进后出的栈

        Stack<HeroNode> stack = new Stack<>();
        // 引用要遍历的链表
        HeroNode temp = head.next;
        // 遍历链表
        while (temp != null) {
            // 加入栈中
            stack.add(temp);
            // 后移节点
            temp = temp.next;
        }

        // 遍历栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

}

/**
 * <p>
 * 模拟单链表
 * </p>
 *
 * @author LiAo
 * @since 2021/1/15
 */
class HeroNode {

    // 好汉编号
    public int no;
    // 姓名
    public String name;
    // 昵称
    public String nickName;
    // 下一个节点
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HeroNode{");
        sb.append("no=").append(no);
        sb.append(", name='").append(name).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        /*sb.append(", next=").append(next);*/
        sb.append('}');
        return sb.toString();
    }
}
