<%--
  Created by IntelliJ IDEA.
  User: xiayu
  Date: 2018/12/11
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp" %>
<div id="Catalog">
<table>
    <tr>
        <th>Date</th>
        <th>Action</th>
    </tr>

    <c:forEach var="record" items="${sessionScope.appearList}">
        <tr>
            <td><fmt:formatDate value="${record.date}"
                                pattern="yyyy/MM/dd HH:mm:ss" /></td>
            <td>${record.description}</td>
        </tr>
    </c:forEach>
</table>
</div>
<div id="Catalog">
    <c:if test="${sessionScope.page > 0}">
        <a href="viewRecord?page=${sessionScope.page - 1}" style="alignment:left">Previous</a>
    </c:if>
    <c:if test="${!sessionScope.isLast}">
        <a href="viewRecord?page=${sessionScope.page + 1}" style="alignment:right">Next</a>
    </c:if>
</div>
<%@ include file="../common/IncludeBottom.jsp" %>