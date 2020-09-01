package algo.chain.circle;

/**
 * @author Stephen
 * @date 2020/3/28 17:36
 * 约瑟夫问题
 */
public class JosePhuTest {
    public static void main(String[] args) {
        SingleCircleBoy circleBoy = new SingleCircleBoy();
        circleBoy.addBoy(5);
        circleBoy.show();
        //测试k=1,m=2,n=5 。   2-4-1-5-3
        circleBoy.moveOut(1,2,5);
    }


}

class SingleCircleBoy {
    Boy first = null;
    //批量添加
    public void addBoy(int nums){
        if(nums < 1) return;

        Boy cur = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                cur = first;
                cur.setNext(first);
            }else{
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    //展示所有元素
    public void show(){
        if(first == null) return;
        Boy cur = first;
        while (true){
            System.out.println("当前节点编号:" + cur.getNo());
            if(cur.getNext() == first){
                break;
            }
            cur = cur.getNext();
        }
    }

    /**
     *
     * @param k 从第k个人开始数
     * @param m 数m下
     * @param n 总共有几个人
     */
    public void moveOut(int k, int m, int n){
        if(first == null || k < 1 || k > n){
            return;
        }
        //设置一个辅助节点指向first节点的前一个节点，以便出队
        Boy helper = first;
        for (int i = 0; i < n - 1; i++) {
            helper = helper.getNext();
        }
        //helper和first都移动 k -1 下，让first指向开始数的那个人
        for (int i = 0; i < k - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //数 m下，需要移动 m-1 次
        while (true){
            if(helper == first) break;
            for (int i = 0; i < m - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("节点"+first.getNo()+"出圈");
            //把first出队列
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后一个节点:" + first.getNo());

    }
}

class Boy {
    //编号
    private int no;
    //下一个指针
    private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no) {
        this.no = no;
    }
}
