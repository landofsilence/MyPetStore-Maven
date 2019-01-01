<%--
  Created by IntelliJ IDEA.
  User: 24518
  Date: 2018/12/5
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../common/IncludeTop.jsp" %>



<div id="Catalog">

    <form action="register" method="post" name="registerForm" id="userInfo" onsubmit="return newAccountCheck()">

        <h3>User Information</h3>

        <table>
            <tr>
                <td>User ID:</td>
                <td id="usernameInfo">
                    <input type="text" name="username" id="username" onblur="usernameIsExist();"/>
                </td>
            </tr>
            <tr>
                <td>New password:</td>
                <td><input type="password" id="password" name="password" /></td>
            </tr>
            <tr>
                <td>Repeat password:</td>
                <td><input type="password" id="repeatedPassword" name="repeatedPassword"/></td>
            </tr>
        </table>

        <%@ include file="IncludeAccountFields.jsp" %>

        <p id="newWrong" class="wrong" align="center">
            ${requestScope.msg}
        </p>

        <input type="submit" name="newAccount" value="Save Account Information"/>

    </form>
</div>
<%@ include file="../common/IncludeBottom.jsp" %>
