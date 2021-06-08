<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Report</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<center>
<div class="container">
<br>
<h2>Account Report</h2>
<hr>
<table class="table table-bordered table-hover">
<tr style="background-color:azure">
<th>Account Number
<th>Name
<th>Type
<th>Balance
</tr>
<%
Connection con;
PreparedStatement pst;
ResultSet rs;

try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?user=root&password=shubham");
	pst=con.prepareStatement("select * from accounts;");
	
	rs=pst.executeQuery();
	while(rs.next())
	{
		%>
	<tr>
	<td><%=rs.getString("accno") %>
	<td><%=rs.getString("accnm") %>
	<td><%=rs.getString("acctype") %>
	<td><%=rs.getString("balance") %>
	</tr>	
		<%
	}
	con.close();
}
catch(Exception e)
{
	out.println(e);
}
%>
</table>
<br><br>
<a href="index.jsp">Back</a>
</div>
</center>
</body>
</html>