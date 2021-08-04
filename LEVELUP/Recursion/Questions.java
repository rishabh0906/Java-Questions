import java.util.*;

public class Question{
// Word Break 
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
//===================================== SUDOKU SOLVER ===================================

public boolean checkIfNumberIsSafeToPlace(char [][]UnsolvedSudoku,int row,int col,int number_to_be_place)
    {
        for(int curr_col=0;curr_col<9;curr_col++) 
          if(UnsolvedSudoku[row][curr_col]==(char)(number_to_be_place+'0')) 
              return false;
        
        for(int curr_row=0;curr_row<9;curr_row++) 
          if(UnsolvedSudoku[curr_row][col]==(char)(number_to_be_place+'0'))
              return false;
        
        
        row=(row/3)*3;
        col=(col/3)*3;
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(UnsolvedSudoku[i+row][j+col]==(char)(number_to_be_place+'0'))
                return false;
            }
        }
        return true;
        
    }
    
    public boolean solveSudoku(char [][]UnsolvedSudoku,int EmptyCells_iterator,ArrayList<Integer> EmptyCells)
    {
        if(EmptyCells_iterator==EmptyCells.size())
        {
            return true;
        }
        
        
        int position=EmptyCells.get(EmptyCells_iterator);
        int row=position/9;
        int column=position%9;
        
        for(int num_try_to_place=1;num_try_to_place<=9;num_try_to_place++)
        {
            if(checkIfNumberIsSafeToPlace(UnsolvedSudoku,row,column,num_try_to_place)==true)
            {
                UnsolvedSudoku[row][column]=(char)(num_try_to_place+'0');
                if(solveSudoku(UnsolvedSudoku,EmptyCells_iterator+1,EmptyCells)==true) return true;
                UnsolvedSudoku[row][column]='.';
            }
        }
        
        return false;
        
    }
    public void solveSudoku(char[][] board) {
        ArrayList<Integer> EmptyCells=new ArrayList<>();
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    EmptyCells.add(i*9+j);
                }
            }
        }
        solveSudoku(board,0,EmptyCells);
        
    }
}




}