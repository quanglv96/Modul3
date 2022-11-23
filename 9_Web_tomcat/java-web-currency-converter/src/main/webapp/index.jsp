<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        .curency {
            border: 1px solid dimgrey;
            width: 20%;
            margin: 0px;
            padding: 10px;
        }

        h3, h5 {
            text-align: left;
            padding-bottom: 0px;
        }
    </style>
</head>
<body>
<form method="post" action="/convert">
    <div class="curency">
        <h3>Currency Converter</h3>
        <label>Rate:</label><br>
        <input type="text" name="rate" placeholder="Rate" value="22000"/><br>
        <label>USD:</label><br>
        <input type="text" name="usd" placeholder="USD" value="0"/><br>
        <input type="submit" id="submit" value="Converter"/>
    </div>
</form>
</body>
</html>