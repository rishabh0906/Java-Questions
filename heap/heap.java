import java.util.*;

public class heap{
// Data Members
private ArrayList<Integer> arr;
private int noOfele=0;
private boolean isMaxHeap=true;

private void initialize( boolean isMaxHeap)
{ 
    this.arr=new ArrayList<>();
    this.noOfele=0;
    this.isMaxHeap=isMaxHeap;

}

//Constructors 

public heap(boolean isMaxHeap)
{
    initialize(isMaxHeap);
}

public heap()
{
        this(true);
}
public heap(int[] data, boolean isMaxHeap) {
        this(isMaxHeap);

        for (int ele : data)
            this.arr.add(ele);

        this.noOfele = this.arr.size();

        for (int i = this.noOfele - 1; i >= 0; i--) { // NLogN -> N
            downHeapify(i);
        }
    }

    //Basic Function ============================

public int size()
{
    return this.noOfele;
}

public boolean isEmpty()
{
    return this.noOfele==0;
}

// exceptions.==============================================

    private void UnderFlowPointerException() throws Exception {
        if (this.noOfele == 0)
            throw new Exception("HeapUnderFlowException");
    }

    // DS Functions.==============================================

    public int compareTo(int t, int o) {
        if (isMaxHeap) {
            return this.arr.get(t) - this.arr.get(o);
        } else {
            return this.arr.get(o) - this.arr.get(t);
        }
    }

    private void swap(int i, int j) {
        int e1 = this.arr.get(i);
        int e2 = this.arr.get(j);

        this.arr.set(i, e2);
        this.arr.set(j, e1);
    }

    // O(LogN)
    private void downHeapify(int pi) {
        int maxIdx = pi, lci = 2 * pi + 1, rci = 2 * pi + 2;
        if (lci < this.noOfele && compareTo(lci, maxIdx) > 0)
            maxIdx = lci;
        if (rci < this.noOfele && compareTo(rci, maxIdx) > 0)
            maxIdx = rci;

        if (maxIdx != pi) {
            swap(pi, maxIdx);
            downHeapify(maxIdx);
        }
    }
// O(logN)
    private void upHeapify(int ci)
    {
        int pi=(ci-1)/2;

        if(pi>=0&&compareTo(ci,pi)>0)
        {
            swap(ci,pi);
            upHeapify(pi);
        }
    }

    public int peek() throws Exception {
        UnderFlowPointerException();
        return this.arr.get(0);
    }

// O(LogN)
    public int remove() throws Exception {
        UnderFlowPointerException();
        int ele=this.arr.get(0);
        swap(0,this.noOfele-1);
        this.noOfele--;
        downHeapify(0);

        return ele;


    }

    public void add(int val) {

        this.arr.add(val);
         this.noOfele++;
        upHeapify(this.noOfele-1);
       

    }

}