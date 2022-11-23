<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2022/10/10
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #logout{
            font-size: 40px;
        }
    </style>
</head>
<body>
    <div>
        <span id="logout">退出</span>
    </div>
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            $("#logout").click(function () {
                window.location.href="/user/logout";
            });
        });
    </script>
</body>
</html>
