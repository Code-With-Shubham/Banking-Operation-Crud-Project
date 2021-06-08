<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="bootstrap.min.css" rel="stylesheet">
<title>Search Account with Ajax</title>
</head>
<body>
<%
int no=Integer.parseInt(request.getParameter("ano"));
String nm="Not Found",ty="NA";
double bal=0.0;
Connection con;
PreparedStatement pst;
ResultSet rs;
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?user=root&password=shubham");
	pst=con.prepareStatement("select * from accounts where accno=?;");
	pst.setInt(1,no);
	rs=pst.executeQuery();
	if(rs.next())
	{
		nm=rs.getString("accnm");
		ty=rs.getString("acctype");
		bal=rs.getDouble("balance");
	}
	con.close();
}
catch(Exception e)
{
	out.println(e);
}
%>
<div class="container">
<h4>Search Result</h4>
<p style="color:purple;font-size:19px">
Name : <%=nm %>
<br>
Type : <%=ty %>
<br>
Balance : <%=bal %>
</p>
</div>
</body>
</html>