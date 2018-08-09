package cn.fyypumpkin.blog.initialize;

/**
 * @author fyypumpkin on 2018/8/8
 */
public class FinalInit {
    public static void main(String[] args){
        // Final变量
        System.out.println(FinalFieldClass.finalField);
    }
}

class FinalFieldClass {

    public static String staticField = "静态变量";

    static {
        System.out.println("静态初始化块");
    }

    public static final String finalField = "Final变量";
}