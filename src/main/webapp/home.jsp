<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Page</title>
</head>
<form action="addEmployee">
Employee ID: <input type="text" name="eid"><br>
Employee Name: <input type="text" name="ename"><br>
Employee Salary:<input type="text" name="salary"><br>
Employee Department:<input type="text" name="department"><br>
<input type="submit">
</form>
<form action="getEmployee">
Employee ID:<input type="text" name="eid"><br>
<input type="submit">
</form>
<body>
</body>
</html>