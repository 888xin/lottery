package com.lhx.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhx on 15-2-3 下午2:07
 *
 * @project lottery
 * @package com.lhx.util
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class RadomSeries {

    public static int[] genRandomData(int n) {
        int[] datas = new int[n];
        List<Integer> dataList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            dataList.add(i+1);
        }
        int m = 0 ;
        while (dataList.size() > 0){
            int index = (int) (Math.random() * dataList.size());
            datas[m] = dataList.get(index);
            m ++ ;
            dataList.remove(index);
        }
        return datas ;
    }
}
