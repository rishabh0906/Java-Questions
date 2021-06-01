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
/// add two no. 

  public ListNode AddTwo(ListNode head1,ListNode head2)
  {
      if(head1==null)
      {
          return head2;
      }
      if(head2==null)
      {
          return head1;
      }

      head1=reverseLL(head1);
      head2=reverseLL(head2);
      int carry=0;
      ListNode curr1=head1;
      ListNode curr2=head2;
      ListNode newHead=null;
      ListNode tail=newHead;
      while(curr1!=null&&curr2!=null)
      {
          int sum=curr1.val+curr2.val+carry;
          carry=sum/10;
          if(newHead==null)
          {
              newHead=new ListNode(sum%10);
              tail=newHead;
          }
          else{
              tail.next=new ListNode(sum%10);
              tail=tail.next;
          }
          curr1=curr1.next;
          curr2=curr2.next;
      }
      while(curr1!=null)
      {
          int sum=curr1.val+carry;
          carry=sum/10;
          tail.next=new ListNode(sum%10);
          tail=tail.next;
          curr1=curr1.next;
      }
       while(curr2!=null)
      {
          int sum=curr2.val+carry;
          carry=sum/10;
          tail.next=new ListNode(sum%10);
          tail=tail.next;
          curr2=curr2.next;
      }
      if(carry==1)
      {
          tail.next=new ListNode(1);
      }

        newHead=reverseLL(newHead);

        return newHead;

  }

///  reordering 
  public ListNode reverseLL(ListNode head)
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            
        }
        return prev;
    }
    



    public void reorderList(ListNode head) {
        
        if(head==null||head.next==null)
        {
            return ;
        }
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode GreaterNode= slow.next;
        slow.next=null;
        
        GreaterNode=reverseLL(GreaterNode);
        
        ListNode curr1=head;
        ListNode curr2= GreaterNode;
        
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        
        while(curr1!=null&&curr2!=null)
        {
            ListNode next1=curr1.next;
            tail.next=curr1;
            curr1=next1;
            tail=tail.next;
            ListNode next2=curr2.next;
            tail.next=curr2;
            curr2=next2;
            tail=tail.next;
        }
        if(curr1!=null)
        {
            tail.next=curr1;
        }
        if(curr2!=null)
        {
            tail.next=curr2;
        }
        
        head=dummy.next;
        
        
        
    }


/// Merge Two Sorted list

      public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        
        if(l1==null)
        {
            return l2;
        }
        if(l2==null)
        {
            return l1;
        }
        
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        
        ListNode curr1=l1;
        ListNode curr2=l2;
        while(curr1!=null&&curr2!=null)
        {
            if(curr1.val<curr2.val)
            {
                tail.next=curr1;
                tail=tail.next;
                curr1=curr1.next;
            }
            else
            {
                tail.next=curr2;
                tail=tail.next;
                curr2=curr2.next;
            }
        }
        
        if(curr1!=null)
        {
            tail.next=curr1;
        }
        if(curr2!=null)
        {
            tail.next=curr2;
        }
        
        return dummy.next;
        
    }

    // Merge Sort on linkedList
   public ListNode merge(ListNode l1,ListNode l2)
    {
        if(l1==null)
        {
            return l2;
        }
        if(l2==null)
        {
            return l1;
        }
        
        ListNode dummy=new ListNode(-1);
        
        ListNode tail=dummy;
        ListNode curr1=l1;
        ListNode curr2=l2;
        
        while(curr1!=null&&curr2!=null)
        {
            if(curr1.val<=curr2.val)
            {
                tail.next=curr1;
                curr1=curr1.next;
            }
            else
            {
                tail.next=curr2;
                curr2=curr2.next;
            }
            tail=tail.next;
        }
        
        if(curr1!=null)
        {
            tail.next=curr1;
        }
        if(curr2!=null)
        {
            tail.next=curr2;
        }
        
        return dummy.next;
    }
    
    
    public ListNode findMid(ListNode head)
    {
        
        if(head==null||head.next==null)
        {
            return head;
        }
        
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode newHead=slow.next;
        slow.next=null;
        
        return newHead;
        
        
    }
    
    
    public ListNode sortList(ListNode head) {
        
        if(head==null||head.next==null)
        {
            return head;
        }
        
        ListNode otherHalf=findMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(otherHalf);
        return merge(left,right);
        
        
    }

    //////////////////////////////////////////////////////////////////////

// check Pallindrome 

 public ListNode reverse(ListNode head)
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        return prev;
    }
    
    public ListNode findMid(ListNode head)
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        
        ListNode slow=head;
        ListNode fast =head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
       
        return slow;
    }
    
    public boolean isPalindrome(ListNode head) {
        
        
        if(head==null||head.next==null)
        {
            return true;
        }
        
        ListNode mid=findMid(head);
          ListNode head2=mid.next;
          mid.next=null;
        head2=reverse(head2);
        boolean ans=true;
        while(head!=null&&head2!=null)
        {
            if(head.val!=head2.val)
            {
                ans=false;
            }
            head=head.next;
            head2=head2.next;
        }
  //careful always repair list that you disturbed 
        head2=reverse(head2);
           mid.next=head2;
        return ans;        
        
    }

}