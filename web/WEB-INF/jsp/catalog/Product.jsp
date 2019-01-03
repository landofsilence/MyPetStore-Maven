<%--
  Created by IntelliJ IDEA.
  User: 24518
  Date: 2018/12/4
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>


<%@ include file="../common/IncludeTop.jsp" %>

<div class="nav-box text-color">
    <ul class="f-nav" id='f-nav'>
        <li>Main</li>
        <li>Fish</li>
        <li>Dogs</li>
        <li>Cats</li>
        <li>Reptiles</li>
        <li>Birds</li>
        <div class='sideline'></div>
    </ul>
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
<%@ include file="../common/IncludeBottom.jsp" %>






