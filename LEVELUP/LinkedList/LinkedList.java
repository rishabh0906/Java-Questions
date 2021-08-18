import java.util.*;

public class LinkedList {

    public static class ListNode {

        int val = 0;
        ListNode next = null;
        ListNode random=null;

        ListNode(int val) {

            this.val = val;
        }

    }

    public static ListNode midNode(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static ListNode UnFold(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode d1 = new ListNode(-1), d2 = new ListNode(-1);
        ListNode c1 = d1, c2 = d2;
        ListNode c = head;
        while (c != null) {
            c1.next = c;
            c2 = c1.next;
            c1 = c1.next;
            c2 = c2.next;
            c = c.next;
            if (c != null)
                c = c.next;
        }
        c1.next = null;
        ListNode rhead = reverse(d2.next);
        c1.next = rhead;

        return d1.next;

    }

    public static ListNode Segregate(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode even = new ListNode(-1), odd = new ListNode(-1), ep = even, op = odd, curr = head;

        while (curr != null) {
            if ((curr.val & 1) == 0) {
                ep.next = curr;
                ep = ep.next;
            } else {
                op.next = curr;
                op = op.next;
            }

            curr = curr.next;
        }

        ep.next = op.next = null;
        ep.next = odd.next;

        return even.next;
    }

    public static ListNode segregate012(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode zero = new ListNode(-1), one = new ListNode(-1), zp = zero, op = one, two = new ListNode(-1), tp = two,
                curr = head;

        while (curr != null) {
            if (curr.val == 0) {
                zp.next = curr;
                zp = zp.next;
            } else if (curr.val == 1) {
                op.next = curr;
                op = op.next;
            } else {
                tp.next = curr;
                tp = tp.next;
            }

            curr = curr.next;
        }

        zp.next = op.next = tp.next = null;
        op.next = two.next;
        zp.next = one.next;

        return zero.next;
    }

    public static ListNode MergeTwoSorted(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode curr1 = head1;
        ListNode curr2 = head2;
        ListNode newHead = null;
        ListNode tail = newHead;
        while (curr1 != null && curr2 != null) {

            ListNode node;
            if (curr1.val < curr2.val) {
                node = curr1;
                curr1 = curr1.next;
            } else {
                node = curr2;
                curr2 = curr2.next;

            }

            if (newHead == null) {
                newHead = tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }

        if (curr1 != null) {
            tail.next = curr1;
        }
        if (curr2 != null) {
            tail.next = curr2;
        }

        return newHead;
    }

    public static ListNode MergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = midNode(head);
        ListNode rhead = mid.next;
        mid.next = null;
        ListNode left = MergeSort(head);
        ListNode right = MergeSort(rhead);
        ListNode newHead = MergeTwoSorted(left, right);

        return newHead;
    }

    public static ListNode MergeKSorted(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        ListNode newhead = null;
        ListNode tail = newhead;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.add(lists[i]);
        }
        while (pq.size() > 0) {

            ListNode node = pq.remove();
            if (newhead == null)
                newhead = tail = node;
            else {
                tail.next = node;
                tail = tail.next;
            }
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return newhead;

    }

    public static ListNode MergeKSorted(ListNode[] lists, int l, int r) {

        if (l > r) {
            return null;
        }
        if (l == r) {
            return lists[l];
        }

        int mid = (r - l) / 2 + l;
        ListNode left = MergeKSorted(lists, l, mid);
        ListNode right = MergeKSorted(lists, mid + 1, r);

        return MergeTwoSorted(left, right);

    }

    public static ListNode MergeKSorted_01(ListNode[] lists) {

        return MergeKSorted(lists, 0, lists.length - 1);

    }

    public static ListNode reverseInRange(ListNode head, int s, int e) {
        if (head == null || head.next == null)
            return head;

        s--;
        e--;
        ListNode prev = null, curr = head;
        while (s-- > 0 && curr != null) {
            e--;
            prev = curr;
            curr = curr.next;
        }
        ListNode lastNode = curr;

        ListNode next = null;
        ListNode rprev = null;
        while (e-- >= 0 && curr != null) {
            next = curr.next;
            curr.next = rprev;
            rprev = curr;
            curr = next;
        }
        if (prev != null) {
            prev.next = rprev;
        } else {
            head = rprev;
        }
        if (curr != null) {
            lastNode.next = curr;
        }

        return head;

    }

    public static int length(ListNode head) {

        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    static ListNode th = null, tt = null;

    public static void addFirst(ListNode node) {
        if (th == null) {
            th = tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public static ListNode reverseKgroups(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oh = null, ot = null;
        ListNode curr = head;
        int len = length(head);
        while (len >= k) {

            int tempk = k;
            while (tempk-- > 0) {
                ListNode next = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = next;
            }

            if (oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }
            tt = th = null;

        }
        return oh;

    }

    public static ListNode removeDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = null;
            if (curr.val != tail.val) {
                tail.next = curr;
                tail = tail.next;
            }
            curr = next;
        }

        return dummy.next;
    }

    public static ListNode AddtwoLL(ListNode head1, ListNode head2) {

        head1 = reverse(head1);
        head2 = reverse(head2);

        int carry = 0;
        ListNode newHead = null;
        ListNode tail = newHead;
        ListNode curr1 = head1, curr2 = head2;
        while (curr1 != null && curr2 != null) {

            int sum = (curr1.val + curr2.val + carry);
            carry = sum / 10;
            if (newHead == null) {
                newHead = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;

        }

        while (curr1 != null) {

            int sum = (curr1.val + carry);
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int sum = (curr2.val + carry);
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            curr2 = curr2.next;
        }

        if (carry == 1) {
            tail.next = new ListNode(1);
        }

        newHead = reverse(newHead);
        return newHead;

    }

    public static boolean Comparator(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 > len2)
            return true;
        else if (len2 > len1)
            return false;

        ListNode curr = l1;
        while (curr != null) {

            if (curr.val > l2.val) {
                return true;
            } else if (curr.val < l2.val) {
                return false;
            }
            curr = curr.next;
            l2 = l2.next;
        }

        return true;
    }

    public static ListNode SubtractTwoLL(ListNode head1, ListNode head2) {

        if (Comparator(head1, head2) == false) {
            return SubtractTwoLL(head2, head1);
        }
        head1 = reverse(head1);
        head2 = reverse(head2);

        int borrow = 0;
        ListNode newHead = null;
        ListNode tail = newHead;
        ListNode curr1 = head1, curr2 = head2;

        while (curr1 != null && curr2 != null) {

            int diff = (borrow + curr1.val - curr2.val);

            if (diff < 0) {
                borrow = -1;
                diff += 10;
            } else {
                borrow = 0;
            }
            if (newHead == null) {
                newHead = tail = new ListNode(diff);
            } else {
                tail.next = new ListNode(diff);
                tail = tail.next;
            }

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {

            int diff = (curr1.val + borrow);

            if (diff < 0) {
                borrow = -1;
                diff += 10;
            } else {
                borrow = 0;
            }

            tail.next = new ListNode(diff);
            tail = tail.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int diff = (curr2.val + borrow);
            if (diff < 0) {
                borrow = -1;
                diff += 10;
            } else {
                borrow = 0;
            }
            tail.next = new ListNode(diff);
            tail = tail.next;
            curr2 = curr2.next;
        }

        newHead = reverse(newHead);

        ListNode curr = newHead;
        while (curr != null && curr.val == 0) {
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        if (curr == null) {

            return new ListNode(0);
        }

        return curr;

    }

    public static ListNode MultiplyDigitWithList(ListNode l1, int val) {

        int carry = 0;
        ListNode newHead = null;
        ListNode tail = newHead;
        ListNode curr = l1;
        while (curr != null) {
            int multiply = (curr.val * val + carry);
            carry = multiply / 10;
            if (newHead == null) {
                newHead = tail = new ListNode(multiply % 10);
            } else {
                tail.next = new ListNode(multiply % 10);
                tail = tail.next;
            }
            curr = curr.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }

        return newHead;

    }

    public static ListNode AddTwoLL(ListNode head1, ListNode head2) {

        int carry = 0;
        ListNode newHead = null;
        ListNode tail = newHead;
        ListNode curr1 = head1, curr2 = head2;
        while (curr1 != null && curr2 != null) {

            int sum = (curr1.val + curr2.val + carry);
            carry = sum / 10;
            if (newHead == null) {
                newHead = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;

        }

        while (curr1 != null) {

            int sum = (curr1.val + carry);
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int sum = (curr2.val + carry);
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            curr2 = curr2.next;
        }

        if (carry == 1) {
            tail.next = new ListNode(1);
        }

        return newHead;

    }

    public static ListNode MultiplyTwoLL(ListNode l1, ListNode l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode previntermediateList = null;
        int countZeroes = 0;
        while (l1 != null) {

            ListNode intermediateList = MultiplyDigitWithList(l2, l1.val);

            int val = countZeroes;
            while (val-- > 0) {
                ListNode node = new ListNode(0);
                node.next = intermediateList;
                intermediateList = node;
            }
            if (previntermediateList == null) {
                previntermediateList = intermediateList;
            } else {
                previntermediateList = AddTwoLL(intermediateList, previntermediateList);

            }
            countZeroes++;
            l1 = l1.next;

        }

        return reverse(previntermediateList);
    }
    public static ListNode AttachCloneNodes(ListNode head){
       
        ListNode curr=head;

        while(curr!=null){

            ListNode clone =new ListNode(curr.val);
            ListNode next=curr.next;
            curr.next=clone;
            clone.next=next;
            curr=next;
        }

        return head;
      

    }

    public static ListNode DetachCloneNodes(ListNode head){
           
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode curr=head;
        while(curr!=null){
            ListNode clone=curr.next;
            ListNode next=clone.next;
            clone.next=null;
            prev.next=clone;
            prev=prev.next;
            curr=next;
        }
        return dummy.next;
    }
    public static ListNode CloneListWithRandomPointers(ListNode head){
           if(head==null) return null;

           head=AttachCloneNodes(head);

           ListNode curr=head;
           while(curr!=null){
                 if(curr.random!=null)
                  curr.next.random=curr.random.next;
            curr=curr.next.next;
           }

           ListNode newHead=DetachCloneNodes(head);

           return newHead;

    }
}