import java.util.*;

public class matrix
{
public static Scanner scn=new Scanner(System.in);


public static void input(int [][]arr)
{
    int n=arr.length;
    int m=arr[0].length;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            arr[i][j]=scn.nextInt();
        }
    }
}

public static void display(int [][]arr )
{
    for(int i=0;i<arr.length;i++)
    {
        for(int j=0;j<arr[0].length;j++)
        {
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
}

public static int maximum(int [][]arr)
{
    int max=(int) -1e9;
for(int i=0;i<arr.length;i++)
{
    for(int j=0;j<arr[0].length;j++)
    {
        if(max<arr[i][j])
        {
            max=arr[i][j];
        }
    }
}
return max;
}

public static int minimum (int [][]arr)
{
    int min=(int) 1e9;
for(int i=0;i<arr.length;i++)
{
    for(int j=0;j<arr[0].length;j++)
    {
        if(min>arr[i][j])
        {
            min=arr[i][j];
        }
    }
}

return min;
}

public static boolean find(int [][]arr,int val)
{
    for(int i=0;i<arr.length;i++)
    {
        for(int j=0;j<arr[0].length;j++)
        {
            if(arr[i][j]==val)
            {
                return true;
            }
        }
    }

    return false;
}

public static void path1(int mat[][])
{

    int n=mat.length;
    int m=mat[0].length;

    for(int j=0;j<m;j++)
    {
        if(j%2==0)
        {
            for(int i=0;i<n;i++)
            {
                System.out.print(mat[i][j]+" ");
            }
        }
        else{
            
            for(int i=n-1;i>=0;i--)
            {
                System.out.print(mat[i][j]+" ");
            }
        }
    }
}

public static void path2(int [][]arr)
{

int m=arr[0].length;
int n=arr.length;
for(int gap=0;gap<m;gap++)
{
    for(int i=0,j=gap;i<n&&j<m;i++,j++)
    {
        System.out.println(arr[i][j]);
    }
}
}

public static void spiral(int [][]mat)
{
int n=mat.length;
int m=mat[0].length;
        int total= m*n;
int rmin=0,rmax=n-1,cmin=0,cmax=m-1;
        while(total>0)
        {
             for(int r=rmin;r<=rmax&&total>0;r++)
             {
                System.out.println(mat[r][cmin]);
                total--;
             }
             cmin++;
             for(int c=cmin;c<=cmax&&total>0;c++)
             {
                 System.out.println(mat[rmax][c]);
                 total--;
             }
             rmax--;
               for(int r=rmax;r>=rmin&&total>0;r--)
             {
                 System.out.println(mat[r][cmax]);
                 total--;
             }
             cmax--;
               for(int c=cmax;c>=cmin&&total>0;c--)
             {
                 System.out.println(mat[rmin][c]);
                 total--;
             }
             rmin++;

        }
}

public static void endpt(int [][]mat)
{

int n=mat.length;
int m=mat[0].length;    
int i=0,j=0;
int dir=0;
while(true)
{
    dir=(dir+mat[i][j])%4;

    if(dir==0)
    {
        j++;
        if(j==m)
        {
            System.out.println(i+" "+(j-1));
            break;
        }
    }
    else if(dir==1)
    {
        i++;
        if(i==n)
        {
            System.out.println((i-1)+" "+(j));
            break;
        }
       
    }
    else if(dir==2)
    {
      
             j--;
    if(j==-1)
        {
            System.out.println(i+" "+(j+1));
            break;
        }
    }
    else
    {
             i--;
        if(i==-1)
        {
            System.out.println((i+1)+" "+j);
            break;
        }
    }

}

}

public static void rotate(int [][]mat)
{

    int n=mat.length;
    int m=mat[0].length;
    int i=0;

    for( i=0;i<n;i++)
    {
        for(int j=i;j<n;j++)
        {
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
        }
    }
    i=0;
    while(i<n)
    {
        int l=0,e=m-1;
        while(l<=e)
        {
           int temp=mat[i][l];
           mat[i][l]=mat[i][e];
           mat[i][e]=temp;
           l++;
           e--;
        }
        i++;
    }

    for( i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            System.out.print(mat[i][j]+" ");
        }
        System.out.println();
    }
}

public static void saddlept(int [][]mat)
{
    int n=mat.length;
    int m=mat[0].length;
boolean ans= false;
for(int i=0;i<n;i++)
{
    int col=-1;
    int minVal=(int) 1e9;
    for(int j=0;j<m;j++)
    {
        if(mat[i][j]<minVal)
        {
            minVal=mat[i][j];
            col=j;
        }
    }
    int row=-1;
    int maxVal=(int) -1e9;
    for(int j=0;j<n;j++)
    {
        if(maxVal<mat[j][col])
        {
            maxVal=mat[j][col];
            row=j;
        }
    }
    if(i==row)
    {
        System.out.println(mat[row][col]);
        ans=true;
        break;
    }

}

if(!ans)
{
    
    System.out.println("Invalid input");
}


}

public static void search(int [][]mat,int d)
{
    int n=mat.length;
    int m=mat[0].length;
    int i=0,j=m-1;
    int row=-1,col=-1;
    while(i<n&&j>=0)
    { 
        if(mat[i][j]==d)
        {
            row=i;
            col=j;
            break;
        }
        else if(mat[i][j]<d)
        {
            i++;
        }
        else{
            j--;
        }

    }
    if(row==-1)
    {
        System.out.println("Not Found");
    }
    else{
        System.out.println(row+" \n"+col);
    }
}



public static void main(String []args)
{
int [][]arr=new int[scn.nextInt()][scn.nextInt()];
input(arr);

int d=scn.nextInt();
// int data=scn.nextInt();
// int max=maximum(arr);
// int min=minimum(arr);
// boolean val=find(arr,data);
search(arr,d);
}

}