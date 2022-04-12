<%--
  Created by IntelliJ IDEA.
  User: trand
  Date: 4/12/2022
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h1>Add product</h1>
<form method="post">
    <table>
        <tr>
            <th>Name</th>
            <td><input name="name" type="text" size="50px"></td>
        </tr>
<tr>
            <th>Price</th>
            <td><input name="price" type="text" size="50px"></td>
        </tr>
<tr>
            <th>Quantity</th>
            <td><input name="quantity" type="text" size="50px"></td>
        </tr>
<tr>
            <th>Color</th>
            <td><input name="color" type="text" size="50px"></td>
        </tr>
<tr>
            <th>Description</th>
            <td><input name="description" type="text" size="50px"></td>
        </tr>
<tr>
            <th>Category</th>
            <td><select name="category" id="category">
                <c:forEach items="${categories}" var="category">
                    <option value="${category.getId()}">${category.getName()}</option>
                </c:forEach>
            </select></td>
        </tr>
    </table>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
