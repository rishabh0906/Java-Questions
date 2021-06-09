public class  stackUsingSelfLL
{
public static class LinkedList
    {
      private class Node{
        
        int data;
        Node next=null;

          Node(int val)
          {
              this.data=val;
          }

        } 

        private Node head=null;
        private Node tail=null;
        private int size=0;
          

         

          public boolean isEmpty()
              {
                  return this.size==0;
              }
          public int size()
          {
              return this.size;
          }

        private void addFirst(int val)
          {
              Node node= new Node(val);
              if(this.size==0)
              {
                this.head=this.tail=node;
              }
              else
              {
                  node.next=this.head;
                  head=node;
              }
              this.size++;
          }

          private int removeFirst()    {
                 
                  int val=this.head.data;
                  this.head=this.head.next;
                  this.size--;
                  return val;
          }

         private int getFirst() {
                
                  return this.head.data;

          }     

    }
    public static class stack{

     LinkedList ll=new LinkedList();
        
         public void stackisEmptyException()throws Exception{

              if(this.ll.size()==0)
              throw new Exception("stackisEmptyException");
          }

       public boolean isEmpty()
        {
            return ll.isEmpty();
        }
        public int size()
        {
            return this.ll.size();
        } 
        public void add(int val)
        {
            ll.addFirst(val);
        }
        public int pop() throws Exception
        {
            stackisEmptyException();
            return ll.removeFirst();
        }
        public int top() throws Exception
        {
            stackisEmptyException();
            return ll.getFirst();
        }


    }
// Instance of A Class can also access the private Members of that class
    public static void main(String[]args) throws Exception
    {
        stack st=new stack();
        st.add(5);
        st.add(6);
        st.add(7);
        while(!st.isEmpty())
        {
               System.out.println(st.pop());
        }
        st.pop();
       

    }
}