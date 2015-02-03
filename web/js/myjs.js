/**
 * Created by Lifeix on 15-2-2.
 */

$(function(){
    $('.burning').burn();
    $(".button05").bind('click',function(){
        $(this).css("display","none") ;//添加不可见的样式，防止重复点击
        $(".wrap").show();
        $("#img1").hide();
        $("#lotteryText").show();
        $.ajax({
            type:'POST',
            contentType: "application/json",
            url: "/ajaxLottery",
            dataType: "json",
            success:function(data){
                if (data.flagover == false){
                    $("#lotteryText").hide();
                    $(".wrap").hide();
                    if(data.lottery == "one"){
                        $("#img1").attr("src","/img/one.jpg");
                        $("#img1").show();
                        if (data.numberOne == "0"){
                            $("#one1").html("<font color=\"red\">名额已抽完！等明年咯……</font>") ;
                        } else {
                            $("#one1").html("<font color=\"red\">" + data.numberOne + "</font>") ;
                        }
                        $(".button05").show();
                    } else if (data.lottery == "two"){
                        $("#img1").attr("src","/img/two.jpg");
                        $("#img1").show();
                        if (data.numberTwo == "0"){
                            $("#two2").html("<font color=\"red\">名额已抽完！等明年咯……</font>") ;
                        } else {
                            $("#two2").html("<font color=\"red\">" + data.numberTwo + "</font>") ;
                        }
                        $(".button05").show();
                    } else {
                        $("#img1").attr("src","/img/three.jpg");
                        $("#img1").show();
                        if (data.numberThree == "0"){
                            $("#thr3").html("<font color=\"red\">名额已抽完！等明年咯……</font>") ;
                        } else {
                            $("#thr3").html("<font color=\"red\">" + data.numberThree + "</font>") ;
                        }
                        $(".button05").show();
                    }
                } else {
                    $(".wrap").hide();
                    $("#img1").attr("src","/img/flagover.jpg");
                    $("#img1").show();
                }
            }
        });
    });
});


