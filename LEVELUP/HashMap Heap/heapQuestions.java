import java.util.PriorityQueue;

public class heapQuestions {
/// O(nlog(k))
    public static int kthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            // maxHeap
            return b - a;
        });

        for (int ele : arr) {

            pq.add(ele);

            if (pq.size() > k)
                pq.remove();
        }

        return pq.peek();

    }
//                kth smallest 
    public static void swap(int[] arr, int x, int y) {

        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static int partition(int[] arr, int l, int r) {

        int pivot = arr[r];

        int idx = l - 1;
        for (int i = l; i <= r; i++) {

            if (arr[i] <= pivot) {
                idx++;
                swap(arr, idx, i);
            }
        }

        return idx;
    }

    public static int kthSmallest_02(int[] arr, int l, int r, int k) {

        int index = partition(arr, l, r);

        if (index == k-1)
            return arr[index];
        else if (index < k-1) {
            return kthSmallest_02(arr, index + 1, r, k);
        }

        return kthSmallest_02(arr, l, index - 1, k);

    }

    public static int kthSmallest_02(int[] arr, int k) {

        return kthSmallest_02(arr, 0, arr.length - 1, k);

    }
// Using making heap
    public static int kthSmallest_03(int []arr,int k){
      
        return 0;
    }

    public static void main(String[] args) {

        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int k = 2;

        System.out.println(kthSmallest_02(arr, k));
        for(int ele:arr)
              System.out.println(ele);
    }
}
