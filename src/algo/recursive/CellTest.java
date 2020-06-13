package algo.recursive;

/**
 * @author Stephen
 * @date 2020/3/25 9:54
 */
public class CellTest {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(allCells(n));
    }

    //A是初始态， B是幼年态，C是成熟态，再下一个阶段就消亡了
    public static int allCells(int n){
        return cellA(n) + cellB(n) + cellC(n);
    }

    //假设每个小时为一个阶段，当前阶段的初始态，是上一个阶段所有状态的细胞分裂出来的。
    //因此为cellA(n-1) + cellB(n-1) + cellC(n-1)
    private static int cellA(int n) {
        if(n == 1){
            return 1;
        }
        return cellA(n-1) + cellB(n-1) + cellC(n-1);
    }

    //当前阶段的幼年态，是上一个阶段的所有初始态分裂出来的
    private static int cellB(int n) {
        if(n == 1){
            return 0;
        }
        return cellA(n-1);
    }

    //当前阶段的成熟态，只能是上一个阶段所有有的幼年态分裂出来的
    private static int cellC(int n) {
        if(n == 1 || n == 2){
            return 0;
        }
        return cellB(n-1);
    }
}
