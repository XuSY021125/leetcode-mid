//21. 合并两个有序链表
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode p1,p2;
        p1 = l1;
        p2 = l2;
        for (int i = 1; i < 10; i++) {
            if (i%2==0) {
                ListNode node1 = new ListNode(i);
                p1.next = node1;
                p1 = p1.next;
            }else {
                ListNode node2 = new ListNode(i);
                p2.next = node2;
                p2 = p2.next;
            }
        }
        ListNode nlist = mergeTwoLists(l1,l2);
        while (nlist != null) {
            System.out.println(nlist.val);
            nlist = nlist.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {

            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }
}