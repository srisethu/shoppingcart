<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new User</title>
<link rel="stylesheet" href="../../css/shoppingCartStyle.css">
</head>
<body>
<h1>Register</h1>
    <form:form method="POST" action="/saveUser" modelAttribute="userDetail">
        <table  align="center">
            <tr>
                <th><form:label path="name">Username : </form:label></th>
                <th><form:input path="name" /></th>
                <th><form:errors path="name" class="alert" /></th>
            </tr>
            <tr>
                <th><form:label path="password">Password : </form:label></th>
                <th><form:password path="password"  /></th>
                <th><form:errors path="password" class="alert" /></th>
            </tr>
            <tr>
                <td colspan="3" class="center"><input type="submit" value="Register User" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>