package cn.fyypumpkin.blog.hash.test01;

/**
 * 用于测试为何HashMap中容量要定义成2的幂次方
 * @author fyypumpkin on 2018/8/11
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Test.tableSizeFor(16));
        int h = "ha".hashCode();
        int length = 1 << 5; // 32
        int length2 = (1 << 5) - 1; // 31
        Test t = new Test();

        // 可以看到，当长度为2的幂次方时候，结果输出都为25
        System.out.println(t.getIndex(h, length) + " " + t.getIndexByPer(h, length));
        // 长度部位2的幂次方，结果就不同
        System.out.println(t.getIndex(h, length2) + " " + t.getIndexByPer(h, length2));

        // 结果
        // 25 25
        // 24 4

    }

    // length是数组的长度，h是hash码，计算对应下标，通过与运算
    private Integer getIndex (int h, int length) {
        return h & (length - 1);
    }

    // 通过取模
    private Integer getIndexByPer(int h, int length){
        return h % length;
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1000) ? 1000 : n + 1;
    }
}
