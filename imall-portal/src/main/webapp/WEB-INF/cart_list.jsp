<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="header.jsp" %>
    <title>天天生鲜-购物车</title>
    <link rel="stylesheet" type="text/css" href="/static/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/static/css/main.css">
</head>
<body>

<%@ include file="top.jsp" %>

<div class="total_count">全部商品<em>2</em>件</div>
<ul class="cart_list_th clearfix">
    <li class="col01">商品名称</li>
    <li class="col02">商品单位</li>
    <li class="col03">商品价格</li>
    <li class="col04">数量</li>
    <li class="col05">小计</li>
    <li class="col06">操作</li>
</ul>

<c:forEach items="${list}" var="cartVO">
    <ul class="cart_list_td clearfix">
        <li   class="col01">
            <c:if test="${cartVO.checked == 1}">
                <input onclick="updateCheck(this.checked, ${cartVO.id})" type="checkbox" name="" checked>
            </c:if>
            <c:if test="${cartVO.checked == 0}">
                <input onclick="updateCheck(this.checked, ${cartVO.id})" type="checkbox" name="" >
            </c:if>
        </li>
        <li class="col02"><img src="${cartVO.mainImageUrl}"></li>
        <li class="col03">${cartVO.productName}<br><em>1个</em></li>
        <li class="col04">1个</li>
        <li class="col05">${cartVO.productPrice}</li>
        <li class="col06">
            <div class="num_add">
                <a href="javascript:;" class="add fl">+</a>
                <input type="text" class="num_show fl" value="${cartVO.quantity}">
                <a href="javascript:;" class="minus fl">-</a>
            </div>
        </li>
        <li class="col07">${cartVO.productPrice * cartVO.quantity}</li>
        <li class="col08"><a href="javascript:;">删除</a></li>
    </ul>
</c:forEach>

<ul class="settlements">
    <li class="col01"><input type="checkbox" name="" checked=""></li>
    <li class="col02">全选</li>
    <li class="col03">合计(不含运费)：<span>¥</span><em>42.60</em><br>共计<b>2</b>件商品</li>
    <li class="col04"><a href="/order/getConfirmOrderPage">去结算</a></li>
</ul>

<div class="footer">
    <div class="foot_link">
        <a href="#">关于我们</a>
        <span>|</span>
        <a href="#">联系我们</a>
        <span>|</span>
        <a href="#">招聘人才</a>
        <span>|</span>
        <a href="#">友情链接</a>
    </div>
    <p>CopyRight © 2016 北京天天生鲜信息技术有限公司 All Rights Reserved</p>
    <p>电话：010-****888 京ICP备*******8号</p>
</div>


<script>
    function updateCheck(check, id) {
        var checked = check ? 1 : 0;
        $.post(
            '/cart/updateChecked',
            {'checked' : checked, 'id' : id},
            function (jsonResult) {
                if (jsonResult.ok) {
                    mylayer.okMsg(jsonResult.msg);
                } else {
                    mylayer.errorMsg(jsonResult.msg);
                }
            },
            'json'
        );
    }
</script>
</body>
</html>