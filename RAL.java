import java.util.*;

public class RAL
{

    public static Scanner scn=new Scanner(System.in);
    
    public static ArrayList<String> subs(String str)
    {
        if(str.length()==0)
        {
            ArrayList<String> base =new ArrayList<String>();
            base.add("");
            return base;
        }
      char ch= str.charAt(0);
        ArrayList<String> rec=subs(str.substring(1));
        ArrayList<String> ans=new ArrayList<String> (rec);
        for(String s:rec)
        {
            ans.add(ch+s);
        }
        return ans;
    }
    public static  String []arr={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> keypad(String str)
    {
          if(str.length()==0)
        {
            ArrayList<String> base= new ArrayList<String>();
            base.add("");
            return base;
        }
            
            int num=(int)(str.charAt(0)-'0');
            ArrayList<String> recAns=keypad(str.substring(1));
                   
                   ArrayList<String> ans=new ArrayList<String> ();
                   String curr=arr[num];
                   for(int i=0;i<curr.length();i++)
                   {
                       for(String st:recAns)
                       {
                             ans.add(curr.charAt(i)+st);
                       }
                   }
                   return ans;
    }

    public static ArrayList<String> decodeways(String str)
    {
               if(str.length()==0)
               {
                   ArrayList<String> base=new ArrayList<String>();
                   base.add("");
                   return base;
               }

          if(str.charAt(0)=='0')
          {
              return new ArrayList<String> ();
          }

    char ch=str.charAt(0);
        ArrayList<String> recAns1=decodeways(str.substring(1));
        ArrayList<String> ans=new ArrayList<String>();
        for(String st:recAns1)
        {
            ans.add((char)('a'+ch-'1')+st);
        }
        if(str.length()>1)
        {
           
            int num1=(ch-'0')*10+(str.charAt(1)-'0');
            if(num1<=26)
            {
                ArrayList<String> recAns2=decodeways(str.substring(2));
                 for(String st:recAns2)
            {
                ans.add((char)('a'+num1-1)+st);
            }
            }
           
        }

        return ans;
    }
   public static  String []map={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz","+-*","<>/"};
public static ArrayList<String> decodekeypad(String str)
{

if(str.length()==0)
{
        ArrayList<String> base=new ArrayList<String> ();
        base.add("");
        return base;
}


char ch=str.charAt(0);
      
        ArrayList<String> recAns1=decodekeypad(str.substring(1));
        ArrayList<String> ans=new ArrayList<String>();
        int num=ch-'0';
        for(int i=0;i<map[num].length();i++)
        {
        for(String st:recAns1)
        {
         ans.add(map[num].charAt(i)+st);         
        }
        }
        if(str.length()>1)
        {
            num=num*10+(str.charAt(1)-'0');
            if(num<=11)
            {
                ArrayList<String> recAns2=decodekeypad(str.substring(2));
                for(int i=0;i<map[num].length();i++)
                {
                    for(String st:recAns2)
                    {
                        ans.add(map[num].charAt(i)+st);
                    }
                }
            }
        }
        return ans;

}  

public static ArrayList<String> jump(int n)
{

if(n==0)
{
    ArrayList<String> base=new ArrayList<String> ();
    base.add("");
    return base;
}
if(n<0)
{
    return new ArrayList<String>();
}

ArrayList<String> ans=new ArrayList<String> ();
ArrayList<String> recAns1=jump(n-1);
ArrayList<String> recAns2=jump(n-2);
ArrayList<String> recAns3=jump(n-3);

for(String st:recAns1)
{
    ans.add('1'+st);
}
for(String st:recAns2)
{
    ans.add('2'+st);
}
for(String st:recAns3)
{
    ans.add('3'+st);
}

return ans;
}

public static ArrayList<String> mazePath(int sr,int sc,int dr,int dc)
{
if(sr==dr&&sc==dc)
{
    ArrayList<String> base =new ArrayList<String> ();
    base.add("");
    return base;
}

ArrayList<String> ans=new ArrayList<String>();
    
         if(sc+1<=dc)
         {
        ArrayList<String> recAns1=mazePath(sr,sc+1,dr,dc);
           for(String st:recAns1)
        {
            ans.add('h'+st);
        }
         }
         if(sr+1<=dr)
         {
        ArrayList<String> recAns2=mazePath(sr+1,sc,dr,dc);
     
        for(String st:recAns2)
        {
            ans.add('v'+st);
        }
         }
        return ans;

    
}
public static ArrayList<String> mazePathD(int sr,int sc,int dr,int dc)
{
if(sr==dr&&sc==dc)
{
    ArrayList<String> base =new ArrayList<String> ();
    base.add("");
    return base;
}
if(sr>dr||sc>dc)
{
    return new ArrayList<String> ();
}

ArrayList<String> ans=new ArrayList<String>();
    
    
        ArrayList<String> recAns1=mazePathD(sr,sc+1,dr,dc);
        ArrayList<String> recAns2=mazePathD(sr+1,sc,dr,dc);
             ArrayList<String> recAns3=mazePathD(sr+1,sc+1,dr,dc);
        for(String st:recAns1)
        {
            ans.add('h'+st);
        }
        for(String st:recAns2)
        {
            ans.add('v'+st);
        }
            for(String st:recAns3)
        {
            ans.add('d'+st);
        }

        return ans;

    
}

public static ArrayList<String> infjump(int sr,int sc,int dr,int dc)
{

if(sr==dr&&sc==dc)
{
    ArrayList<String> base =new ArrayList<String> ();
    base.add("");
    return base;
}
ArrayList<String> ans=new ArrayList<String> ();
for(int i=1;sc+i<=dc;i++)
{
  ArrayList<String> recAns1=infjump(sr,sc+i,dr,dc);
  for(String st:recAns1)
  {
      ans.add("h"+""+i+""+st);
  }

}

for(int i=1;sr+i<=dr;i++)
{
  ArrayList<String> recAns3=infjump(sr+i,sc,dr,dc);
  for(String st:recAns3)
  {
      ans.add("v"+""+i+""+st);
  }

}
for(int i=1;sc+i<=dc&&sr+i<=dr;i++)
{
  ArrayList<String> recAns2=infjump(sr+i,sc+i,dr,dc);
  for(String st:recAns2)
  {
      ans.add("d"+""+i+""+st);
  }

}

return ans;

}

    public static void main(String []args)
    {
        // System.out.println(decodeways("888888"));
        //  System.out.println(subs("abc"));
        //  System.out.println(keypad("755"));
        // System.out.println(decodekeypad("1120"));
        // System.out.println(jump(4));

        //  System.out.println(mazePath(1,1,2,2));
        System.out.print(infjump(0,0,1,1));
    }
}