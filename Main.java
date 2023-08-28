//876. 链表的中间结点
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        ListNode list = middleNode(l1);
        System.out.println(list.val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void add(int newval) {
            ListNode newNode = new ListNode(newval);
            if (this.next == null)
                this.next = newNode;
            else
                this.next.add(newval);
        }
    }

    public static ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }
}