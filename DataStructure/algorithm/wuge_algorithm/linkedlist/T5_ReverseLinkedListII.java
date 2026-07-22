package wuge_algorithm.linkedlist;

public class T5_ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int left, int right){

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        // 从虚拟头节点出发，pre 走 left - 1 步找到需要翻转的左区间
        // for 循环结束后，pre 的右节点是需要翻转的节点
        // for 循环结束后，cur 指向的就是需要翻转的节点
        for (int i =0;i < left -1;i++){
            pre = pre.next;
            cur = cur.next;
        }
        for (int i = 0;i < right - left;i++) {
            ListNode temp =  cur.next;
            cur.next = cur.next.next;

            temp.next = pre.next;
            pre.next = temp;
        }
        return head;
    }
}
