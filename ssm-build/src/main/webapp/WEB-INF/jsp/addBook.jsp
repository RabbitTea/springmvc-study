<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加书籍页面</title>

    <%-- BootStrap美化 : 可以下载也可以引用在线的CDN--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">

            <%--清除浮动--%>
            <div class="row clearfix">
               <div class="col-md-12 column">
                   <div class="page-header">
                        <h1>
                           <small>新增书籍</small>
                        </h1>
                   </div>
               </div>
            </div>

            <form action="${pageContext.request.contextPath}/book/addBook" method="post">
              <div class="form-group">
                <label for="bkname">书籍名称</label>
                <input type="text" name="bookName" class="form-control" id="bkname" required>
              </div>
              <div class="form-group">
                <label for="bkcount">书籍数量</label>
                <input type="text" name="bookCounts" class="form-control" id="bkcount" required>
              </div>
              <div class="form-group">
                <label for="bkdetail">书籍描述</label>
                <input type="text" name="detail" class="form-control" id="bkdetail" required>
              </div>

              <button type="submit" class="btn btn-default">添加</button>
            </form>
    </div>

</body>
</html>