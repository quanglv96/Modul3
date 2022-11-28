<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        div div {
            float: left;
        }

        div form {
            padding: 50px;
        }

        .listProduct td, th {
            border: 1px solid black;
        }
        .color1{
            background: #0b2e13;
        }
        .color2{
            background: #4455b9;
        }
        .color3{
            background: #c54470;
        }
    </style>
</head>
<body>
<div class="color2">
    <h1>Quản lý sản phẩm</h1>
</div>
<div class="row">
    <div class="col-2 color1">
        <form method="get" action="/create">
            <button type="submit" name="create">Create</button>
        </form>
        <form method="post" action="/display">
            <button type="submit" name="display">Display</button>
        </form>
        <form method="get" action="/edit">
            <button type="submit" name="edit">Edit</button>
        </form>
        <form method="get" action="/delete">
            <button type="submit" name="edit">Delete</button>
        </form>
    </div>
    <div class="col-10 color3">
        <% String show = (String) request.getAttribute("show");%>
        <%if (show != null) {%>
        <% out.println(show);%>
        <%
            } else {
                out.println("Hello");
            }
        %>
    </div>
</div>
</body>
</html>