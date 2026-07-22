package wuge_algorithm.linkedlist;

import static wuge_algorithm.linkedlist.ListNode.printList;

public class T4_ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null){
        return head;
    }
    ListNode cur = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return cur;
    }

    public static void main(String[] args) {

        // 构造链表：1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("原链表：");
        printList(head);

        ListNode newHead = reverseList(head);
        System.out.println("反转后链表：");
        printList(newHead);

        // 额外测试边界用例：空链表、单节点链表
        System.out.println("\n=====边界测试=====");
        // 空链表
        ListNode emptyNode = null;
        printList(reverseList(emptyNode));

        // 单个节点
        ListNode singleNode = new ListNode(99);
        printList(reverseList(singleNode));
    }
}
