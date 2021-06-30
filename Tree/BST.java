import java.util.*;
public class BST{


public static int size(Node root)
{
    return root==null?0:size(root.left)+size(root.right)+1;
}

public static int height(Node root)
{
    return root==null?-1:Math.max(height(root.left),height(root.right))+1;
}


public static boolean find(Node root,int data)
{
    while(root!=null)
    {
        if(root.data==data)
        {
            return true;
        }
        else if(root.data<data)
        {
            root=root.right;
        }
        else{
           root= root.left;
        }
    }

    return false;
}


public static int maximum(Node root)
{
    while(root.right!=null)
    {
        root=root.right;
    }

    return root.data;
}
public static int minimum(Node root)
{
    while(root.left!=null)
    {
        root=root.left;
    }
    return root.data;
}

public static  ArrayList<Node> nodeToroot(Node root, int data)
{
    ArrayList<Node> ans=ArrayList<>();

    while(root!=null&&root.data!=data)
    {
        ans.add(root);
        if(root.data<data)
        {
            root=root.right;
        }
        else{
            root=root.left;
        }
    }
    if(root==null)
    {
        ArrayList<Node> base=new ArrayList<>();
        return base;
    }
    ans.add(root);
    return ans;
}
//============================ Lca of BST
public static int lca(Node node, int d1, int d2) {
      
      if(d1>d2)
      {
          int temp=d1;
          d1=d2;
          d2=temp;
      }
      int ans=0;
           
           while(node!=null)
           {
               if(node.data<d1)
               {
                   node=node.right;
               }
               else if(node.data>d2)
               {
                   node=node.left;
               }
               else
               {
                ans=node.data;
                break;
               }
           }
           return ans;
  }
 // =================== print in range (d1<d2)

public static void print(Node node,int d1,int d2)
{
    if(node==null)
    {
        return ;
    }
    
    if(node.data>d2)
    {
        print(node.left,d1,d2);
    }
    else if(node.data<d1)
    {
        print(node.right,d1,d2);
    }
    else
    {
        print(node.left,d1,d2);
        System.out.println(node.data);
        print(node.right,d1,d2);
    }
}
 public static Node add(Node node, int data) {
   
   if(node==null)
   {
      Node base= new Node(data,null,null);
      return base;
   }
   
   if(node.data>=data)
   {
     node.left= add(node.left,data);
   }
    else
    {
   node.right=add(node.right,data);
    }
   return node;
   
   
  }
  //========================================remove node in a bst
  public static int inorder(Node node)
{
    while(node.right!=null)
    {
     node=node.right;   
    }
    
    return node.data;
}

  public static Node remove(Node node, int data) {
  
  if(node==null)
  {
      return null;
  }
  
  if(node.data<data)
  {
      node.right=remove(node.right,data);
  }
  else if(node.data>data)
  {
      node.left=remove(node.left,data);
  }
  else
  {
      if(node.left==null||node.right==null)
      {
          if(node.left==null)
          {
              Node temp=node.right;
             
              return temp;
          }
         if(node.right==null)
          {
              Node temp=node.left;
            
              return temp;
          }
      }
      
      int ins= inorder(node.left);
      node.data=ins;
      node.left=remove(node.left,ins);
      return node;
  }
  return node;
  
  }


}