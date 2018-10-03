<html>
<#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">
<#--边栏sidebar-->
<#include "../common/nav.ftl">
<#--主要内容content-->

    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">

            <#--表格-->

                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">

                        <thead>
                        <tr>
                            <th>商吕ID</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>

                        <tbody>
                        <#list productInfoPage.content as productInfo>
                        <tr>
                            <td>${productInfo.productId}</td>
                            <td>${productInfo.productName}</td>
                            <td><img src="${(productInfo.productIcon)!''}" width="80" height="80"></td>
                            <td>${productInfo.productPrice}</td>
                            <td>${productInfo.productStock}</td>
                            <td>${productInfo.productDescription}</td>
                            <td>${productInfo.categoryType}</td>
                            <td>${productInfo.createTime}</td>
                            <td>${productInfo.updateTime}</td>
                            <td><a href="/seller/product/index?productId=${productInfo.productId}">修改</a></td>
                            <#if productInfo.getProductStatusEnum().getMessage() == "在架">
                                <td><a href="/seller/product/off_sale?productId=${productInfo.productId}">下架</a></td>
                            <#else >
                                <td><a href="/seller/product/on_sale?productId=${productInfo.productId}">上架</a></td>
                            </#if>
                        </tr>
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
                        <li><a href="/seller/product/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#assign totalPages = productInfoPage.getTotalPages()>
                    <#if totalPages lt 10>
                        <#assign maxCount = totalPages>
                    <#else>
                        <#assign maxCount = 10>
                    </#if>
                    <#if totalPages - currentPage lt 5>
                        <#assign end = totalPages>
                        <#assign start = end - maxCount + 1>
                    <#else>
                        <#if currentPage - 4 lt 1>
                            <#assign start = 1>
                        <#else>
                            <#assign start = currentPage - 4>
                        </#if>
                        <#assign end = start + maxCount - 1>
                    </#if>

                    <#list start..end as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/seller/product/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage == productInfoPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/seller/product/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>

                    </ul>
                </div>

            </div>
        </div>
    </div>

</div>

</body>
</html>
