<html>
<#include "../common/header.ftl">
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <table class="table table-bordered table-hover table-condensed">
                <thead>
                <tr>
                    <th>订单ID</th>
                    <th>订单总金额</th>
                    <th>订单状态</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${orderDTO.getOrderId()}</td>
                    <td>${orderDTO.getOrderAmount()}</td>
                    <td>${orderDTO.getOrderStatusEnum().message}</td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="col-md-12 column">
            <table class="table table-bordered table-hover table-condensed">

                <thead>
                <tr>
                    <th>商品ID</th>
                    <th>商品名称</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>总额</th>
                </tr>
                </thead>

                <tbody>
                <#list orderDTO.getOrderDetailList() as orderDetail>
                <tr>
                    <td>${orderDetail.getDetailId()}</td>
                    <td>${orderDetail.getProductName()}</td>
                    <td>${orderDetail.getProductPrice()}</td>
                    <td>${orderDetail.getProductQuantity()}</td>
                    <td>${orderDetail.getProductPrice() * orderDetail.getProductQuantity()}</td>
                </tr>
                </#list>
                </tbody>

            </table>
        </div>

        <#if orderDTO.getOrderStatus() == 0>
            <div class="col-md-12 column">
                <a href="/seller/order/finish?orderId=${orderDTO.getOrderId()}" type="button" class="btn btn-default btn-primary">完结订单</a>
                <a href="/seller/order/cancel?orderId=${orderDTO.getOrderId()}" type="button" class="btn btn-default btn-danger">取消订单</a>
            </div>
        </#if>

    </div>
</div>

</body>
</html>