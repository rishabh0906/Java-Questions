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


// segregate even and odd nodes                      CareFull when joining  odd and even linked lists


    public void oddEven(Node head)
{
    if(this.head==null || this.head.next==null)
    {
       return head;
    }

    Node odd= new Node(-1);
    Node op=odd;
    Node even= new Node(-1);
    Node ep=even;
    Node curr=this.head;
    while(curr!=null)
    {
        if(curr.val%2==0)
        {
            ep.next=curr;
            ep=ep.next;
        }
        else{
            op.next=curr;
            op=op.next;
        }
        curr=curr.next;
    }

    op.next=even.next;
    ep.next=null;

    this.head=odd.next;

    if(even.next!=null)
    {
        this.tail=ep;
    }
    else{
        this.tail=op;
    }

}

// Remove duplicates from sorted Linked List

public Node distinctElement(Node head)
{

if(head==null||head.next==null)
{
    return head;
}

Node dummy =new Node(-1);
Node tail=dummy;
Node curr=head;
Node prev=null;
while(curr!=null)
{
    if(curr.val!=tail.val)
    {
        prev.next=null;
        tail.next=curr;
        tail=tail.next;
    }
    prev=curr;
    curr=curr.next;
}

tail.next=null;

return dummy.next;

}

// Reverse Linked List

  public void reverseLL(ListNode head)
  {
 if(head==null||head.next==null)
        {
            return head;
        }
        
        ListNode curr=head;
        ListNode prev=null;
        
        while(curr!=null)
        {
            ListNode fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
        }
        
        return prev;
  }

}