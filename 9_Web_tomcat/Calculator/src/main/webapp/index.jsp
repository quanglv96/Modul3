<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        from input{
            text-align: center;
        }
        td input,th label{
            text-align: left;
        }
    </style>
</head>
<body>
<h1>Calculator</h1>
<form method="post" action="Calculator">
    <table>
        <tr>
        <th><label>First Operand:</label></th>
        <td><input type="text" name="firstNum"/></td>
        </tr>
        <tr>
            <th><label> Operrator:</label></th>
            <td>
                <select name="operrator">
                    <option value="addition">Addition</option>
                    <option value="subtraction">Subtraction</option>
                    <option value="multiplication">Multiplication</option>
                    <option value="division">Division</option>
                </select>
            </td>
        </tr>
        <tr>
            <th><label> Operrator:</label></th>
            <td><input type="text" name="secondNum"></td>
        </tr>
    </table>
    <input type="submit" value="Calculate"/>
</form>
</body>
</html>