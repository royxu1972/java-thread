package chapter6atomic.section2BasicType;

import java.util.concurrent.atomic.LongAccumulator;

/**
 * LongAccumulator Demo
 */
public class LongAccumulatorTest {
    /**
     * 输出结果是：
     *          9
     *          45
     *  含义是3乘以之前的值left
     */
    public static void main(String[] args) {
        //输入一个数字，如果比上一个输入的大，则直接返回，如果小，则返回上一个
        LongAccumulator longAccumulator = new LongAccumulator((left, right) ->
                left * right, 3L
        );

        longAccumulator.accumulate(3L);
        System.out.println(longAccumulator.get());
        longAccumulator.accumulate(5L);
        System.out.println(longAccumulator.get());
    }

}
