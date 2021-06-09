
     // Balanced Brackets
     public static boolean checkParenthesis(String str)
     {
         LinkedList<Character> st=new LinkedList<>();
         for(int i=0;i<str.length();i++)
         {
             if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='[')
             {
                 st.addFirst(str.charAt(i));
             }
             else if(str.charAt(i)==')')
             {
                 if(st.size()==0||st.getFirst()!='(')
                 {
                     return false;
                 }
                 st.removeFirst();
             }
             else if(str.charAt(i)=='}')
             {
                   if(st.size()==0||st.getFirst()!='{')
                 {
                     return false;
                 }
                 st.removeFirst();
                 
             }
             else if(str.charAt(i)==']')
             {
                   if(st.size()==0||st.getFirst()!='[')
                 {
                     return false;
                 }
                 st.removeFirst();
             }
         }
         return st.size()==0;
     }
     
     
