function login() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    if (userName == null || userName == "") {
        $("#error").html("用户名不能为空！");
    } else if (password == null || password == "") {
        $("#error").html("密码不能为空！");
    } else {
        //Ajax实现
        $.post("login", "userName=" + userName + "&password=" + password, callBack);

        function callBack(data) {//入参表示响应结果
            if (data == 1) {
                //清空form表单核心代码
                $("#form :input").not(":button, :submit, :reset, :hidden").val("").removeAttr("checked").remove("selected");
                /*
                既能满足前台能移除 checkbox checked 属性，又能保留 checkbox value 值
                $("#form :input").not(":button, :submit, :reset, :hidden, :checkbox, :radio").val("");
                $("#form :input").removeAttr("checked").remove("selected");
                */
                $("#form").hide();
                $("#login_success span").html("欢迎登录：" + userName + " &nbsp;");
                $("#login_success").show();
            } else if (data == -1) {
                $("#error").html("用户名不存在，请联系管理员！");
            } else {
                $("#error").html("密码错误，请重新输入或联系管理员！");
            }
        }
    }
}

function logout() {
    //Ajax实现
    $.get("logout", callBack);

    function callBack() {//入参表示响应结果
        $("#form").show();
        $("#login_success").hide();
    }
}

function register() {
    window.open("register.html");
    /*location.href("register.html");*/
}

