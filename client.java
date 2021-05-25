import java.util.*;

public class client
{


public static void main(String []args)
{

LinkedList ll= new LinkedList();

ll.addFirst(1);
ll.addLast(2);
ll.addAt(2,3);
ll.addAt(1,4);
ll.addAt(4,5);
System.out.println(ll);
System.out.print("\n"+ll.getSize());

}

}