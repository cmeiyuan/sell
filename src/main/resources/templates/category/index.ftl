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
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/seller/category/save">

                        <div class="form-group">
                            <label>名称</label>
                            <input type="text" name="categoryName" class="form-control"
                                   value="${(category.categoryName)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>类型</label>
                            <input type="number" name="categoryType" class="form-control"
                                   value="${(category.categoryType)!''}"/>
                        </div>

                        <input hidden name="categoryId" value="${(category.categoryId)!''}">

                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
