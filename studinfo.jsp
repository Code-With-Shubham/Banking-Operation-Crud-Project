<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Assignment</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<div class="container"></div>
<input type="text" name="mobile" class="form-control">
<br><h2>Insert Student Information</h2><br><hr><br>
<form name="frm" method="post" action="StudInfo">
<table>
<tr>
<td>Roll Number</td>
<td><input type="text" name="rollno" class="form-control"></td>
</tr>
<tr>
<td>Student Name</td>
<td><input type="text" name="name" class="form-control"></td>
</tr>
<tr>
<td>Class</td>
<td><input type="text" name="class" class="form-control"></td>
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="addr" class="form-control"></td>
</tr>
<tr>
<td>Mobile</td>
<td><input type="text" name="mobile" class="form-control"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Submit" class="form-control"></td>
</tr>
</table>
</form>
</div>
</body>
</html>