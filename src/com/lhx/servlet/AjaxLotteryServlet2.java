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
public class AjaxLotteryServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = null;
        //获得多少等奖
        String lottery = null ;
        HttpSession session = request.getSession();
//        String sumStr = (String) session.getAttribute("sum");
//        int sum = 50 ;
//        if (!"".equals(sumStr)){
//            sum = Integer.valueOf(sumStr);
//        }
        double randomDouble = Math.random();
//        int randomNum = (int) Math.round(Math.random() * sum) + 1;
//        double randomRatio = (double)randomNum / sum ;
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
        //获得多少等奖
//        int loteryInt ;
        //一等奖比率
        String radio1Str = (String)session.getAttribute("radio1");
        double radio1 = Double.valueOf(radio1Str);
        //二等奖比率
        String radio2Str = (String)session.getAttribute("radio2");
        double radio2 = Double.valueOf(radio2Str);
        //三等奖比率
        String radio3Str = (String)session.getAttribute("radio3");
        double radio3 = Double.valueOf(radio3Str);
        if (randomDouble >= 0 && randomDouble < radio2){
            lottery = "two" ;
        } else if (randomDouble >= (1-radio2) && randomDouble < 1){
            lottery = "one";
        } else {
            lottery = "three";
        }
        if (numberOne != 0 || numberTwo != 0 || numberThree != 0){
            if ("three".equals(lottery)){
                if (numberThree == 0){
                    request.getRequestDispatcher("ajaxLottery").forward(request,response);
                } else {
                    numberThree -- ;
                    session.setAttribute("numberThree",numberThree+"");
                }
            } else if ("two".equals(lottery)){
                if (numberTwo == 0){
                    request.getRequestDispatcher("ajaxLottery").forward(request,response);
                } else {
                    numberTwo -- ;
                    session.setAttribute("numberTwo",numberTwo+"");
                }
            } else if ("one".equals(lottery)){
                if (numberOne == 0){
                    request.getRequestDispatcher("ajaxLottery").forward(request,response);
                } else {
                    numberOne -- ;
                    session.setAttribute("numberOne",numberOne+"");
                }
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

            String jsonstr = FastJsonUtil.object2json(map);
            Thread.sleep(1000);
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
