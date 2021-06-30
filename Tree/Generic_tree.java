public static class Generic_tree{

public class Node{

int val;
ArrayList<Node> children;

Node(int val)
{
 this.val=val;
 this.children= new ArrayList<>();
}

}

public static int size(Node root)
{
   
    int ans=1;
    ArrayList<Node> child= root.children;
    for(int i=0;i<child.size();i++)
    {
     ans+=size(child.get(i));
    }

    return ans;
}
public static int height(Node node) {
  
    
    int height=0;
    ArrayList<Node> children= node.children;
    
    for(int i=0;i<children.size();i++)
    {
        height=Math.max(height,height(children.get(i)+1));
    }
    
    return height;
  }

  public static int maximum(Node node)
  {
   
   int maxEle= node.data;
    ArrayList<Node> children= node.children;
    
    for(int i=0;i<children.size();i++)
    {
        maxEle=Math.max(maxEle,maximum(children.get(i)));
    }
    
    return maxEle;

  }
  public static int countLeaves(Node node)
  {
      if(node.children.size()==0)
      {
          return 1;
      }
      int ans=0;

      for(Node child:node.children)
      {
          ans+=countLeaves(child);
      }
      return ans;
  }
/// ========================find ======================
public static boolean find(Node node, int data) {
    
    
    
    for(Node child:node.children)
    {
        if(find(child,data))
        {
            return true;
        }
    }
    
    if(node.data==data)
    {
        return true;
    }
    
    return false;
    
    
  }

  //===================== node to root
  public static ArrayList<Integer> nodeToRootPath(Node node, int data){


if(node.data==data)
     {
         ArrayList<Integer> base=new ArrayList<>();
         base.add(node.data);
         return base;
     }
     for(Node child:node.children)
     {
         ArrayList<Integer> recAns=nodeToRootPath(child,data);
         if(recAns.size()>0)
         {
             recAns.add(node.data);
             return recAns;
         }
     }
     
     
    return new ArrayList<Integer>();
   
 }
// node to root path 2 ////////////////////////
 public static  boolean nodeToRootPath(Node node,int data,ArrayList<Integer> ans)
 {

if(node.data==data)
{
    ans.add(node.data);
    return true;
}

boolean res=false;
     for(Node child:node.children)
        res=res||nodeToRootPath(child,data,ans);

      if(res)
          ans.add(node.data);

      return res;
     
 }
 // find lca  =============================================
  public ArrayList<TreeNode> nodeToRoot(TreeNode root,int d)
    {
        if(root==null)
        {
            return null;
        }
        if(root.val==d)
        {
            ArrayList<TreeNode> base=new ArrayList<>();
            base.add(root);
            return base;
        }
        
        ArrayList<TreeNode> left=nodeToRoot(root.left,d);
        ArrayList<TreeNode> right=nodeToRoot(root.right,d);
        
        if(left!=null)
        {
            left.add(root);
            return left;
        }
        if(right!=null)
        {
            right.add(root);
            return right;
        }
        return null;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1=nodeToRoot(root,p.val);
        ArrayList<TreeNode> path2=nodeToRoot(root,q.val);
        if(path1==null||path2==null)
        {
            return null;
        }
        
        TreeNode prev=null;
        int i=path1.size()-1;
        int j=path2.size()-1;
        
        while(i>=0&&j>=0&&path1.get(i)==path2.get(j))
        {
            prev=path1.get(i);
            i--;
            j--;
        }
        return prev;
        
    }

// find lca 2  generic Tree =============================================================
    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    if (node.data == data) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(node.data);
      return path;
    }

    for (Node child : node.children) {
      ArrayList<Integer> ptc = nodeToRootPath(child, data);
      if (ptc.size() > 0) {
        ptc.add(node.data);
        return ptc;
      }
    }

    return new ArrayList<>();
  }
  
  

  public static int lca(Node node, int d1, int d2) {
      
      ArrayList<Integer> path1=nodeToRootPath(node,d1);
      ArrayList<Integer> path2=nodeToRootPath(node,d2);
      
      int prev=-1;
      int i=path1.size()-1;
      int j=path2.size()-1;
      
      while(i>=0&&j>=0&&path1.get(i)==path2.get(j))
      {
          prev=path1.get(i);
          i--;
          j--;
      }
      return prev;
    
  }
  // mirror tree =================================================
  public static boolean areMirror(Node n1, Node n2) {
           if(n1.children.size()!=n2.children.size())
           {
               return false;
           }
           
           boolean res=true;
           
           int n=n1.children.size();
           for(int i=0;i<n;i++)
           {
               res=res&&areMirror(n1.children.get(i),n2.children.get(n-i-1));
           }
           return res;
  }
// similar tree ==================================================
   public static boolean areSimilar(Node n1, Node n2) {
 
 
   if(n1.children.size()!=n2.children.size())
   {
       return false;
   }
   boolean res=true;
   for(int i=0;i<n1.children.size();i++)
   {
       res=res&&areSimilar(n1.children.get(i),n2.children.get(i));
   }
   
   return res;
   
  }

  // distance between two nodes
   public static int distanceBetweenNodes(Node node, int d1, int d2){
   ArrayList<Integer>  path1=nodeToRootPath(node,d1);
   ArrayList<Integer> path2=nodeToRootPath(node,d2);
   int d=0;
   int i=path1.size()-1;
   int j=path2.size()-1;
   while(i>=0&&j>=0&&path1.get(i)==path2.get(j))
   {
       d++;
       i--;
       j--;
   }
   
   return path1.size()+path2.size()-2*d;
   
  }
  //=== is Symmetric=======================================
 public static boolean IsSymmetric(Node node) {
               return areMirror(node,node);
  }
}