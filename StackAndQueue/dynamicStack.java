public class dynamicStack extends stack {


public dynamicStack()
{
    super();
}
public dynamicStack(int len)
{
  super(len);
}

public void push(int data) throws Exception
{
    int max=super.maxSize();
    int curr=super.size();
    if(curr==max)
    {
       int []temp= new int[max];
       int idx=max-1;
       while(super.size()!=0)
       {
           temp[idx--]=super.pop();
       }

       super.initialize(2*max);
       for(int i=0;i<max;i++)
       {
           super.push(temp[i]);
       }

    }
    super.push(data);
      

}






}