  <%--
  Created by IntelliJ IDEA.
  User: 24518
  Date: 2018/12/4
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../common/IncludeTop.jsp"%>

  <div class="nav-box text-color">
      <ul class="f-nav" id='f-nav'>
          <li>Main</li>
          <li>Fish</li>
          <li>Dogs</li>
          <li>Cats</li>
          <li>Reptiles</li>
          <li>Birds</li>
          <div class='sideline'></div></ul>

<div id="BackLink">
    <a href="viewProduct?productId=${sessionScope.item.productId}">Return to ${sessionScope.item.productId}</a>
</div>

<div id="Catalog">

    <table>
        <tr>
            <td>${sessionScope.product.description}</td>
        </tr>
        <tr>
            <td><b> ${sessionScope.item.itemId} </b></td>
        </tr>
        <tr>
            <td><b><font size="4"> ${sessionScope.item.attribute1}
                ${sessionScope.item.attribute2} ${sessionScope.item.attribute3}
                ${sessionScope.item.attribute4} ${sessionScope.item.attribute5}
                ${sessionScope.product.name} </font></b></td>
        </tr>
        <tr>
            <td>${sessionScope.product.name}</td>
        </tr>
        <tr>
            <td><c:if test="${sessionScope.item.quantity <= 0}">
                Back ordered.
            </c:if> <c:if test="${sessionScope.item.quantity > 0}">
                ${sessionScope.item.quantity} in stock.
            </c:if></td>
        </tr>
        <tr>
            <td>$${sessionScope.item.listPrice}</td>
        </tr>

        <tr>
            <td>
                <a class="Button" href="addItemToCart?itemId=${sessionScope.item.itemId}">Add to Cart</a>
            </td>
        </tr>
    </table>

</div>

      <script type="text/javascript">

          var category = '${sessionScope.category.name}';
          var typeNumber = 0;
          switch (category) {
              case 'Fish':
                  typeNumber = 1;
                  break;
              case 'Dogs':
                  typeNumber = 2;
                  break;
              case  'Cats':
                  typeNumber = 3;
                  break;
              case 'Reptiles':
                  typeNumber = 4;
                  break;
              case 'Birds':
                  typeNumber = 5;
                  break;

          }
          $('#f-nav').tooltip({
              default: typeNumber + 1,       // 默认为空  --  选中默认值
              width: '277',     // 限制宽度
              height: '100',
              textList: ['Main' ,'Fish' ,'Dogs','Cats', 'Reptiles' , 'Birds'],   // 每个导航的内容
              type: 'slideMove',  // 必填, 选择内容
              success: function(ret){

              }   //初始化回调
          });

      </script>

<%@ include file="../common/IncludeBottom.jsp"%>




