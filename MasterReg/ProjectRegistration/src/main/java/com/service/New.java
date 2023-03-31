package com.service;


import java.io.IOException;
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
 * Servlet implementation class New
 */
@WebServlet("/new")
public class New extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String idString = request.getParameter("eid");
		String nameString = request.getParameter("name");
		String mailString = request.getParameter("email");
		String contactString = request.getParameter("contact");
		try {
			Connection connection = GetConnection.connection();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into employees values(?,?,?,?)");
			preparedStatement.setString(1, idString);
			preparedStatement.setString(2, nameString);
			preparedStatement.setString(3, mailString);
			preparedStatement.setString(4, contactString);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
