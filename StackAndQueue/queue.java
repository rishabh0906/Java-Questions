public class queue{

int []arr;
int size;
int maxSize;
int front;
int rear;


protected void initialize(int len)
{
    arr=new int[len];
    this.size=0;
    this.maxSize=len;
    this.front=0;
    this.rear=0;
}

public queue()
{
    initialize(5);
}
public queue(int len)
{
    initialize(len);
}
public void queueOverflowException() throws Exception{

if(this.size==maxSize)
{
    throw new Exception("queueOverflowException : "+maxSize);
}
}

public void queueisEmptyException() throws Exception{

    if(this.size==0)
    {
        throw new Exception("queueisEmptyException: -1");
    }
}

@Override

public String toString()
{
    StringBuilder sb= new StringBuilder();

sb.append("[");
    for(int i=0;i<this.size;i++)
    {
        sb.append(this.arr[(i+this.front)%this.maxSize]);
        if(i!=this.size-1)
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
public int maxSize()
{
    return this.maxSize;
}

public boolean isEmpty()
{
    return this.size()==0;
}

private void add_(int val)
{
 
   this.arr[this.rear]=val;
      this.rear=(this.rear+1)%this.maxSize;
   this.size++;
}

public void add(int val) throws Exception{

queueOverflowException();
add_(val);

}


public int peek() throws Exception
{
    queueisEmptyException();
   return  this.arr[this.front];
}

private int remove_()
{
    int val=this.arr[this.front];
    this.arr[this.front]=0;
    this.front=(this.front+1)%maxSize;
    this.size--;
    return val;


}

public int remove() throws Exception
{
    queueisEmptyException();
    return remove_();
}












}