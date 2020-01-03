package com.test.search;

/**
 * @Author wanbei
 * @DATE 2018/9/29 11:10
 * 深度优先搜索
 * 如123,有123,132,213,231,312,321种全排列
 * 以手拿扑克牌放入相等个盒子中为模型
 */
public class DepthSearch {
    int[] a = new int[10]; //a代表盒子,把扑克放入盒子中
    int[] book = new int[10]; //标记手中是否有此张牌
    int n = 0;
    public static void main(String[] args) {
        DepthSearch search = new DepthSearch();
        search.n = 3; //n为1~9之间的整数
        search.dfs(1);
    }

    public void dfs(int step){
        int i = 0;
        if(step == n + 1){ //说明站在n+1个盒子面前,结束边界
            for (i = 1; i <= n; i++) {
                System.out.printf(a[i]+" ");
            }
            System.out.println("");
            return;
        }

        //在step个盒子面前应该放哪张牌,按照1,2,3,n的顺序一一尝试
        for(i=1;i<=n;i++){
            if(book[i] == 0){ //表示i号扑克还在手中
                a[step] = i; //把i号扑克放入第sept个盒子中
                book[i] = 1; //表示i号扑克已经不再手中

                dfs(step + 1); //需要在setp的下一个盒子中放扑克,递归调用自己
                book[i] = 0; //必须把刚才的扑克收回,才能进行下一次尝试,非常重要!
            }
        }
    }

}
