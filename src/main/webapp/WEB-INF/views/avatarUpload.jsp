<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2022/10/14
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <style>
        .avatar{
            position: relative;
            width: 100px;
            height: 100px;
        }
        #img_1{
            position: absolute;
            top: 0;
            left: 0;
            width: 100px;
            height: 100px;
        }
        .inputFile{
            position: absolute;
            top: 0;
            left: 0;
            width: 100px;
            height: 100px;
            opacity: 0;
        }
        .file-img{
            max-width: 100px;
        }
    </style>
</head>
<body>
    <div>
        <form action="/file/avatarUpload" method="post" enctype="multipart/form-data" onsubmit="return formSubmit()">
            <div class="avatar">
                <c:choose>
                    <c:when test="${empty userSession.avatar}">
                        <img id="img_1" class="file-img" src="/static/imagesd/imgupload.png">
                    </c:when>
                    <c:otherwise>
                        <img id="img_1" class="file-img" src="/filePath/${userSession.avatar}">
                    </c:otherwise>
                </c:choose>
                <input id="inputFile1" class="inputFile" type="file" name="filename" multiple="multiple" onchange="changeImg(this,1)" />
            </div>
            <input type="text" name="userName">
            <%--<input type="submit" value="文件上传" />--%>
            <input type="button" value="文件上传2" id="submitBtn">
        </form>
    </div>

    <script src="/js/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            $("#submitBtn").click(function () {
                var formData = new FormData($('form')[0]);
                $.ajax({
                    url:"/file/avatarUpload2",
                    type:"post",
                    data: formData,
                    contentType:false,
                    processData:false,
                    success:function (res) {
                        if(res.code == 200){
                            window.location.href="/user/toMy";
                        }else{
                            alert(res.message);
                        }
                    }
                })
            });
        });
        
        
        function formSubmit() {
            var val = document.getElementById("inputFile1").value;
            return true;
        }
        
        
        function changeImg(file,index){
            var reader = new FileReader();    // 实例化一个FileReader对象，用于读取文件
            var img = document.getElementById('img_'+index);     // 获取要显示图片的标签
            //读取File对象的数据
            reader.onload = function(evt){
                img.src = evt.target.result;
            }
            reader.readAsDataURL(file.files[0]);
        }
    </script>
</body>
</html>
