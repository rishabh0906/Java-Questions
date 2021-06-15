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
// heigh in terms of edges
  public static int height(Node node) {
      if(node==null)
      {
          //return 0;
          return -1;
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


public static int numberOfLeaves(Node node)
{
    if(node==null)
    {
        return 0;
    }

    if(node.left==null&&node.right==null)
    {
        return 1;
    }

   int left=numberOfLeaves(node.left);
   int right=numberOfLeaves(node.right);

   return left+right;

}


public static int singleParent(Node root)
{
    if(root==null)
    {
        return 0;
    }
    if(root.left==null&&root.right==null)
    {
        return 0;
    }
   
    int left=singleParent(node.left);
    int right=singleParent(node.right);

    if(root.left==null||root.right==null)
    {
        return left+right+1;
    }

    return left+right;
}

public static void singleParentans(Node root,ArrayList<Node> ans)
{
    
    if(root==null)
    {
        return ;
    }
    if(root.left==null&&root.right==null)
    {
        return ;
    }
    singleParentans(root.left,ans);
    singleParentans(root.right,ans);

    if(root.left==null||root.right==null)
    {
        ans.add(root);
    }
    

}
// find node =============================================================
public static boolean find(Node root,int data)
{
    if(root==null)
    {
        return false;
    }

    if(root.val==data)
    {
        return true;
    }

    return find(root.left,data)||find(root.right,data);
}
// Node to root path  ====================================================
public static ArrayList<Node> nodeToroot(Node node,int data)
{
    if(root==null)
    {
        return null;
    }

    if(root.val==data)
    {
        ArrayList<Integer> base=new ArrayList<>();
        base.add(root);
        return base;
    }
     
     ArrayList<Node> left=nodeToroot(node.left,data);
     if(left!=null)
     {
         left.add(node);
         return left;
     }
     ArrayList<Node> right=nodeToroot(node.right,data);
      
      if(right!=null)
      {
          right.add(node);
          return right;
      }

      return null;
     
}

// children at k distance  =====================================================

public static void KlevelDown(Node root,int k,ArrayList<Integer> arr)
{
    if(root==null || k<0)
    {
        return ;
    }
    if(k==0)
    {
        arr.add(root.val);
        return ;
    }

    KlevelDown(root.left,k-1,arr);
    KlevelDown(root.right,k-1,arr);
}

// all k distance away node 1   ===========================================================
public static int Kaway(Node root,int k,int data,ArrayList<Integer> arr)
{
    if(root==null)
    {
        return -1;
    }
    if(root.val==data)
    {
        KlevelDown(root,k,arr);
        return 1;
    }

    int left=Kaway(root.left,k,data,arr);
    int right=Kaway(root.right,k,data,arr);

    if(left!=-1)
    {
        if(k-left==0)
        {
            arr.add(root.val);
        
        }
        else
        {
        KlevelDown(root.right,k-left-1,arr);
        }
        return left+1;
    }
    if(right!=-1)
    {   
        if(k-right==0)
        {
       arr.add(root.val);
        }
        else{
               KlevelDown(root.left,k-right-1,arr);
        }
        return right+1;
    }

    return -1;


}
// all k distance away node 2 ==================================================================
public static void KlevelDown2(Node root,Node block,int k,ArrayList<Integer> arr)
{
    if(root==null || k<0||root==block)
    {
        return ;
    }
    if(k==0)
    {
        arr.add(root.val);
        return ;
    }

    KlevelDown2(root.left,block,k-1,arr);
    KlevelDown2(root.right,block,k-1,arr);
}

public static void Kaway2(Node root,int data,int k,,ArrayList<Integer> ans)
{
    ArrayList<Node> path=nodeToroot(root,data);
 
 Node block =null;
    for(int i=0;i<path.size();i++)
    {
        if(k-i>=0)
        {
            KlevelDown2(path.get(i),block,k-i,ans);
        }
        block=path.get(i);
    }
}

// Is Bst 1 ====================================================================

static Node prev=null;

public static boolean checkBst2(Node root)
{
    if(root==null)
    {
        return true;
    }

    if(!checkBst2(root.left)) return false;

    if(prev!=null&&prev.val>node.val) return false;

    if(!checkBst2(root.right)) return false;

    return true;
}


// Is Bst 2=====================================================================

public class isBstPair{

boolean isBst=true;
long maxele=-(long) 1e13;
long minele= (long) 1e13;
}

public static isBstPair checkBst(Node root)
{
    if(root==null)
    {
        return new isBstPair();
    }

    isBstPair left=checkBst(root.left);

    if(!left.isBst)
    {
        return left;
    }

    isBstPair right= checkBst(root.right);

    if(!right.isBst)
    {
        return right;
    }

    isBstPair self =new isBstPair();
      if(root.val>left.maxele && root.val<right.minele)
      {
          self.minele=Math.min(node.val,left.minele);
          self.maxele=Math.max(node.val,right.maxele);
          self.isBst=true;
      }

      return self;

}




}