<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <head>

    <title>Ajax异步</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

    <script>
      function a(){
           $.post({
                url:"${pageContext.request.contextPath}/a1",
                data:{"name":$("#username").val()},
                success: function (data, status) {
                    //alert(data);
                    console.log("data="+data);
                    console.log("status="+status);  //200：成功； 300：重定向或转发  400..:客户端错误；500..：服务器错误
                }
                error:function () {

                }
            })
      }

    </script>

  </head>

<body>

    <%--失去焦点的时候，发起一个请求（携带信息）到后台--%>
    用户名：<input type="text" id="username" onblur="a()">


</body>
</html>
