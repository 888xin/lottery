package com.lhx.servlet;

import com.lhx.util.FastJsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by lhx on 15-2-2 下午2:02
 *
 * @project lottery
 * @package ${PACKAGE_NAME}
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class AjaxLotteryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = null;
        //获得多少等奖
        String lottery = null ;
        HttpSession session = request.getSession();
        double randomDouble = Math.random();
        String numberOneStr = (String) session.getAttribute("numberOne");
        int numberOne = 0 ;
        if (!"".equals(numberOneStr)){
            numberOne = Integer.valueOf(numberOneStr);
        }
        //获取二等奖数目
        String numberTwoStr = (String) session.getAttribute("numberTwo");
        int numberTwo = 0 ;
        if (!"".equals(numberTwoStr)){
            numberTwo = Integer.valueOf(numberTwoStr);
        }
        //获取三等奖数目
        String numberThreeStr = (String) session.getAttribute("numberThree");
        int numberThree = 0 ;
        if (!"".equals(numberThreeStr)){
            numberThree = Integer.valueOf(numberThreeStr);
        }

        //获取固定的数目
        String oneStr = (String) session.getAttribute("one");
        int one = Integer.valueOf(oneStr);
        String twoStr = (String) session.getAttribute("two");
        int two = Integer.valueOf(twoStr);
        String threeStr = (String) session.getAttribute("three");
        int three = Integer.valueOf(threeStr);

        Object datasObject = session.getAttribute("datas");
        int[] datas = (int[]) datasObject;
        String sumStr = (String) session.getAttribute("sum");
        int sum = Integer.valueOf(sumStr);
        if (sum > 0){
            if (datas[sum-1] <= three){
                lottery = "three" ;
                numberThree -- ;
                session.setAttribute("numberThree",numberThree+"");
            } else if (datas[sum-1] > (three+two)){
                lottery = "one";
                numberOne -- ;
                session.setAttribute("numberOne",numberOne+"");
            } else {
                lottery = "two";
                numberTwo -- ;
                session.setAttribute("numberTwo",numberTwo+"");
            }
            sum -- ;
            session.setAttribute("sum", sum+"");
        } else {
            try {
                response.setContentType("application/json; charset=utf-8");
                response.setCharacterEncoding("UTF-8");
                response.setHeader("Cache-Control", "no-cache");
                pw = response.getWriter();

                Map<String,Object> map = new HashMap<String, Object>();
                //活动结束
                map.put("flagover", true);

                String jsonstr = FastJsonUtil.object2json(map);
                pw.print(jsonstr);
                pw.flush();
            }catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if (pw != null)
                    pw.close();
            }
        }
        try {
            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            pw = response.getWriter();

            Map<String,Object> map = new HashMap<String, Object>();

            map.put("lottery",lottery);
            map.put("numberOne", numberOne);
            map.put("numberTwo", numberTwo);
            map.put("numberThree", numberThree);
            map.put("flagover", false);

            String jsonstr = FastJsonUtil.object2json(map);
            Thread.sleep(500);
            pw.print(jsonstr);
            pw.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (pw != null)
                pw.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
