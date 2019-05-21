<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="Catalog">
    <form action="updateAccount" method="post" onsubmit="return editAccountCheck()">

        <h3>User Information</h3>

        <table>
            <tbody>
            <tr>
                <td>User ID:</td>
                <td>${sessionScope.account.username}</td>
            </tr>
            <tr>
                <td>New password:</td>
                <td>
                    <input id="password" name="password" type="password">
                </td>
            </tr>
            <tr>
                <td>Repeat password:</td>
                <td>
                    <input id="repeatedPassword" name="repeatedPassword" type="password">
                </td>
            </tr>
            </tbody>
        </table>
        <h3>Account Information</h3>

        <table>
            <tbody>
            <tr>
                <td>First name:</td>
                <td><input name="firstName" value="${sessionScope.account.firstName}" type="text"></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><input name="lastName" value="${sessionScope.account.lastName}" type="text"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input name="email"
                           value="${sessionScope.account.email}" type="" size="40"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input name="phone" value="${sessionScope.account.phone}"
                           type="text"></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><input name="address1"
                           value="${sessionScope.account.addr1}" type="text" size="40"></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><input name="address2" value="${sessionScope.account.addr2}"
                           type="text" size="40"></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input name="city" value="${sessionScope.account.city}" type="text"></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input name="state" value="${sessionScope.account.state}" type="text"
                           size="4"></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><input name="zip" value="${sessionScope.account.zip}" type="text"
                           size="10"></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input name="country" value="${sessionScope.account.country}" type="text"
                           size="15"></td>
            </tr>
            </tbody>
        </table>

        <h3>Profile Information</h3>

        <table>
            <tbody>
            <tr>
                <td>Language Preference:</td>
                <td><select name="languagePreference">
                    <option selected="selected" value="CN">Chinese</option>
                    <option value="EN">English</option>
                    <option value="JP">Japanese</option>
                </select></td>
            </tr>
            <tr>
                <td>Favourite Category:</td>
                <td><select name="favouriteCategoryId">
                    <option value="FISH">FISH</option>
                    <option selected="selected" value="DOGS">DOGS</option>
                    <option value="REPTILES">REPTILES</option>
                    <option value="CATS">CATS</option>
                    <option value="BIRDS">BIRDS</option>
                </select></td>
            </tr>
            <tr>
                <td>Enable MyList</td>
                <td>
                    <c:if test="${sessionScope.account.listOption == true}">
                        <input name="listOption" value="true" type="checkbox" checked="checked">
                    </c:if>
                    <c:if test="${sessionScope.account.listOption != true}">
                        <input name="listOption" value="true" type="checkbox">
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>Enable MyBanner</td>
                <td>
                    <c:if test="${sessionScope.account.bannerOption == true}">
                        <input name="bannerOption" value="true" type="checkbox" checked="checked">
                    </c:if>
                    <c:if test="${sessionScope.account.bannerOption != true}">
                        <input name="bannerOption" value="true" type="checkbox">
                    </c:if>
                </td>
            </tr>
            <!--<tr>
                <td colspan="2"><img align="center" alt="Captcha" id="captchaImage" onclick="captchaOnClick()" src="imageServlet"/></td>
            </tr>
            <tr>
                <td>Captcha</td>
                <td><input type="text" class="inputCaptcha" name="inputCaptcha" /></td>
            </tr>-->

            </tbody>
        </table>

        <p id="editWrong" class="wrong">
            ${requestScope.msg}
        </p>

        <input name="editAccount" value="Save Account Information"
               type="submit">

    </form>
    <a href="viewOrder">My Orders</a>

    <br>
    <a href="viewRecord?page=0">My History</a>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>
