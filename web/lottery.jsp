<%--
  Created by IntelliJ IDEA.
  User: Lifeix
  Date: 15-2-2
  Time: 下午12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>广西拓瑞能源有限公司年会抽奖活动</title>
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.burn.min.js"></script>
    <script type="text/javascript" src="js/myjs.js"></script>
    <link rel="stylesheet" type="text/css" href="css/mycss.css">
</head>
<body>

<div class="divcenter">
    <br />
    <h1 class="burning">广西拓瑞能源有限公司年会抽奖活动</h1><br />
    <a href="#nogo" class="button05">抽奖 ♥</a>
</div>
<div class="divcenter">
    <%--<h1 id="lotteryText" style="display:none;">抽奖中……</h1>--%>

        <div class="wrap">
            <div class="curve3">
            </div>
            <div class="curve2">
                <div class="text">
                    奖
                </div>
            </div>
            <div class="curve">
                <div class="topleft">
                </div>
                <div class="bottomright">
                </div>
            </div>
            <div class="bottomleft glow">
            </div>
            <div class="topright">
            </div>
        </div>


        <br />
        <br />
    <img src="#" id="img1" style="display:none;">
    <h2>一等奖剩余名额：<label id="one1"><font color="red">${sessionScope.numberOne}</font></label></h2>
    <h2>二等奖剩余名额：<label id="two2"><font color="red">${sessionScope.numberTwo}</font></label></h2>
    <h2>三等奖剩余名额：<label id="thr3"><font color="red">${sessionScope.numberThree}</font></label></h2>
</div>
</body>
</html>
