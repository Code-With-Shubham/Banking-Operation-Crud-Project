package com.banking.beans;

import java.sql.*;

import com.sqlconnection.bean.DBConnector;

public class FundsTransfer
{
	private int faccno;
	private int taccno;
	private double amt;
	private String status;

	public FundsTransfer()
	{
		faccno=0;
		taccno=0;
		amt=0.0;
		status="";
		
		
	}

	public String getStatus() {
		return status;
	}

	public void setFaccno(int faccno) {
		this.faccno = faccno;
	}

	public void setTaccno(int taccno) {
		this.taccno = taccno;
	}

	public void setAmt(double amt) {
		this.amt = amt;
		transferAmount();
	}
	public void transferAmount()
	{
		Connection con;
		PreparedStatement pst;
		try
		{
			DBConnector dbc= new DBConnector();
		    con=dbc.getDbconnection();
			pst=con.prepareStatement("update accounts set balance=balance-? where accno=?;");
			pst.setDouble(1, amt);
			pst.setInt(2, faccno);
			int cnt=pst.executeUpdate();
			if(cnt>0)
			{
				pst=con.prepareStatement("update accounts set balance=balance+? where accno=?;");
				pst.setDouble(1, amt);
				pst.setInt(2, taccno);
				pst.executeUpdate();
				status="success";
			}
			else
				status="failed";
			
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			status="error";
		}
	}
}

