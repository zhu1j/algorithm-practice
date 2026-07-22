package wuge_algorithm.linkedlist;

public class T1_RemoveElements {
    // 测试入口
    public static void main(String[] args) {
        // 构建链表：1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        // 删除值为6的节点
        ListNode newHead = removeElements(head, 6);

        // 遍历打印结果
        ListNode p = newHead;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        // 预期输出：1 2 3 4 5
    }

    public static ListNode removeElements(ListNode head, int val) {

    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode cur = head;

    while (cur != null){
        if (cur.val == val){
            pre.next = cur.next;
        }else {
            pre = pre.next;
        }
        cur = cur.next;
    }
    return dummy.next;
    }
}
