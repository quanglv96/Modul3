<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        table ,td,th{
            border: 1px solid black;
        }
        td{
            height: 40px ;
            width: 100px;
        }
        td img{
            width: 40px;
        }
    </style>
</head>
<body>
<%! public static class Customer {
    private String name;
    private String birthday;
    private String address;
    private String image;


    public Customer(String name, String birthday, String address, String image) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String toString() {
        return "<tr>" +
                "<td>" + getName() + "</td>" +
                "<td>" + getBirthday() + "</td>" +
                "<td>" + getAddress() + "</td>" +
                "<td><img src=" + getImage() + " width=\"30px\" height=\"30px\"></td>";
    }
}
%>
<%!
    ArrayList<Customer> customers = new ArrayList<>();
%>
<%
    customers.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "RE58TFK.jpg"));
    customers.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "RE58TFK.jpg"));
    customers.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "RE58TFK.jpg"));
    customers.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "RE58TFK.jpg"));
    customers.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "RE58TFK.jpg"));
%>
<h1>Danh Dách Khách Hàng</h1>
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa chỉ</th>
        <th>ảnh</th>
    </tr>
    <% for (int i = 0; i < customers.size(); i++) {
        out.println(customers.get(i).toString());
    }
    %>
</table>
</body>
</html>