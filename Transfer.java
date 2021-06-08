package com.banking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqlconnection.bean.DBConnector;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
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
		
			int fromacc,toacc;
			double amount;
			fromacc=Integer.parseInt(request.getParameter("facc"));
			toacc=Integer.parseInt(request.getParameter("tacc"));
			amount=Double.parseDouble(request.getParameter("amt"));
			
			
			Connection con;
			PreparedStatement pst;
			try
			{
				DBConnector dbc= new DBConnector();
			    con=dbc.getDbconnection();
				pst=con.prepareStatement("update accounts set balance=balance-? where accno=?;");
				pst.setDouble(1, amount);
				pst.setInt(2, fromacc);
				int cnt=pst.executeUpdate();
				if(cnt>0)
				{
					pst=con.prepareStatement("update accounts set balance=balance+? where accno=?;");
					pst.setDouble(1, amount);
					pst.setInt(2, toacc);
					pst.executeUpdate();
					if(cnt>0)
					{
						out.println("<h2>Transaction Successfull..</h2>");
						out.println("<hr><br><a href='index.jsp'>Home</a>");
					}
					else
					{
						out.println("<h2>Transaction Failed...</h2>");
						out.println("<hr><br><a href='index.jsp'>Home</a>");
					}
					con.close();
				}
			}
			catch(Exception e)
			{
				out.println("Error : "+e.getMessage());
			}
	}
				
}
