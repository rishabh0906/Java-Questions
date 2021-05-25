import java.util.*;

public class questions{


* public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; 
      }

// middle of a Singly linked list

 public ListNode middleNode(ListNode head) {
        
        if(head==null||head.next==null)
        {
            return head;
        }
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
        
        
    }
// remove nth node from end
     public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head==null||head.next==null)
        {
            return null;
        }
        
        
        ListNode slow=head,fast=head;
        
        while(n-->0)
        {
            fast=fast.next;
        }
        if(fast==null)
        {
            return head.next;
        }
        
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        
        slow.next=slow.next.next;
    
        
        return head;
        
    }

}