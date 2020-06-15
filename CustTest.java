public class CustTest {
    public void hello(){
        System.out.println("我是由" + this.getClass().getClassLoader() + "加载进来的");
    }

}
