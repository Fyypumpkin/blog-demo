package cn.fyypumpkin.blog.initialize;

/**
 * @author fyypumpkin on 2018/8/8
 */
public class ExtendTest {

    public static void main(String[] args) {
        // 父类静态变量
        // 父类静态初始化块
        // 子类静态变量
        // 子类静态初始化块
        String test = Child.childStaticField;

//        // 父类静态变量
//        // 父类静态初始化块
//        // 子类静态变量
//        // 子类静态初始化块
//        // 父类变量
//        // 父类初始化块
//        // 父类构造器
//        // 子类变量
//        // 子类初始化块
//        // 子类构造器
//        new Child();

    }
}

class Super {
    public static String parentStaticField = "父类静态变量";

    public static final String gst = "aaa";

    public String parentField = "父类变量";

    static {
        System.out.println( parentStaticField );
        System.out.println( "父类静态初始化块" );
    }


    {
        System.out.println( parentField );
        System.out.println( "父类初始化块" );
    }

    public Super() {
        System.out.println( "父类构造器" );
    }
}

class Child extends Super {
    public static String childStaticField = "子类静态变量";

    public String childField = "子类变量";


    static
    {
        System.out.println( childStaticField );
        System.out.println( "子类静态初始化块" );
    }


    {
        System.out.println( childField );
        System.out.println( "子类初始化块" );
    }

    public Child()
    {
        System.out.println( "子类构造器" );
    }
}