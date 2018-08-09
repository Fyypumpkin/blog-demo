package cn.fyypumpkin.blog.initialize;

/**
 * @author fyypumpkin on 2018/8/8
 */
public class NoInit {

    public static void main(String[] args) {
        // 不会触发初始化
        Super[] test = new Super[10];

    }
}
class Father {
    public static String parentStaticField = "父类静态变量";
    static
    {
        System.out.println(parentStaticField);
        System.out.println("父类静态初始化块");
    }

    public Father() {
        System.out.println( "父类构造器" );
    }

}

class Son extends Super {
    public static String sonStaticField = "子类静态变量";
    static
    {
        System.out.println(sonStaticField);
        System.out.println("子类静态初始化快");
    }
    public Son() {
        System.out.println( "子类构造器" );
    }
}
