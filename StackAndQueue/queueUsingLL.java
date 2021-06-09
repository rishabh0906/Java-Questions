import java.util.LinkedList;

public class queueUsingLL
{
    public static class queue
    {
        private LinkedList<Integer> ll =new LinkedList<>();

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
          ll.addLast(val);
      }

      public int peek()
      {
          return ll.getFirst();
      }

      public int remove()
      {
          return ll.removeFirst();
      }


    }

    public static void main(String[]args)
    {
        queue q=new queue();
        q.add(5);
        q.add(4);
        System.out.println(q.peek());
    }
}