<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <head>

    <title>入口页面</title>


  </head>

<body>

    <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
        <input type="file" name="file">
        <input type="submit" value="upload">
    </form>

    <a href="${pageContext.request.contextPath}/statics/1.png">下载图片</a>

</body>
</html>
