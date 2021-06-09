import java.util.LinkedList;
public  class stackUsingLL
{

public static  class stack{
   private  LinkedList<Integer> ll= new LinkedList<>();

    public boolean isEmpty()
    {
        return ll.isEmpty();
    }
    public int size()
    {
          return  this.ll.size();
    }

    public  int top()
    {
         return ll.getFirst();
    }
    public int pop()
    {
        return ll.removeFirst();
    }
    public void add(int val)
    {
          ll.addFirst(val);
    }

}

public static void main(String[]args)
{
    stack st=new stack();
    st.add(5);
    st.add(4);
    System.out.println(st.top());
}


}