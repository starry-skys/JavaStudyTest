package algo.recursive;

/**
 * @author Stephen
 * @date 2020/3/29 22:03
 */
public class Queen8Test {

    static int max = 8;
    static int[] arr = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        check(0);
        System.out.println(count);
    }

    private static void check(int n){
        if(n == max){
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            //从第一列开始摆放，循环判断是否冲突
            arr[n] = i;
            //如果没有冲突，就进入下一行
            if(judge(n)){
                check(n + 1);
            }
            //如果有冲突，就回溯到当前行，后移一个位置继续重试

        }
    }

    /**
     * 判断当前行的n列所在的皇后和之前的所有列是否有冲突，没有就返回true
     * @param n 表示第n个皇后
     * @return
     */
    private static boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //在同一列或者同一斜线返回false，不用判断同行，因为不可能同行
            if(arr[i] == arr[n] || Math.abs(i-n) == Math.abs(arr[i] - arr[n])){
                return false;
            }
        }
        return true;
    }

    private static void print(){
        count ++;
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
