import java.util.*;

public  class graph_basic{


public static class  Edge{
    int src;
    int des;
    int wt;

Edge(int src,int des,int wt)
{
    this.src=src;
    this.des=des;
    this.wt=wt;
}

}

public static void addEgde(ArrayList<Edge>[]graph,int u,int v,int w)
{
    graph[u].add(new Edge(u,v,w));
    graph[v].add(new Edge(v,u,w));
}

public static ArrayList[] Graph(int n,ArrayList<Edge> edges)
{
    ArrayList<Edge>[] graph=new ArrayList[n];

    for(int i=0;i<n;i++)
    {
        graph[i]=new ArrayList<>();
    }

    for(int i=0;i<edges.size();i++)
    {
        addEgde(graph,edges.get(i).src,edges.get(i).des,edges.get(i).wt);
    }

    return graph;

}

public static void display(ArrayList<Edge>[]graph,int n)
{

for(int i=0;i<n;i++)
{
    System.out.print(i+"->");

    for(Edge node: graph[i])
    {
        System.out.print("["+node.des+" "+node.wt+"]");
    }
    System.out.println();

}
}

public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest)
            return true;

        vis[src] = true;
        boolean res = false;
        for (Edge e : graph[src])
        {
            if (!vis[e.des])
                res = res || hasPath(graph, e.des, dest, vis);
        }
        return res;
    }

public static int findEdge(ArrayList<Edge>[] graph, int u, int v) {
        ArrayList<Edge> list = graph[u];
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);
            if (e.des == v)
                return i;
        }

        return -1;
    }

    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v) {
        int i1 = findEdge(graph, u, v);
        int i2 = findEdge(graph, v, u);

        graph[u].remove(i1);
        graph[v].remove(i2);
    }

    public static void removeVtx(ArrayList<Edge>[] graph, int u) {
        ArrayList<Edge> list = graph[u];
        for (int i = list.size() - 1; i >= 0; i--) {
            Edge e = list.get(i);
            removeEdge(graph, e.src, e.des);
        }
    }



public static int printAllPaths(ArrayList<Edge> graph[],int src,int des,boolean[]vis,int wsf,String psf)
{
    if(src==des)
    {
        System.out.println(psf+des);
        return 1;
    }

    vis[src]=true;
int count=0;
    for(Edge v: graph[src])
    {
        if(!vis[v.des])
        count+=printAllPaths(graph,v.des,des,vis,wsf+v.wt,psf+src);
    }

    vis[src]=false;

    return count;
}


public static int preorder(ArrayList<Edge> graph[],boolean[]vis,int wsf,String psf,int src)
{
        System.out.println(psf+src+"@"+wsf);

    vis[src]=true;
int count=0;
    for(Edge v: graph[src])
    {
        if(!vis[v.des])
        count+=preorder(graph,vis,wsf+v.wt,psf+""+v.src,v.des);
    }

    vis[src]=false;

    return count;
}

public static int postorder(ArrayList<Edge>[]graph,boolean[]vis,int src,int wt,String psf)
{

vis[src]=true;
int count=0;
for(Edge e:graph[src])
{ 
    if(!vis[e.des])
    count+=postorder(graph,vis,e.des,wt+e.wt,psf+src);
}

 System.out.println(psf+src+"@"+wt);
return count;
}

public static class Pair{
    int wt=-1;
    String path="";
}

public static Pair heaviestWeight(ArrayList<Edge> []graph,int src,int des,boolean[]vis)
{
    if(src==des)
    {
        Pair base=new Pair();
        base.wt=0;
        base.path+=src;
        return base;
    }
vis[src]=true;
    Pair myAns=new Pair();

    for(Edge e:graph[src])
    {
        if(!vis[e.des])
        {
            Pair recAns=heaviestWeight(graph,e.des,des,vis);

            if(recAns.wt!=-1&&recAns.wt+ e.wt >myAns.wt)
            {
                myAns.wt=recAns.wt+e.wt;
                myAns.path=src+recAns.path;
            }
        }
    }
    return myAns;
}


public static class Pair2 {
    String path="";
    int wt=(int) 1e9;
}

public static Pair2 lightWeight(ArrayList<Edge>[]graph,int src,int des,boolean[]vis )
{
    if(src==des)
    {
        Pair2 base =new Pair2();

        base.wt=0;
        base.path+=src;
        return base;
    }
vis[src]=true;
    Pair2 myAns=new Pair2();

    for(Edge  e:graph[src])
    {
        if(!vis[e.des])
        {
            Pair2 recAns = lightWeight(graph,e.des,des,vis);
            if(recAns.wt!=(int)1e9 &&  recAns.wt+e.wt<myAns.wt)
            {
                myAns.wt=recAns.wt+e.wt;
                myAns.path=src+recAns.path;
            }
        }
    }

    return myAns;
}

public static class Pair_cf{
    int floor=(int) -1e9;
    int ceil =(int) 1e9;
}

public static void ceilAndfloor(ArrayList<Edge>[]graph,int data,int src,boolean[]vis,Pair_cf cf,int wsf)
 {

if(wsf>data)
{
    cf.ceil=Math.min(cf.ceil,wsf);
}
if(wsf<data)
{
    cf.floor=Math.max(cf.floor,wsf);
}

vis[src]=true;

for(Edge e: graph[src])
  {
    if(!vis[e.des])
    {
        ceilAndfloor(graph,data,e.des,vis,cf,wsf+e.wt);
    }
}

vis[src]=false;

 }

public static Pair_cf ceilAndfloor(ArrayList<Edge> []graph,int data,int n)
 {
    Pair_cf pair=new Pair_cf();
boolean[]vis= new boolean[n];
ceilAndfloor(graph,data ,0, vis,pair,0);
return pair;
}


// O(E)
public static void dfs(ArrayList<Edge>[]graph,int src,boolean[]vis)
{

    vis[src]=true;

    for(Edge e: graph[src])
    {
        if(!vis[e.des])
        {
            dfs(graph,e.des,vis);
        }
    }
}
//O(E+V)
public static int getConnect(ArrayList<Edge> []graph,int n)
 {

boolean[] vis =new  boolean[n];
int count=0;
for(int i=0;i<n;i++)
{
  if(!vis[i])
  {
      dfs(graph,i,vis);
      count++;
  }
}

return count;

}


 /// MaxArea of Island
    int dfs(int[][]grid,int r,int c,boolean[][]vis,int[][]dir)
    {
        vis[r][c]=true;
        int count=1;
        
        for(int i=0;i<4;i++)
        {
            int nextr=r+dir[i][0];
            int nextc=c+dir[i][1];
            
            if(nextr<0||nextr>=grid.length||nextc<0||nextc>=grid[0].length)
            {
                continue;
            }
            
            if(grid[nextr][nextc]==1&&!vis[nextr][nextc])
            {
                count+=dfs(grid,nextr,nextc,vis,dir);
            }
        }
        
        return count;
        
        
        
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        
    boolean [][]vis=new boolean[n][m];
        
        int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        
        int MaxArea=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1&&vis[i][j]==false)
                {
                    MaxArea=Math.max(MaxArea,dfs(grid,i,j,vis,dir));
                }
            }
        }
        
        return MaxArea;
    }
/////////////////////////////////////////////////////////////////////////




public static void dfs_hamiltonian(ArrayList<Edge>[]graph,int pos,int V,int parent,int src,String path,int root,boolean[]vis)
{

if(pos==V)
{
    for(Edge e:graph[src] )
    {
        if(e.des==root)
        {
            System.out.println(path+src+"*");
            return ;
        }
    }
    System.out.println(path+src+".");
    return ;
}
vis[src]=true;
    for(Edge e: graph[src])
    {
        if(!vis[e.des])
        dfs_hamiltonian(graph,pos+1,V,src,e.des,path+src,root,vis);
        
    }
    vis[src]=false;
}

public static void hamiltonianCyclePath(ArrayList<Edge>[]graph,int n,int src)
{

    boolean []vis=new boolean[n];

    dfs_hamiltonian(graph,1,n-1,-1,src,"",src,vis);
   
}

public static void BFS(ArrayList<Edge> []graph,int src,int des,int n)
{
    boolean []vis=new boolean[n];
    LinkedList<Integer> ll=new LinkedList<>();

    ll.addLast(src);
    vis[src]=true;
int level=0;
int shortest;
boolean cycle=false;
    while(ll.size()>0)
    {
        int size=ll.size();
        while(size-->0)
        {
            Integer rvtx=ll.removeFirst();
            if(vis[rvtx])
            {
                cycle=true;
                continue;
            }
            if(src==des)
            {
             shortest=level;   
            }
            for(Edge v:graph[rvtx])
            {
                if(!vis[v.des])
                {
                    vis[v.des]=true;
                    que.addLast(v.des);
                }
            }
        }
        level++;
    }

}
//Cycle Detection 
 public static boolean BFS(ArrayList<Edge> []graph,int n,int src,boolean[]vis)
  {
     
      
      LinkedList<Integer> ll= new LinkedList<>();
      ll.addLast(src);
      while(ll.size()>0)
      {
          int size=ll.size();
          while(size-->0)
          {
              int front=(int) ll.removeFirst();
              
              if(vis[front])
              {
                  return true;
              }
              
              vis[front]=true;
              for(Edge e:graph[front])
              {
                  if(!vis[e.nbr])
                  ll.addLast(e.nbr);
              }
              
          }
      }
      return false;
  }

public static class path_info{

    int vtx=0;
    String psf="";
    int wsf=0;

    path_info(int vtx,String psf,int wsf)
    {
        this.vtx=vtx;
        this.psf=psf;
        this.wsf=wsf;
    }
}

// print shortest Path
public static void printPaths(ArrayList<Edge>[]graph,int n)
{
    boolean[] vis=new boolean[n];

    for(int i=0;i<n;i++)
    {
        if(vis[i])continue;

        LinkedList<path_info> ll=new LinkedList<>();

        ll.addLast(new path_info(i,i+"",0));
        while(ll.size()>0)
        {
            int size=ll.size();
            while(size-->0)
            {
                path_info rp= ll.removeFirst();

                if(vis[rp.vtx])
                  continue;
                
                vis[rp.vtx]=true;
                System.out.println(rp.vtx+"->"+rp.psf+"@"+rp.wsf);

                for(Edge e:graph[rp.vtx])
                {
                    if(!vis[e.nbr])
                    {
                        ll.addLast(new path_info(e.des,rp.psf+e.des,rp.wsf+e.wt));
                    }
                }
            }
        }
    }
}

 // bipartite Graph (carefull for not connected graph)
  public static boolean BFS(ArrayList<Edge> []graph,int src,int []vis)
   {
       LinkedList<pair> ll =new LinkedList<>();
       
       ll.addLast(new pair(src,0));
       
       while(ll.size()>0)
       {
           int size=ll.size();
           while(size-->0)
           {
               pair front= ll.removeFirst();
               
               if(vis[front.vtx]!=-1)
               {
                   if(vis[front.vtx]!=front.level)
                   {
                       return false;
                   }
                   continue;
               }
               
               vis[front.vtx]=front.level;
               
               for(Edge e: graph[front.vtx])
               {
                   if(vis[e.nbr]==-1)
                   {
                       ll.addLast(new pair(e.nbr,(front.level+1)%2));
                   }
               }
           }
       }
       return true;
   }

public static void main(String []args)
{
    int n=9;
    ArrayList<Edge> edges=new ArrayList<>();

edges.add(new Edge(0,1,1));
edges.add(new Edge(0,3,1));
edges.add(new Edge(3,2,1));
edges.add(new Edge(2,1,1));
edges.add(new Edge(1,5,1));
edges.add(new Edge(4,0,1));
edges.add(new Edge(2,8,1));
edges.add(new Edge(5,8,1));
edges.add(new Edge(5,6,1));
edges.add(new Edge(8,7,1));
edges.add(new Edge(6,7,1));

ArrayList<Edge> []graph=Graph(n,edges);
boolean []vis=new boolean[n];
// display(graph,n);
//System.out.println(printAllPaths(graph,0,8,vis,0,""));
// preorder(graph,vis,0,"",0);
hamiltonianCyclePath(graph,n,0);
}


}



