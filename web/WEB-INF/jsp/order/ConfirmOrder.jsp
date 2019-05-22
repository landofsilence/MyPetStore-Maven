<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink"><a href="index.html">
	Return to Main Menu
	</a></div>

<div id="Catalog">Please confirm the information below and then
press continue...

<table>
	<tr>
		<th align="center" colspan="2"><font size="4"><b>Order</b></font>
		<br />
		<font size="3"><b> <fmt:formatDate
			value="${sessionScope.order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" /></b></font>
		</th>
	</tr>

	<tr>
		<th colspan="2">Billing Address</th>
	</tr>
	<tr>
		<td>First name:</td>
		<td><c:out value="${sessionScope.order.billToFirstName}" /></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><c:out value="${sessionScope.order.billToLastName}" /></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><c:out value="${sessionScope.order.billAddress1}" /></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><c:out value="${sessionScope.order.billAddress2}" /></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><c:out value="${sessionScope.order.billCity}" /></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><c:out value="${sessionScope.order.billState}" /></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><c:out value="${sessionScope.order.billZip}" /></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><c:out value="${sessionScope.order.billCountry}" /></td>
	</tr>
	<tr>
		<th colspan="2">Shipping Address</th>
	</tr>
	<tr>
		<td>First name:</td>
		<td><c:out value="${sessionScope.order.shipToFirstName}" /></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><c:out value="${sessionScope.order.shipToLastName}" /></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><c:out value="${sessionScope.order.shipAddress1}" /></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><c:out value="${sessionScope.order.shipAddress2}" /></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><c:out value="${sessionScope.order.shipCity}" /></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><c:out value="${sessionScope.order.shipState}" /></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><c:out value="${sessionScope.order.shipZip}" /></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><c:out value="${sessionScope.order.shipCountry}" /></td>
	</tr>

	<td>&nbsp;</td>

	</tr>
    <table>
        <tr>
            <td><b>Item ID</b></td>
            <td><b>Product ID</b></td>
            <td><b>Description</b></td>
            <td><b>Quantity</b></td>
            <td><b>List Price</b></td>
            <td><b>Total Cost</b></td>
        </tr>

        <c:forEach var="cartItem" items="${sessionScope.order.lineItems}">
            <tr>
                <td>
                        ${cartItem.item.itemId}
                </td>
                <td>${cartItem.item.product.productId}</td>
                <td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
                        ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                        ${cartItem.item.attribute5} ${cartItem.item.product.name}</td>
                <td>${cartItem.quantity}</td>
                <td><fmt:formatNumber value="${cartItem.item.listPrice}"
                                      pattern="$#,##0.00" /></td>
                <td><fmt:formatNumber value="${cartItem.total}"
                                      pattern="$#,##0.00" /></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7">Sub Total: <fmt:formatNumber
                    value="${sessionScope.order.totalPrice}" pattern="$#,##0.00" /></td>
        </tr>
    </table>


</table>

<a href="insertOrder" class="Button">
Confirm
</a></div>

<%@ include file="../common/IncludeBottom.jsp"%>





