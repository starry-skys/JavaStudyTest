package algo.leetcode.daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 */
public class LeastNumberTest {

    public static void main(String[] args) {
        int[] arr = {5 ,4 ,9 ,7 ,8 ,3 ,1};
        int k = 2;
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(getLeastNumbers3(arr, k)));
        System.out.println(System.currentTimeMillis() - start);
    }

    //arr = [3,2,1], k = 2
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k);
    }

    public static int[] getLeastNumbers1(int[] arr, int k) {
        if(k ==0 || arr.length == 0){
            return new int[0];
        }

        int[] map = new int[10001];
        for (int i = 0; i < arr.length; i++) {
            map[arr[i]]++;
        }

        int[] res = new int[k];
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            while(map[i]-- >0 && x<k){
                res[x++] = i;
            }
            if(x == k) break;
        }

        return res;
    }

    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private static int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    public static int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - 01;
            }
        });

        for (int num : arr) {
            if(queue.size() < k){
                queue.offer(num);
            }else if(num < queue.peek()){
                queue.poll();
                queue.offer(num);
            }
        }

        int[] res = new int[k];
        int x = 0 ;
        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()){
            Integer num = it.next();
            res[x++] = num;
        }

        return res;
    }

}
