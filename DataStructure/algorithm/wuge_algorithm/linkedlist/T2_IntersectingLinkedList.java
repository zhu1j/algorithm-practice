package wuge_algorithm.linkedlist;

/**
 * 给两个单链表的头节点 headA 和 headB ，找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null.
 *
 *  测试：
 *      A链表：4 1 8 4 5   B链表：5 0 1 8 4 5
 */
public class T2_IntersectingLinkedList {
    public static void main(String[] args) {
        // 先构造公共相交部分：8 -> 4 -> 5
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // 链表A：4 -> 1 -> common(8,4,5)
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // 链表B：5 -> 0 -> 1 -> common(8,4,5)
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        // 调用方法
        ListNode intersectNode = getIntersectionNode(headA, headB);
        if (intersectNode != null) {
            System.out.println("相交节点的值 = " + intersectNode.val);
        } else {
            System.out.println("无相交节点(null)");
        }
        // 预期输出：相交节点的值 = 8
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    if (headA == null || headB == null){
        return null;
    }

    ListNode pointA = headA;
    ListNode pointB = headB;

    while (pointA != pointB) {
        if (pointA == null) {
            pointA = headB;
        } else {
            pointA = pointA.next;
        }
        if (pointB == null){
            pointB = headA;
        } else {
            pointB = pointB.next;
        }
    }
    return pointA;
    }
}
