<%--
  Created by IntelliJ IDEA.
  User: Xin
  Date: 14-5-4
  Time: 上午11:27
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="/resources/jquery-1.4.min.js"></script>
    <script type="text/javascript" src="/resources/json.min.js"></script>
</head>
<body>
     <h1>Hello</h1>
     <a class="listBtn">List All</a>
</body>


<script>
    $(document).ready(function() {

        $('.listBtn').click(function(){
            $.getJSON('/hellos',null,function(data){
                console.log(data);
            });

        });

    })
</script>
</html>
