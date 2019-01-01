<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

    <div>

        <h2>Shopping Cart</h2>
            <form action="updateCart" method="post">
                <table>
                    <tr>
                        <th><b>Item ID</b></th>
                        <th><b>Product ID</b></th>
                        <th><b>Description</b></th>
                        <th><b>In Stock?</b></th>
                        <th><b>Quantity</b></th>
                        <th><b>List Price</b></th>
                        <th><b>Total Cost</b></th>
                        <th>&nbsp;</th>
                    </tr>

                    <c:if test="${sessionScope.cart.numberOfItems == 0}">
                        <tr>
                            <td colspan="8"><b>Your cart is empty.</b></td>
                        </tr>
                    </c:if>

                    <c:forEach var="cartItem" items="${sessionScope.cart.cartItemList}">
                        <tr>
                            <td id="item">
                                <a id="itemId" href="viewItem?itemId=${cartItem.item.itemId}">${cartItem.item.itemId}</a>
                            </td>
                            <td>${cartItem.item.productId}</td>
                            <td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
                                    ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                                    ${cartItem.item.attribute5} ${cartItem.item.product.name}</td>
                            <td>${cartItem.inStock}</td>
                            <td>
                                <input type="text" id="number" class="number" name="${cartItem.item.itemId}" value="${cartItem.quantity}">
                            </td>
                            <td class="price"><fmt:formatNumber value="${cartItem.item.listPrice}"
                                                  pattern="$#,##0.00"/></td>
                            <td class="total"><fmt:formatNumber value="${cartItem.total}"
                                                  pattern="$#,##0.00"/></td>
                            <td>
                                <a href="removeItemFromCartServlet?itemId=${cartItem.item.itemId}" class="Button">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr class="tipTr">
                        <td class="tipTd" colspan="7">
                            <!--<input type="submit" value="Update Cart">-->
                            <p class="wrong"></p>
                        </td>
                        <td>
                            &nbsp;
                        </td>
                    </tr>
                </table>
            </form>

        <c:if test="${sessionScope.cart.numberOfItems > 0}">

            <a href="checkout" class="Button">Proceed to Checkout</a>
        </c:if>
    </div>

    <div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>

