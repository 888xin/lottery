package com.lhx.util;

import com.alibaba.fastjson.JSON;

/**
 * Created by lhx on 14-12-10 下午4:15
 *
 * @project jspProject
 * @package com.lifeix.util
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @Description
 */
public class FastJsonUtil {
    /**
     * Object实体转换为json
     * @param object
     * @return
     */
    public static String object2json(Object object){
        JSON json = (JSON) JSON.toJSON(object);
        return json.toJSONString();
    }

//    public static void main(String[] args) {
//        Map<String,String> map = new HashMap<String, String>();
//        map.put("name","li");
//        map.put("age","23");
//        System.out.println(object2json(map));
//    }
}
