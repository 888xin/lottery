package com.lhx.servlet;

import com.lhx.util.RadomSeries;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lhx on 15-2-2 上午11:52
 *
 * @project lottery
 * @package ${PACKAGE_NAME}
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class LotteryServlet extends HttpServlet {
    //一等奖名额
    private int numberOne = 5 ;
    //二等奖名额
    private int numberTwo = 10 ;
    //三等奖名额
    private int numberThree = 35 ;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //如果页面有定制名额，根据定制名额来计算
        String numberOneStr = request.getParameter("numberOne");
        if ( !"".equals(numberOneStr) ){
            numberOne = Integer.valueOf(numberOneStr) ;
        }
        String numberTwoStr = request.getParameter("numberTwo");
        if ( !"".equals(numberOneStr) ){
            numberTwo = Integer.valueOf(numberTwoStr) ;
        }
        String numberThreeStr = request.getParameter("numberThree");
        if ( !"".equals(numberThreeStr) ){
            numberThree = Integer.valueOf(numberThreeStr) ;
        }
        int sum = numberOne + numberTwo + numberThree ;
        int[] datas = RadomSeries.genRandomData(sum);
        HttpSession session = request.getSession();
        session.setAttribute("numberOne",numberOne+"");
        session.setAttribute("numberTwo",numberTwo+"");
        session.setAttribute("numberThree",numberThree+"");
        session.setAttribute("one",numberOne+"");
        session.setAttribute("two",numberTwo+"");
        session.setAttribute("three",numberThree+"");
        session.setAttribute("datas",datas);
        session.setAttribute("sum",sum + "");
        response.sendRedirect("/lottery.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
