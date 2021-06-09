public  class client
{
   
   public static void main(String []args) throws Exception {
     dynamicQueue st=new dynamicQueue(1);
 st.add(5);
 st.add(6);
 st.add(6);
 st.add(8);
 st.add(5);
 st.remove();
 
System.out.print(st.peek()+""+st);
   }

}