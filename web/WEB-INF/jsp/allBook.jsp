<%--
  Created by IntelliJ IDEA.
  User: 张志伟
  Date: 2021/4/2
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>书籍展示页面</title>
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
                        <small>书籍列表——————显示所有书籍</small>
                    </h1>
                </div>
            </div>
        </div>
    </div>
    <%--添加书籍--%>
    <div class="row col-sm-4">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">添加书籍</a>
    </div>
    <%--查询书籍--%>
    <div class="row col-sm-4">
        <form action="${pageContext.request.contextPath}/book/queryBook" class="form-inline" method="post" >
            <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍">
            <input type="submit" value="查询" class="btn btn-primary">
        </form>
    </div>
    <%--显示全部书籍--%>
    <div class="row col-sm-4">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示全部书籍</a>
    </div>
    <div class="row text-center">
        <div class="col-sm-12 column">
            <table class="table table-bordered table-hover table-striped">
                <thead>
                <tr >
                    <th class="text-center">书籍编号</th>
                    <th class="text-center">书籍名称</th>
                    <th class="text-center">书籍数量</th>
                    <th class="text-center">书籍详情</th>
                    <th class="text-center">操作</th>
                </tr>
                </thead>
                <%--书籍从数据库中查询出来,从list中遍历出来--%>
                <tbody class="text-center">
                    <c:forEach var="book" items="${list}" >
                        <tr>
                            <td>${book.bookID}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a class="btn btn-info" href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.bookID}">
                                    修改
                                </a>
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/book/deleteBook?id=${book.bookID}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
