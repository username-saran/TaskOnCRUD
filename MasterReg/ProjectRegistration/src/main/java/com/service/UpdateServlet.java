package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.*;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n = 0;
		String idString = request.getParameter("eid");
		String nameString = request.getParameter("name");
		String mailString = request.getParameter("email");
		String contactString = request.getParameter("contact");
		PrintWriter ouPrintWriter = response.getWriter();
		ouPrintWriter.println(idString+" "+nameString+" "+mailString+" "+contactString);
		
		try {
			Connection connection = GetConnection.connection();
			PreparedStatement preparedStatement = connection.prepareStatement("update employees set EMPLOYEE_NAME = ?,EMPLOYEE_EMAIL=?,EMPLOYEE_NUMBER=? where EMPLOYEE_ID=?");
			preparedStatement.setString(1, nameString);
			preparedStatement.setString(2, mailString);
			preparedStatement.setString(3, contactString);
			preparedStatement.setString(4, idString);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ouPrintWriter.print(n);
		//PrintWriter printWriter = response.getWriter();
		response.sendRedirect("http://localhost:7070/ProjectRegistration/Show?");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}