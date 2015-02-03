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
public class AjaxLotteryServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = null;
        //获得多少等奖
        String lottery = "three" ;
        HttpSession session = request.getSession();
        String sumStr = (String) session.getAttribute("sum");
        int sum = 50 ;
        if (!"".equals(sumStr)){
            sum = Integer.valueOf(sumStr);
        }
        int randomNum = (int) (Math.random() * sum) + 1;
//        int randomNum = (int) Math.round(Math.random() * sum) + 1;
        String numberOneStr = (String) session.getAttribute("numberOne");
        int numberOne = 0 ;
        if (!"".equals(numberOneStr)){
            numberOne = Integer.valueOf(numberOneStr);
        }
        String numberTwoStr = (String) session.getAttribute("numberTwo");
        int numberTwo = 0 ;
        if (!"".equals(numberTwoStr)){
            numberTwo = Integer.valueOf(numberTwoStr);
        }
        String numberThreeStr = (String) session.getAttribute("numberThree");
        int numberThree = 0 ;
        if (!"".equals(numberThreeStr)){
            numberThree = Integer.valueOf(numberThreeStr);
        }
        int loteryInt ;
        if (randomNum > 15 && randomNum < 51){
            loteryInt = 3;
        } else if (randomNum > 5 && randomNum < 16){
            loteryInt = 2;
        } else {
            loteryInt = 1;
        }
        if (numberOne != 0 || numberTwo != 0 || numberThree != 0){
            if (loteryInt == 1){
                if (numberOne == 0){
                    request.getRequestDispatcher("ajaxLottery").forward(request,response);
                } else {
                    numberOne -- ;
                    session.setAttribute("numberOne",numberOne+"");
                }
            } else if (loteryInt == 2){
                if (numberTwo == 0){
                    request.getRequestDispatcher("ajaxLottery").forward(request,response);
                } else {
                    numberTwo -- ;
                    session.setAttribute("numberTwo",numberTwo+"");
                }
            } else if (loteryInt == 3){
                if (numberThree == 0){
                    request.getRequestDispatcher("ajaxLottery").forward(request,response);
                } else {
                    numberThree -- ;
                    session.setAttribute("numberThree",numberThree+"");
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
