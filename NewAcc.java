package com.banking.servlet;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqlconnection.bean.DBConnector;

/**
 * Servlet implementation class NewAcc
 */
@WebServlet("/NewAcc")
public class NewAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		try
		{
			int accno=Integer.parseInt(request.getParameter("accno"));
			String accnm=request.getParameter("accnm");
			String typ=request.getParameter("typ");
			double bal=Double.parseDouble(request.getParameter("bal"));
			
			Connection con;
			PreparedStatement pst;
			
			DBConnector dbc= new DBConnector();
		    con=dbc.getDbconnection();
			pst=con.prepareStatement("insert into accounts values(?,?,?,?);");
			pst.setInt(1, accno);
			pst.setString(2, accnm);
			pst.setString(3, typ);
			pst.setDouble(4, bal);
			int cnt = pst.executeUpdate();
			if(cnt>0)
			{
				out.println("<h2>Account Created Successfully</h2>");
				out.println("<hr><br><a href='index.jsp'>Home</a>");
			}
			else
			{
				out.println("<h2>Failed...</h2>");
				out.println("<hr><br><a href='index.jsp'>Home</a>");
			}
			con.close();
		}
		catch(Exception e)
		{
			out.println("Error : "+e.getMessage());
		}
	}

}
