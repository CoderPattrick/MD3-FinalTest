<%--
  Created by IntelliJ IDEA.
  User: trand
  Date: 4/12/2022
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form method="post">
    <input type="text" size="50px" placeholder="Product Name">
    <input type="submit" value="Search" style="color: white;background: blue"><br/>
    <a href="/ProductServlet?action=add">Add new product</a><br/>
    <a href="/ProductServlet?action=orderByPrice" >Order by price</a>
</form>
<c:if test="${products!=null}">
    <table border="1">
        <tr>
<th>#</th>
<th>Product Name</th>
<th>Price</th>
<th>Quantity</th>
<th>Color</th>
<th>Category</th>
<th>Action</th>
        </tr>
        <c:forEach items="${products}" var="product" >
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getQuantity()}</td>
                <td>${product.getColor()}</td>
                <td>${product.getCategory().getName()}</td>
                <td>
                    <button type="submit" formmethod="get" formaction="/ProductServlet?action=edit">edit</button>
                    <button type="submit" formmethod="get" formaction="/ProductServlet?action=delete">delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
