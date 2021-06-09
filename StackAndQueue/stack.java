public class stack
{

private int []arr;
private int tos;
private int size;
private int maxSize;

protected void initialize(int len)
{

arr=new int[len];
this.size=0;
this.maxSize=len;
this.tos=-1;

}


   public stack()
    {
    initialize(1);
    }

public  stack(int len)
{
    initialize(len);
}
private void stackisEmptyException() throws Exception{

if(this.size==0)
{
    throw new Exception("stackisEmptyException: -1");
}

}

public void stackisOverflowException() throws Exception{

if(this.size==this.maxSize)
{
    throw new Exception("stackisOverflowException : -1");
}

}
@Override
public String toString()
{

StringBuilder sb=new StringBuilder();

sb.append("[");

for(int i=this.tos;i>=0;i--)
{
    sb.append(this.arr[i]);
    if(i!=0)
    {
        sb.append(", ");
    }
}
sb.append("]");

return sb.toString();

}


public int size()
{
   return this.size;
}

public boolean isEmpty()
{
    return this.size==0;
}

private void push_(int val)
{

this.arr[++this.tos]=val;
this.size++;

}

public void push(int val) throws Exception{
stackisOverflowException();
  push_(val);

}

private int pop_()
{
int val=this.arr[this.tos];
this.arr[this.tos]=0;
this.tos--;
this.size--;

return val;
}

public int pop () throws Exception
{
stackisEmptyException();
return pop_();

}
public int maxSize()
{
    return this.maxSize;
}
public int top() throws Exception
{
stackisEmptyException();
return this.arr[this.tos];

}





}