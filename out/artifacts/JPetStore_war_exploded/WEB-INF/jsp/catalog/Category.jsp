<%--
  Created by IntelliJ IDEA.
  User: 24518
  Date: 2018/12/4
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../common/IncludeTop.jsp"%>

    <div id="BackLink">
        <a href="main">Return to Main Menu</a>
    </div>

    <div id="Catalog">

        <h2>${sessionScope.category.name}</h2>

        <table>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
            </tr>
            <c:forEach var="product" items="${sessionScope.productList}">
                <tr>
                    <td>
                        <a href="viewProduct?productId=${product.productId}">${product.productId}</a>
                    </td>
                    <td>${product.name}</td>
                </tr>
            </c:forEach>
        </table>

    </div>

<%@ include file="../common/IncludeBottom.jsp"%>



