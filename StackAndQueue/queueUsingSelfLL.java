public class queueUsingSelfLL
{
    public static class LinkedList{

private class Node{
      
      int data;
      Node next=null;
      Node(int data)
      {
          this.data=data;
      }
}

       private Node head=null;
       private Node tail=null;
       private int size=0;

       private int size()
       {
           return this.size;
       }
       private boolean isEmpty()
       {
           return this.size==0;
       }

       private void  addLast(int val)
       {
           Node node =new Node(val);
           if(this.size==0)
           {
               this.head=this.tail=node;
           }
           else{
               this.tail.next=node;
               this.tail=this.tail.next;
           }
           this.size++;
       }
       private int removeFirst()
       {
           int val=this.head.data;
           this.head=this.head.next;
           this.size--;
           return val;
       }
       private int getFirst()
       {
           return this.head.data;
       }
    }

  public static class queue{

      private LinkedList ll= new LinkedList();

      public boolean isEmpty()
      {
          return ll.isEmpty();
      }
      public int size()
      {
          return ll.size();
      }
      private void queueIsEmptyException() throws Exception{
          if(ll.size()==0)
          {
           throw new Exception("queueIsEmptyException");
          }
      }

      public void add(int val)
      {
               ll.addLast(val);
      }
      public int peek() throws Exception
      {   queueIsEmptyException();
          return ll.getFirst();
      }

      public int remove()  throws Exception {
          queueIsEmptyException();
              return ll.removeFirst();
      }
  }

  public static void main(String[]args) throws Exception
  {
      queue q= new queue();

      q.add(5);
      q.add(6);
      q.add(7);
      while(!q.isEmpty())
      {
          System.out.println(q.remove());
      }
      q.remove();
  }

}