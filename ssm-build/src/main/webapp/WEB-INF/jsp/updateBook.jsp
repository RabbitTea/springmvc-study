<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍页面</title>

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
                           <small>修改书籍</small>
                        </h1>
                   </div>
               </div>
            </div>

            <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
              <%-- id可以通过隐藏域传 --%>
              <input type="hidden" name="bookId" value="${QBook.bookId}">

              <div class="form-group">
                <label for="bkname">书籍名称</label>
                <input type="text" name="bookName" class="form-control" id="bkname" value="${QBook.bookName}" required>
              </div>
              <div class="form-group">
                <label for="bkcount">书籍数量</label>
                <input type="text" name="bookCounts" class="form-control" id="bkcount" value="${QBook.bookCounts}" required>
              </div>
              <div class="form-group">
                <label for="bkdetail">书籍描述</label>
                <input type="text" name="detail" class="form-control" id="bkdetail" value="${QBook.detail}" required>
              </div>

              <button type="submit" class="btn btn-default">修改</button>
            </form>
    </div>

</body>
</html>