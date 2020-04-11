<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部书籍展示页面</title>

    <style>
         a{
            text-decoration:none;
            color:black;
            font-size:18px;
         }
         h3{
            width:180px;
            height:3px;
            margin:100px auto;
            text-align:center;
            line-height:38px;
            background:deepskyblue;
            border-radius:5px;
         }
    </style>
</head>
<body>
    <h3>
        <%--注意这里取绝对地址--%>
        <a href="${pageContext.request.contextPath}/book/allBook">进入书籍展示页面</a>
    </h3>
</body>
</html>