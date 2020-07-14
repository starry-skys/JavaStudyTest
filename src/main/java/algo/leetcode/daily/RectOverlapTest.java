package algo.leetcode.daily;

public class RectOverlapTest {
    public static void main(String[] args) {
        int[] rec1 = {0,0,1,1};
        int[] rec2 = {1,0,2,1};
        System.out.println(isRectangleOverlap1(rec1,rec2));
    }

    public static boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        //非，左侧，右侧，上方，下方
        return !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
    }

    //rec1 = [0,0,2,2], rec2 = [1,1,3,3]
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        double x1 = (rec1[0] + rec1[2]) / 2.0;
        double y1 = (rec1[1] + rec1[3]) / 2.0;
        double x2 = (rec2[0] + rec2[2]) / 2.0;
        double y2 = (rec2[1] + rec2[3]) / 2.0;

        double offsetX = (Math.abs(rec1[0] - rec1[2]) + Math.abs(rec2[0] - rec2[2])) / 2.0;
        double offsetY = (Math.abs(rec1[1] - rec1[3]) + Math.abs(rec2[1] - rec2[3])) / 2.0;

        if(Math.abs(x1 - x2) < offsetX && Math.abs(y1 - y2) < offsetY){
            return true;
        }

        return false;
    }
}
