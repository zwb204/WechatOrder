<html>
<head>
    <meta charset="utf-8">
    <title>卖家端订单详情</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-4 column">
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>订单id</th>
                        <th>订单总金额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${orderDTO.orderId}</td>
                        <td>${orderDTO.orderAmount}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <#--订单详情表数据-->
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>商品id</th>
                        <th>商品名称</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>总额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list orderDTO.getOrderDetailList() as orderDetail>
                        <tr>
                            <td>${orderDetail.productId}</td>
                            <td>${orderDetail.productName}</td>
                            <td>${orderDetail.productPrice}</td>
                            <td>${orderDetail.productQuantity}</td>
                            <td>${orderDetail.productPrice * orderDetail.productQuantity}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
        <#--操作-->
        <div class="row clearfix">
            <div class="col-md-12 column">
                <#if orderDTO.getOrderStatusEnum().getCode() == 0>
                    <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}">
                        <button type="button" class="btn btn-default btn-primary">完结订单</button>
                    </a>
                    <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">
                        <button type="button" class="btn btn-default btn-danger">取消订单</button>
                    </a>
                </#if>
            </div>
        </div>
    </div>
</div>
</body>
</html>