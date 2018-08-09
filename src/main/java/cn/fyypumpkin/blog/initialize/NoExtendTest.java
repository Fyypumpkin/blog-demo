package cn.fyypumpkin.blog.initialize;

/**
 * @author fyypumpkin on 2018/8/8
 */
public class NoExtendTest {
    public static String staticField = "静态变量";

    public String normalField = "普通成员变量";

    static {
        System.out.println(staticField);
        System.out.println("静态初始化块");
    }

    {
        System.out.println(normalField);
        System.out.println("普通初始化块");
    }

    public NoExtendTest(){
        System.out.println("构造器");
    }

}

class Main {
    public static void main(String[] args) {
//        System.out.println(NoExtendTest.staticField); //会加载静态变量和静态初始化块

        // 可以看到，当初始化一个实例的时候，一次的加载顺序是
        // 静态变量
        // 静态初始化块
        // 普通成员变量
        // 普通初始化块
        // 构造器
        new NoExtendTest();
    }
}