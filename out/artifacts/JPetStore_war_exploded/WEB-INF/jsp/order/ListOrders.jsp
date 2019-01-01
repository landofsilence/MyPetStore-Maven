<%@ include file="../common/IncludeTop.jsp"%>
<div id="Catalog">
<h2>My Orders</h2>

<table>
	<tr>
		<th>Order ID</th>
		<th>Date</th>
		<th>Total Price</th>
	</tr>

	<c:if test="${sessionScope.orderList == null}">
		<tr>
			<td colspan="3"><b>Your order is empty.</b></td>
		</tr>
	</c:if>

	<c:forEach var="order" items="${sessionScope.orderList}">
		<tr>
			<td><a href="viewOrder?orderId=${order.orderId}">
			    ${order.orderId}
			  </a></td>
			<td><fmt:formatDate value="${order.orderDate}"
				pattern="yyyy/MM/dd HH:mm:ss" /></td>
			<td><fmt:formatNumber value="${order.totalPrice}"
				pattern="$#,##0.00" /></td>
		</tr>
	</c:forEach>
</table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>


