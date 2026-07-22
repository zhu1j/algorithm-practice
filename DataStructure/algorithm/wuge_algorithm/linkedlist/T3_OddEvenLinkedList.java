package wuge_algorithm.linkedlist;

import java.util.List;

public class T3_OddEvenLinkedList {
    public static void main(String[] args) {
        // 构建链表：2 -> 1 -> 3 -> 4 -> 6 -> 9
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(9);

        ListNode result = oddEvenList(head);

        // 遍历打印结果
        ListNode cur = result;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        // 预期输出：2 3 6 1 4 9
    }

    public static ListNode oddEvenList(ListNode head) {

    if (head == null || head.next == null){
        return head;
    }
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;

    while (even != null && even.next != null){
        odd.next = even.next;
        odd = odd.next;

        even.next = odd.next;
        even = even.next;
    }
    odd.next = evenHead;
    return head;
    }
}
