import java.util.*;

public class Searching {

    public static int binarySearch(int[] arr, int si, int ei, int value) {

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (arr[mid] == value)
                return mid;
            else if (arr[mid] < value)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return -1;

    }

    public static int FirstIndex(int[] arr, int si, int ei, int value) {

        int ans = -1;

        while (si <= ei) {

            int mid = (si + ei) / 2;
            if (arr[mid] == value) {
                ans = mid;
                ei = mid - 1;
            } else if (arr[mid] < value)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return ans;
    }

    public static int LastIndex(int[] arr, int si, int ei, int value) {

        int ans = -1;

        while (si <= ei) {

            int mid = (si + ei) / 2;
            if (arr[mid] == value) {
                ans = mid;
                si = mid + 1;
            } else if (arr[mid] < value)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return ans;
    }

    public static int Floor(int[] arr, int si, int ei, int target) {

        int ans = -1;

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (arr[mid] <= target) {
                ans = mid;
                si = mid + 1;
            } else
                ei = mid - 1;

        }
        return ans;
    }

    public static int Ceil(int[] arr, int si, int ei, int target) {

        int ans = -1;

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                ei = mid - 1;
            } else
                si = mid + 1;

        }
        return ans;
    }

    public static int perfectLocation(int[] arr, int target) {

        int si = 0, ei = arr.length;

        while (si < ei) {

            int mid = (si + ei) / 2;

            if (arr[si] <= target) {
                si = mid + 1;
            } else
                ei = mid;
        }

        return ei;

    }

    public static boolean searchMatrix_01(int[][] matrix, int target) {

        int si = 0, ei = matrix.length * matrix[0].length - 1;
        int n = matrix.length, m = matrix[0].length;
        while (si <= ei) {

            int mid = (si + ei) / 2;

            int r = mid / n, c = mid % n;

            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] > target)
                ei = mid - 1;
            else
                si = mid + 1;

        }

        return false;

    }

    public static boolean searchMatrix_02(int[][] matrix, int target) {

        int i = 0, j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {

            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target)
                j--;
            else
                i++;
        }

        return false;

    }

    public static int CountMyInversion(int[] arr, int l, int mid, int r) {

        int[] sortedArray = new int[r - l + 1];
        int k = 0;
        int i = l;
        int j = mid + 1;
        int inversions = 0;
        while (i <= mid && j <= r) {

            if (arr[j] < arr[i]) {
                sortedArray[k++] = arr[j];
                inversions += mid - i + 1;
                j++;
            } else {
                sortedArray[k++] = arr[i];
                i++;
            }
        }

        while (i <= mid || j <= r) {
            sortedArray[k++] = arr[i <= mid ? i++ : j++];
        }

        for (int idx = 0; idx < sortedArray.length; idx++) {
            arr[idx + l] = sortedArray[idx];
        }

        return inversions;

    }

    public static int CountInversionsGlobal(int[] arr, int l, int r) {

        if (l >= r) {
            return 0;
        }

        int mid = (l + r) / 2;
        int count = 0;
        count += CountInversionsGlobal(arr, l, mid);
        count += CountInversionsGlobal(arr, mid + 1, r);

        count += CountMyInversion(arr, l, mid, r);

        return count;

    }

    public static boolean inversions(int[] arr) {

        int local = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                local++;
        }
        return local == CountInversionsGlobal(arr, 0, arr.length - 1);

    }

    public static List<int[]> TwoSum_03(int[] arr, int target) {

        int l = 0, r = arr.length - 1;

        List<int[]> ans = new ArrayList<>();

        while (l < r) {

            if (arr[l] + arr[r] == target) {
                ans.add(new int[] { l, r });
                int left = l;
                int right = r;
                l++;
                r--;
                while (l < r && arr[left] == arr[l]) {
                    l++;
                }

                while (l < r && arr[right] == arr[r]) {
                    r--;
                }
            } else if (arr[l] + arr[r] < target) {

                l++;
            } else {
                r--;
            }
        }
        return ans;

    }

    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length){
            
            int findSum=-nums[i];
            
            List<int[]> twoSumAns=TwoSum_03(nums,i+1,nums.length-1,findSum);
            for(int[]a: twoSumAns){
                List<Integer> triplet=new ArrayList<>();
                triplet.add(nums[i]);
                triplet.add(a[0]);
                triplet.add(a[1]);
                ans.add(triplet);
            }
            i++;
            while(i<nums.length&&nums[i-1]==nums[i]) i++;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = { 0, 0, 1, 1, 2, 3, 4, 6, 7, 8, 9, 10, 10, 11 };
        System.out.println(perfectLocation(arr, 12));
    }

}
