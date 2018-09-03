<html>
<head>
    <meta charset="utf-8">
    <title>卖家订单列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">

    <#--表格-->
        <div class="col-md-12 column">
            <table class="table table-bordered table-condensed table-hover">

                <thead>
                <tr>
                    <th>订单ID</th>
                    <th>姓名</th>
                    <th>手机号</th>
                    <th>地址</th>
                    <th>金额</th>
                    <th>订单状态</th>
                    <th>支付方式</th>
                    <th>支付状态</th>
                    <th>创建时间</th>
                    <th colspan="2">操作</th>
                </tr>
                </thead>

                <tbody>
                <#list orderDTOPage.content as orderDTO>
                <tr>
                    <td>${orderDTO.orderId}</td>
                    <td>${orderDTO.buyerName}</td>
                    <td>${orderDTO.buyerPhone}</td>
                    <td>${orderDTO.buyerAddress}</td>
                    <td>${orderDTO.orderAmount}</td>
                    <td>${orderDTO.getOrderStatusEnum().message}</td>
                    <td>微信</td>
                    <td>${orderDTO.getPayStatusEnum().message}</td>
                    <td>${orderDTO.createTime}</td>
                    <td>
                        <a href="/seller/order/detail?orderId=${orderDTO.orderId}">详情</a>
                    </td>
                    <td>
                        <#if orderDTO.getOrderStatusEnum().message != "已取消">
                            <a href="/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                        </#if>
                    </td>
                </#list>
                </tbody>

            </table>
        </div>

    <#--分页-->
        <div class="col-md-12 column">
            <ul class="pagination pull-right">

            <#if currentPage == 1>
                <li class="disabled"><a href="#">上一页</a></li>
            <#else>
                <li><a href="/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
            </#if>

            <#list 1..orderDTOPage.getTotalPages() as index>

                <#if (index lt currentPage) && (index - currentPage) gte -4
                || (index gte currentPage) && (index - currentPage) lte 5
                || (index gte currentPage) && (currentPage lt 5) && (index - currentPage) lte (10 - currentPage)>
                    <#if currentPage == index>
                        <li class="disabled"><a href="#">${index}</a></li>
                    <#else>
                        <li><a href="/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                    </#if>
                </#if>

            </#list>

            <#if currentPage == orderDTOPage.getTotalPages()>
                <li class="disabled"><a href="#">下一页</a></li>
            <#else>
                <li><a href="/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
            </#if>

            </ul>
        </div>

    </div>
</div>
</body>
</html>
