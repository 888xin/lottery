package com.lhx.servlet;

/**
 * Created by lhx on 15-2-3 上午9:44
 *
 * @project lottery
 * @package com.lhx.servlet
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class MyMain {
    public static void main(String[] args) throws InterruptedException {
//        int numberOne = 11 ;
//        int sum = 51 ;
//        double radio1 = (double) numberOne / sum ;
//        System.out.println(radio1);

        for (int i = 0; i < 50; i++) {
            Thread.sleep(100);
            double randomDouble = Math.random();
            System.out.println(randomDouble);
        }
    }
}
