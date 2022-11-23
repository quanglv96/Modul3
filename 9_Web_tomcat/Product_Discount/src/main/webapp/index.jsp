<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/discount" method="post">
    <h3>Product Discount Calculator</h3>
    <input type="text" name="description" placeholder="Product Description"/>
    <input type="text" name="listedPrice" placeholder="Listed price"/>
    <input type="text" name="discount" placeholder="Discount Percent"/>
    <input type="submit" id="submit" value="Calculate Discount"/>
</form>
</body>
</html>