package com.banking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqlconnection.bean.DBConnector;

/**
 * Servlet implementation class DeleteAccount
 */
@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccount() {
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
			
			
			Connection con;
			PreparedStatement pst;
			
			DBConnector dbc= new DBConnector();
		    con=dbc.getDbconnection();
			pst=con.prepareStatement("delete from accounts where accno=?;");
			pst.setInt(1, accno);
			int cnt = pst.executeUpdate();
			if(cnt>0)
			{
				out.println("<h2>Account Deleted Successfully</h2>");
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
