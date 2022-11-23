<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2022/10/21
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link href="/css/mui.css" rel="stylesheet" />
</head>
<body>
    <h1>
        这是首页页面
    </h1>

    <jsp:include page="../common/tabbar.jsp">
        <jsp:param name="tabIndex" value="1"/>
    </jsp:include>

    <script src="/js/mui.js"></script>
    <script type="text/javascript">
        mui.init()

    </script>
</body>

</html>
