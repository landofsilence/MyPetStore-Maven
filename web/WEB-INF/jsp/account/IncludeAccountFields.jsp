<%--
  Created by IntelliJ IDEA.
  User: 24518
  Date: 2018/12/5
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>Account Information</h3>

<table>
    <tr>
        <td>First name:</td>
        <td><input type="text" name="firstName" /></td>
    </tr>
    <tr>
        <td>Last name:</td>
        <td><input type="text" name="lastName" /></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><input type="text" name="email" /></td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td><input type="text" name="phone" /></td>
    </tr>
    <tr>
        <td>Address 1:</td>
        <td><input type="text" name="address1" /></td>
    </tr>
    <tr>
        <td>Address 2:</td>
        <td><input type="text" name="address2" size="40" /></td>
    </tr>
    <tr>
        <td>City:</td>
        <td><input type="text" name="city" /></td>
    </tr>
    <tr>
        <td>State:</td>
        <td><input type="text" name="state" size="4" /></td>
    </tr>
    <tr>
        <td>Zip:</td>
        <td><input type="text" name="zip" size="10" /></td>
    </tr>
    <tr>
        <td>Country:</td>
        <td><input type="text" name="country" size="15" /></td>
    </tr>
</table>

<h3>Profile Information</h3>

<table>
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
        <td><input type="checkbox" name="listOption" value="1" /></td>
    </tr>
    <tr>
        <td>Enable MyBanner</td>
        <td><input type="checkbox" name="bannerOption" value="1" /></td>
    </tr>
    <!--<tr>
        <td colspan="2"><img align="center" alt="Captcha" id="captchaImage" onclick="captchaOnClick()" src="imageServlet"/></td>
    </tr>
    <tr>
        <td>Captcha</td>
        <td><input type="text" class="inputCaptcha" name="inputCaptcha" /></td>
    </tr>-->


</table>

