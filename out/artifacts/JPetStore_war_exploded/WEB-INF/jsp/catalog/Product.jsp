<%--
  Created by IntelliJ IDEA.
  User: 24518
  Date: 2018/12/4
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="viewCategory?categoryId=${sessionScope.product.categoryId}">Return to ${sessionScope.product.categoryId}</a>
</div>

<div id="Catalog">

    <h2>${sessionScope.product.name}</h2>

    <table>
        <tr>
            <th>Item ID</th>
            <th>Product ID</th>
            <th>Description</th>
            <th>List Price</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach var="item" items="${sessionScope.itemList}">
            <tr>
                <td>
                    <a href="viewItem?itemId=${item.itemId}">${item.itemId}</a>
                </td>
                <td>${item.productId}</td>
                <td>${item.attribute1} ${item.attribute2} ${item.attribute3}
                        ${item.attribute4} ${item.attribute5}</td>
                <td>$${item.listPrice}</td>
                <td>
                    <a class="Button" href="addItemToCart?itemId=${item.itemId}">Add to Cart</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
            </td>
        </tr>
    </table>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>






