import java.util.*;

public class Question{

public static int WordBreak(String str,String ans,HashSet<String> dict)
{
    if(str.length()==0)
    {
        System.out.println(ans);
        return 1;
    }
    int count=0;
    for(int ei=0;ei<str.length();ei++)
    {
        String subs=str.substring(0,ei+1);
        if(dict.contains(subs))
        {
            count+=WordBreak(str.substring(ei+1),ans+subs+" ",dict);
        }
    }

    return count;
}

// String after atmost K swaps
static String max;
	public static String swap(String str,int i,int j)
	{
	    StringBuilder sb=new StringBuilder(str);
	    sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
	}
	public static void findMaximum(String str, int k) {
		
	if (isGreater(max,str)) {
    max = str;
  }
  if (k == 0) {
    return;
  }

  for (int i = 0; i < str.length() - 1; i++) {
    for (int j = i + 1; j < str.length(); j++) {
      if (str.charAt(i) < str.charAt(j)) {
        str = swap(str, i, j);

        findMaximum(str, k - 1);                    
        str = swap(str, i, j);
      }
    }
  }
		

}

public static boolean isGreater(String str,String temp)
{
    if(str.length()>temp.length())
    {
        return false;
    }
    else if(str.length()<temp.length())
    {
               return true;
    }

    for(int i=0;i<str.length();i++)
    {
        if(str.charAt(i)<temp.charAt(i))
        {
                 return true;
        }
        else if(str.charAt(i)>temp.charAt(i))
        {
            return false;
        }
    }

    return true;
}

}