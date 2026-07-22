package wuge_algorithm.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next; }

    // 打印链表工具方法
    public static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val);
            if (p.next != null) {
                System.out.print(" -> ");
            }
            p = p.next;
        }
        System.out.println();
    }
}
