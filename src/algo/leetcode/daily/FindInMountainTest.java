package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/4/29 10:52
 * 1095. 山脉数组中查找目标值
 */
public class FindInMountainTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        MountainArrayImpl mountainArray = new MountainArrayImpl(arr);
        FindInMountainTest test = new FindInMountainTest();
        System.out.println(test.findInMountainArray(target, mountainArray));
    }


    public int findInMountainArray(int target, MountainArray mountainArr) {
        //先找山峰
        int len = mountainArr.length();
        int top = findTop(mountainArr, 0, len-1);
        //在左边升序中查找
        int res = findTarget(mountainArr, 0, top, target, true);
        //若未找到，则在右边降序中查找
        if(res != -1) return res;
        return findTarget(mountainArr,top+1,len-1,target,false);
    }

    //找到山峰元素的索引
    private int findTop(MountainArray mountainArray,int left,int right){
        while (left < right){
            int mid = left + (right - left) / 2;
            if(mountainArray.get(mid) < mountainArray.get(mid+1)){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        //由于一定能找到，所以循环结束后就是要找的值
        return left;
    }

    //找到左升序或右降序中的目标值，flag=true表示升序
    private int findTarget(MountainArray mountainArray, int left, int right, int target, boolean flag){
        while (left < right){
            int mid = left + (right - left) / 2;
            //说明是在左升序
            if(flag){
                if(mountainArray.get(mid) < target){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }else { //右降序
                if(mountainArray.get(mid) > target){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            //注意这种情况需要判断等于，，，
//            if(flag){
//                if(mountainArray.get(mid) >= target){
//                    right = mid;
//                }else {
//                    left = mid + 1;
//                }
//            }else { //右降序
//                if(mountainArray.get(mid) <= target){
//                    right = mid;
//                }else {
//                    left = mid + 1;
//                }
//            }
        }
        if(mountainArray.get(left) == target){
            return left;
        }
        return -1;
    }

}

interface MountainArray {
    public int get(int index);
    public int length();
}

class MountainArrayImpl implements MountainArray{
    int[] arr;

    public MountainArrayImpl(int[] arr){
        this.arr = arr;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int length() {
        return arr.length;
    }
}