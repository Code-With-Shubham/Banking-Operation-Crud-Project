package com.banking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.beans.FundsTransfer;



/**
 * Servlet implementation class TransferBean
 */
@WebServlet("/TransferBean")
public class TransferBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferBean() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		int fromacc,toacc;
		double amount;
		fromacc=Integer.parseInt(request.getParameter("facc"));
		toacc=Integer.parseInt(request.getParameter("tacc"));
		amount=Double.parseDouble(request.getParameter("amt"));
		
		FundsTransfer ft = new FundsTransfer();
		ft.setFaccno(fromacc);
		ft.setTaccno(toacc);
		ft.setAmt(amount);
		String stat= ft.getStatus();
		if(stat.equals("success"))
			response.sendRedirect("TransferDone.jsp");
		else
			response.sendRedirect("TransferFailed.jsp");
	}


}
