<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2022/10/14
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <style>
        div{
            margin: 30px 0;
        }
        .file-img{
            max-width: 100px;
        }
    </style>
</head>
<body>
    <div>
        <form action="/file/upload" method="post" enctype="multipart/form-data" >
            <div>
                <img id="img_1" class="file-img">
                <input type="file" name="filename" multiple="multiple" onchange="changeImg(this,1)" />
            </div>
            <div>
                <input type="file" name="filename" multiple="multiple" />
            </div>
            <div>
                <input type="file" name="filename" multiple="multiple" />
            </div>
            <input type="submit" value="文件上传" />
        </form>
    </div>

    <script>

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
