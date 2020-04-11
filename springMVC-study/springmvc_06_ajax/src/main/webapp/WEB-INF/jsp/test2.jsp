<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <head>

    <title>Ajax异步</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

    <script>
      function a(){
           $(function() {
              $("#btn").click( function() {
                   //console.log("111");
                   $.post("${pageContext.request.contextPath}/a2", function (data){
                       console.log(data);
                       var html="";

                       for (let i=0; i<data.length; i++){
                          html += "<tr>" +
                              "<td>" + data[i].name + "</td>" +
                              "<td>" + data[i].age + "</td>" +
                              "<td>" + data[i].sex + "</td>" +
                              "</tr>"
                       }
                   })

                   $("#content").html(html);
              })
           });
      }

    </script>

  </head>

<body>

    <input type="button" value="加载数据" id="btn">
    <table>
        <tr>
          <td>姓名</td>
          <td>年龄</td>
          <td>性别</td>
        </tr>

        <tbody>
          <%-- 数据在后台 --%>
        </tbody>
    </table>


</body>
</html>
