/**
 * Created by Administrator on 2017/5/19 0019.
 */
$(function(){
    $(".loginform_submit").click(function(){
        if(checkInput()) {
            $("form").action("/loginServlet");
        }else{
            return false;
        }
    });
    $(".validationCode_img").click(function(){
        $(".validationCode_img").attr("src","/UserLogin/Sample1/validationCode?"+Math.random());
    });
    function checkInput(){
        //判断用户名
        if($("input[name=username]").val() == null || $("input[name=username]").val() == ""){
            alert("用户名不能为空");
            $("input[name=username]").focus();
            return false;
        }



        //判断密码
        if($("input[name=password]").val() == null || $("input[name=password]").val() == ""){
            alert("密码不能为空");
            $("input[name=password]").focus();
            return false;
        }

        //判断用户名admin
        if($("input[name=username]").val() !== 'admin' && $("input[name=password]").val() !== 'admin'){
            alert("用户名或密码错误");
            $("input[name=username]").focus();
            return false;
        }
        else window.location.href='index.jsp'
        /*
        //判断验证码
        if($("input[name=validationCode]").val() == null || $("input[name=validationCode]").val() == ""){
            alert("验证码不能为空");
            $("input[name=validationCode]").focus();
            return false;
        }
        */
        return true;
    }
});