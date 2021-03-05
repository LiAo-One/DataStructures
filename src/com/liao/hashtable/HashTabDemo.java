package com.liao.hashtable;

/**
 * <p>
 * 使用HashTab 管理员工
 * </p>
 *
 * @author LiAo
 * @since 2021/3/4
 */
public class HashTabDemo {

    public static void main(String[] args) {
        Emp emp1 = new Emp(1, "LiAo1");
        Emp emp2 = new Emp(2, "LiAo2");
        Emp emp8 = new Emp(8, "钢铁侠");

        HashTab hashTab = new HashTab(10);

        hashTab.add(emp1);
        hashTab.add(emp2);
        hashTab.add(emp8);

        hashTab.list();

        hashTab.delEmpById(8);

        hashTab.list();
    }
}

/**
 * 用于管理链表
 */
class HashTab {

    private final EmpLinkedList[] linkedLists;

    private final int size;

    // 构建数组
    public HashTab(int size) {
        this.size = size;
        linkedLists = new EmpLinkedList[size];

        for (int i = 0; i < size; i++) {
            linkedLists[i] = new EmpLinkedList();
        }
    }

    // 添加
    public void add(Emp emp) {
        // 获取链表下标
        int index = hashFun(emp.id);
        // 指定下标下添加员工
        linkedLists[index].add(emp);
    }

    // 根据员工id计算应该在那一条链表
    public int hashFun(int id) {
        return id % size;
    }

    // 遍历所有链表
    public void list() {
        for (EmpLinkedList linkedList : linkedLists) {
            linkedList.list();
        }
    }

    // 查询链表
    public Emp findEmpById(int id) {
        // 该id存储的下标
        int index = hashFun(id);

        // 执行删除
        return linkedLists[index].findEmpById(id);
    }

    // 删除元素
    public void delEmpById(int id) {
        // 该id存储的下标
        int index = hashFun(id);

        // 执行删除
        linkedLists[index].delEmpById(id);
    }
}


class Emp {

    public int id;

    public String name;

    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {

    // 不可为静态 否则只会创建一次 所有的都是同一个head
    private final Emp head = new Emp(0, "");

    // 添加进链表的底部
    public void add(Emp emp) {

        Emp temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = emp;
    }

    // 遍历链表
    public void list() {

        Emp temp = head.next;

        if (temp == null) {
            System.out.println("为空");
            return;
        }

        while (temp != null) {
            System.out.println(temp.id + "===>" + temp.name);
            temp = temp.next;
        }
    }

    // 根据id查询
    public Emp findEmpById(int id) {

        Emp temp = head.next;

        while (temp != null) {
            if (temp.id == id) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    // 根据id删除
    public void delEmpById(int id) {

        Emp temp = head;

        while (temp.next != null) {
            if (temp.next.id == id) {
                temp.next = temp.next.next;
                break;
            }
        }
    }
}