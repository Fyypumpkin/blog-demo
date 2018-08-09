package cn.fyypumpkin.blog.constant;

/**
 * @author fyypumpkin on 2018/8/9
 */
public class Test {
    public static void main(String[] args) {
        // new出来的直接会指向堆中的实例对象。同时发现字符串常量池中没有响应的字面量，于是会在字符串常量池中新建一个字面量为"hello"的常量，同时方法区中的会存放一份引用，下次在创建时，会直接返回该引用
        String str1 = new String("hello");
        // 直接使用字面量创建字符串，会返回常量池中的引用
        String str2 = "hello";

        // 会返回false，原因是str1指向的是堆中新建的实例，而str2中指向的是字符创常量池中的字面量，两者的引用不同
        System.out.println(str1 == str2);

        // 会返回false，因为str1指向的是堆中的，str intern指向的是常量池中的
        System.out.println(str1.intern() == str1);

        // 会返回true，原因是str1.intern方法会将该值加入到常量池中，并且返回常量池的引用，但是由于常量池中已经存在，所以intern返回的引用和str2的引用是同一个
        System.out.println(str1.intern() == str2);

        // String的加法操作会转换成StringBuilder的append操作，最后会使用toString方法返回一个字符串对象，
        // 由于该字符串在常量池中已经存在了，所以并不会触发赋值操作，导致常量池中的引用并不指向堆中的，str3指向堆中的对象。str3.intern指向常量池中的对象
        String str3 = new String("he") + new String("llo");

//         String str4 = new StringBuffer("he").append("llo").toString(); // 和str3等同

        String str5 = new String("a") + new String("b");
        // 返回true，验证一下上面的说法，调用intern后，发现常量池中没有响应的"ab"，所以直接在常量池中讲str5这个的对象引用进行保存，并返回接受，所以当常量池中没有相关数据的时候，
        // 就会在常量池中创建，常量池中会保存堆中对象的引用，（而new String则会在常量池中新增一份，所以new String拿到的并不是同一个）
        System.out.println(str5.intern() == str5);

        String str6 = new StringBuilder("1").append("111").toString();
        // 返回true，原因是Stringbuilder("1").append("111").toString();
        // 等价于 String a = "1"; String b = "111" StringBuilder(a).append(b).toString()，
        // 可以得知，1111是在堆中创建的，于是intern就会返回堆中的地址放入常量池
        System.out.println(str6.intern() == str6);

        String str7 = new StringBuilder("2").toString();
        // 返回false，原因是Stringbuilder("1")toString();
        // 等价于 String a = "2" StringBuilder(a).toString()，
        // 可以得知，2是在常量池中创建的，于是intern就会直接返回常量池中的地址，而new出来的地址会在堆中，所以是false，同样适用于new Sting（）
        System.out.println(str7.intern() == str6);

    }
}