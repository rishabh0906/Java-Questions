public class BinaryTree
{
    
    public static class Node
    {
        int val;
        Node left;
        Node right;

        Node(int val,Node left,Node right)
        {
            this.val=val;
            this.left=left;
            this.right=right;
        }

        Node(int val)
        {
            this(val,null,null);
        }
    }

    public static void preorder(Node root)
    {
        if(root==null)
        {
            return ;
        }

        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root)
    {

        if(root==null)
        {
            return ;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);

    }
    public static int size(Node node) {
   
   if(node==null)
   {
       return 0;
   }
   
   int left=size(node.left);
   int right=size(node.right);
   
   return left+right+1;
  }

  public static int sum(Node node) {
     
   if(node==null)
   {
       return 0;
   }
   
   int left=sum(node.left);
   int right=sum(node.right);
   
   return left+right+node.data;
  }

  public static int max(Node node) {

   if(node==null)
   {
       return 0;
   }
   
   int left=max(node.left);
   int right=max(node.right);
   
   return Math.max(node.data,Math.max(left,right));
  }

  public static int height(Node node) {
      if(node==null)
      {
          return 0;
      }
      if(node.left==null&&node.right==null)
      {
          return 0;
      }
      
      int left= height(node.left);
      int right=height(node.right);
      
      return Math.max(left,right)+1;
  }
  public static  int min(Node root)
  {
    if(root==null)
    {
        return (int) 1e9;
    }

    int left=min(root.left);
    int right=min(root.right);

    return Math.min(root.val,Math.min(left,right));
  }

}