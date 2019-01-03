function captchaOnClick() {
    var time = new Date().getTime();
    document.getElementById("captchaImage").src = "imageServlet?d=" + time;
}

function signonCheck() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var wrong = null;

    if(username == "" || password == ""){
        wrong = "Username or Password is EMPTY!!!";
    }

    if(wrong == null){
        return true;
    } else {
        var signonWrong = document.getElementById("signonWrong");
        signonWrong.innerHTML = wrong;
        return false;
    }

}

function editAccountCheck() {

    var repeatedPassword = document.getElementById("repeatedPassword").value;
    var password = document.getElementById("password").value;

    var wrong = null;

    if(repeatedPassword != password){
        wrong = "RepeatedPassword and Password should be SAME!!!";
    }

    if(wrong == null){
        return true;
    } else {
        var editWrong = document.getElementById("editWrong");
        editWrong.innerHTML = wrong;
        return false;
    }
}

function newAccountCheck() {

    var repeatedPassword = document.getElementById("repeatedPassword").value;
    var password = document.getElementById("password").value;
    var username = document.getElementById("username").value;

    var wrong = null;

    if(repeatedPassword == "" || username == "" || password == ""){
        wrong = "Username or Password is EMPTY!!!";
    } else if(repeatedPassword != password){
        wrong = "RepeatedPassword and Password should be SAME!!!";
    }

    if(wrong == null){
        return true;
    } else {
        var newWrong = document.getElementById("newWrong");
        newWrong.innerHTML = wrong;
        return false;
    }
}

var xmlHttpRequest;
function createXMLHttpRequest() {
    if(window.XMLHttpRequest){
        xmlHttpRequest = new XMLHttpRequest();
    } else if(window.ActiveXObject){
        xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
    } else {
        xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function usernameIsExist() {
    var username = document.registerForm.username.value;
    sendRequest("usernameIsExist?username=" + username);
}

function sendRequest(url) {
    createXMLHttpRequest();
    xmlHttpRequest.open("GET", url, true);
    xmlHttpRequest.onreadystatechange = processResponse;
    xmlHttpRequest.send(null);
}

function processResponse(){
    if (xmlHttpRequest.readyState == 4){
        if (xmlHttpRequest.status == 200){
            var responseInfo = xmlHttpRequest.responseXML.getElementsByTagName("msg")[0].firstChild.data;
            var div = document.getElementById("usernameInfo");

            if(responseInfo == "Exist"){
                div.append("<p class='wrong' align='center'>Username Is Exist!</p>");
            } else {
                div.append("<p class='right' align='center'>Username Is Not Exist!</p>");
            }
        }
    }
}

$("#keyword").keyup(function () {
    var keyword = $("#keyword").val();
    if(keyword == ""){
        $("#completion").css("display", "none");
        return;
    }
    var time = new Date().getTime();

    $.ajax({
        type:"post",
        url:"completion",
        data:{name:keyword, time:time},
        success:function(data){
            //拼接html
            var res = JSON.parse(data);
            var html = "";
            for(var i=0;i<res.products.length;i++){
                //每一个div还有鼠标移出、移入点击事件
                html+="<li><a href='#'>"+res.products[i].name +"</a></li>";
                //<a href='viewProduct?productId=" + res.products[i].productId + "'>"+res.products[i].name +"</a>
            }
            $("#completion").html(html);
            //显示为块级元素
            if(res.products.length != 0) {
                var left = $("#keyword").offset().left;
                var tops = $("#keyword").offset().top + 2;
                $(".completion").css("left", left);
                $(".completion").css("top", tops);
                $(".completion").css("display", "block");
            } else {
                $(".completion").css("display", "none");
            }
        }
    });
});

$("#keyword").blur(function () {
    $(".completion").css("display", "none");
});

$("#keyword").focus(function () {
    var keyword = $("#keyword").val();
    if(keyword == ""){
        $("#completion").css("display", "none");
        return;
    }
    var time = new Date().getTime();

    $.ajax({
        type:"post",
        url:"completion",
        data:{name:keyword, time:time},
        success:function(data){
            //拼接html
            var res = JSON.parse(data);
            var html = "";
            for(var i=0;i<res.products.length;i++){
                //每一个div还有鼠标移出、移入点击事件
                html+="<li><a href='#'>"+res.products[i].name +"</a></li>";
                //<a href='viewProduct?productId=" + res.products[i].productId + "'>"+res.products[i].name +"</a>
            }
            $("#completion").html(html);
            //显示为块级元素
            if(res.products.length != 0) {
                var left = $("#keyword").offset().left;
                var tops = $("#keyword").offset().top + 2;
                $(".completion").css("left", left);
                $(".completion").css("top", tops);
                $(".completion").css("display", "block");
            } else {
                $(".completion").css("display", "none");
            }
        }
    });
});

$(".number").keyup(function () {
    var number = $(this).val();
    var itemId = $(this).parent().parent().children("#item").children("#itemId").text();
    var price = $(this).parent().parent().children(".price").text().substring(1);
    var total = $(this).parent().parent().children(".total");
    var tip = $(this).parent().parent().parent().children(".tipTr").children(".tipTd").children(".wrong");

    var reg =/^[1-9]*[1-9][0-9]*$/;
    if(reg.test(number)){
        sendRequest("changeCart?itemId=" + itemId + "&quantity=" + number);
        total.html("$" + number * price);
        tip.html("");
    } else {
        tip.html("Quantity must be POSITIVE INTEGER!!!");
    }


})

$(".inputCaptcha").blur(function () {
    var inputCaptcha = $(this).val();
    var captcha = null;
    $.ajax({
        type:"post",
        url:"getCaptcha",
        success:function(data){
            captcha = data;
            if(inputCaptcha.toLowerCase() == captcha.toLowerCase()){
                $(".wrong").css("color", "#00ff00")
                $(".wrong").html("Captcha is RIGHT!!!")
            } else {
                $(".wrong").css("color", "#ff0000")
                $(".wrong").html("Captcha is WRONG!!!")
                captchaOnClick();
            }
            console.log("inputCaptcha = " + inputCaptcha);
            console.log("\ncaptcha = " + captcha);
        }
    });


})