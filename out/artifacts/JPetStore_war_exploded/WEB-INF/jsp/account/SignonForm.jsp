<%--
  Created by IntelliJ IDEA.
  User: 24518
  Date: 2018/12/5
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../common/IncludeTop.jsp" %>

    <div id="Catalog">
        <form action="Signon" method="post" onsubmit=" return signonCheck()">
            <p>Please enter your username and password.</p>
            </p>
            <p>Username:<input id="username" type="text" name="username" /><br />
                Password:<input id="password" type="password" name="password" /><br />
                <img alt="Captcha" id="captchaImage" onclick="captchaOnClick()" src="imageServlet"/> <br />
                Captcha:<input type="text" name="inputCaptcha"class="inputCaptcha" /><br />
            </p>
            <p id="signonWrong" class="wrong">
                ${requestScope.msg}
            </p>
            <input type="submit" name="signon" value="Sign on" />
        </form>

        Need a account name and password?
        <a href="registerForm">Register Now!</a>

    </div>

    <%@ include file="../common/IncludeBottom.jsp" %>


