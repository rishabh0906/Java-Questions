


public class Bits{


public static int offToon(int n,int k)
{
    if(((1<<k)&n)==0)
    {
        n^=(1<<k);
    }
    return n;
}

public static int onTooff(int n,int k)
{

if(((1<<k)&n)!=0)
{
    n^=(1<<k);
}

return n;
}

public static int countSetBits(int n)
{

int count=0;

    for(int i=0;i<32;i++)
    {
        if(((1<<i)&n)!=0)
        {
            count++;
        }
    }

    return count;
}

   public static int missingNumber(int[] nums) {
     
        int Xor=0;
        int XorAr=0;
        for(int i=1;i<=nums.length;i++)
        {
            
            XorAr^=nums[i-1];
            Xor^=i;
        }
        return Xor^XorAr;
    }

    public static int missingNumber_02 (int []nums)
    {
        int sum=0;
        for(int ele:nums)
        sum+=ele;
         
         return (nums.length*(nums.length+1))/2-sum;

    }

public static void main(String []args)
{

int n= 32;
System.out.println(countSetBits(n));
System.out.println(onTooff(12,2));
System.out.println(offToon(32,4));
}


}