<%--
  Created by IntelliJ IDEA.
  User: 张志伟
  Date: 2021/4/2
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath }/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

    <div class="row clearfix text-center">
        <div class="col-sm-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        <div class="form-group">
            <label for="bookName">书籍名称</label>
            <input type="text" name="bookName" class="form-control" id="bookName" required>
        </div>
        <div class="form-group">
            <label for="bookNum">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" id="bookNum" required>
        </div>
        <div class="form-group">
            <label for="detail">书籍详情</label>
            <input type="text" name="detail" class="form-control" id="detail" required>
        </div>
        <button type="submit" class="btn btn-default form-control">添加</button>
    </form>
</div>
</body>
</html>
