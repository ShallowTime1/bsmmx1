<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="header.jsp" %>
    <title>天天生鲜-用户中心</title>
    <link rel="stylesheet" type="text/css" href="/static/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/static/css/main.css">
</head>
<body>
<%@ include file="top.jsp" %>

<div class="main_con clearfix">
    <div class="left_menu_con clearfix">
        <h3>用户中心</h3>
        <ul>
            <li><a href="user_center_info.html">· 个人信息</a></li>
            <li><a href="user_center_order.html" class="active">· 全部订单</a></li>
            <li><a href="user_center_site.html">· 收货地址</a></li>
        </ul>
    </div>
    <div class="right_content clearfix">
        <h3 class="common_title2">全部订单</h3>
    <c:forEach items="${orderVOList}" var="orderVO">
        <ul class="order_list_th w978 clearfix">
            <li class="col01">2016-8-21 17:36:24</li>
            <li class="col02">订单号：${orderVO.orderNo}</li>
            <c:if test="${orderVO.status == 0}">
                <li class="col02 stress">已取消</li>
            </c:if>
            <c:if test="${orderVO.status == 10}">
                <li class="col02 stress">未付款</li>
            </c:if>
            <c:if test="${orderVO.status == 20}">
                <li class="col02 stress">已付款</li>
            </c:if>
            <c:if test="${orderVO.status == 30}">
                <li class="col02 stress">已发货</li>
            </c:if>
        </ul>
        <table class="order_list_table w980">
            <tbody>
            <tr>
                <td width="55%">
                    <c:forEach items="${orderVO.list}" var="orderItem">
                        <ul class="order_goods_list clearfix">
                            <li class="col01"><img src="${orderItem.mainImageUrl}"></li>
                            <li class="col02"
                                style="overflow: hidden">${orderItem.productName}<em>${orderItem.currentUnitPrice}/1</em>
                            </li>
                            <li class="col03">${orderItem.quantity}</li>
                            <li class="col04">${orderItem.totalPrice}</li>
                        </ul>
                    </c:forEach>
                </td>
                <td width="15%">${orderVO.payment}</td>
                <c:if test="${orderVO.status == 0}">
                    <td width="15%">已取消</td>
                </c:if>
                <c:if test="${orderVO.status == 10}">
                    <td width="15%">待付款</td>
                </c:if>
                <c:if test="${orderVO.status == 20}">
                    <td width="15%">已付款</td>
                </c:if>
                <c:if test="${orderVO.status == 30}">
                    <td width="15%">已发货</td>
                </c:if>
                <td width="15%"><a href="#" class="oper_btn">去付款</a></td>
            </tr>
            </tbody>
        </table>
        </c:forEach>

        <div class="pagenation">
            <a href="#">上一页</a>
            <a href="#" class="active">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">下一页></a>
        </div>
    </div>
</div>


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

</body>
</html>