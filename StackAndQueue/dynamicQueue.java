public class dynamicQueue extends queue {

public dynamicQueue()
{
    super();
}
public dynamicQueue(int len)
{
    super(len);
}

public void add(int val) throws Exception
{
    int max=super.maxSize();
    int curr=super.size();
    if(max==curr)
    {
        int []temp=new int[max];

          int idx=0;
              while(super.size()>0)
              {
            temp[idx++]=super.remove();
              }

              super.initialize(2*super.maxSize());
              for(int i=0;i<max;i++)
              {
                  super.add(temp[i]);
              }
    }
    super.add(val);

}

}