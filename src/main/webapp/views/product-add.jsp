<%--
  Created by IntelliJ IDEA.
  User: Mak
  Date: 11/15/2023
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            padding: 5%;
        }
    </style>
</head>
<body>
<h1>Add new Product</h1>
<form:form action="./result" method="post" modelAttribute="product">
    <div class="mb-3">
        <label for="name" class="form-label fs-4">Product Name</label>
        <form:input type="text" class="form-control" id="name" path="name" placeholder="Đậu phụ làng Mơ" />
    </div>
    <div class="mb-3">
        <label for="price" class="form-label fs-4">Product Price</label>
        <form:input type="text" class="form-control" id="price" path="price" placeholder="5000" />
    </div>
    <div class="mb-3">
        <label for="description" class="form-label fs-4">Product Description</label>
        <form:input type="text" class="form-control" id="description" path="description" placeholder="Sản phẩm mới hàng ngày" />
    </div>
    <div class="mb-3">
        <label for="categoryId" class="form-label fs-4">Category ID</label>
        <form:input type="text" class="form-control" id="categoryId" path="categoryId" placeholder="1" />
    </div>
    <p class="fs-4">Product Status</p>
    <div class="form-check">
        <form:radiobutton class="form-check-input" path="status" id="true" value="true" checked="checked" />
        <label class="form-check-label" for="true">
            🟢
        </label>
    </div>
    <div class="form-check">
        <form:radiobutton class="form-check-input" path="status" id="false" value="false" />
        <label class="form-check-label" for="false">
            🔴
        </label>
    </div>
    <button class="btn btn-primary" type="submit">Add</button>
</form:form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
