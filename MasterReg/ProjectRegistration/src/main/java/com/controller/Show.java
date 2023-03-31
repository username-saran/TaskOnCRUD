package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbutil.GetConnection;

/**
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int flag=1;
		PrintWriter out = response.getWriter();
		try 
		{
			out.print("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "     <meta charset=\"UTF-8\">\r\n"
					+ "     <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "     <title>Document</title>\r\n"
					+ "     <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n"
					+ "     <style>\r\n"
					+ "          body{\r\n"
					+ "               background-image: linear-gradient(rgb(8, 94, 109),lightgreen);\r\n"
					+ "               background-position: center;\r\n"
					+ "               background-repeat: no-repeat;\r\n"
					+ "               background-attachment: fixed;\r\n"
					+ "          }\r\n"
					+ "          .container-fluid{\r\n"
					+ "               padding: 25px;\r\n"
					+ "               border-radius: 5px;\r\n"
					+ "               background-color: white;\r\n"
					+ "          }\r\n"
					+ "          \r\n"
					+ "     </style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "     <div class=\"container-fluid\">\r\n"
					+"<h2 align=\"center\">*** Employee Record ***</h2>\r\n"
					+ "          <br>"
					+ "          <div class=\"row\">\r\n"
					+ "               <div class=\"col\">\r\n"
					+ "                    <table class=\"table table-striped\">\r\n"
					+ "                         <tr>\r\n"
					+ "                              <th>Employee ID</th>\r\n"
					+ "                              <th>Employee Name</th>\r\n"
					+ "                              <th>Employee Email</th>\r\n"
					+ "                              <th>Employee Contact</th>\r\n"
					+ "                              <th>Action</th>\r\n"
					+ "                         </tr>\r\n");
			Connection connection = GetConnection.connection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from employees");
			while(resultSet.next()) {
				HttpSession session = request.getSession(true); 
	            session.setAttribute("empID",resultSet.getString(1));
				out.print("<tr>"
						+ "<td>"+resultSet.getString(1)+"</td>"
					    + "<td>"+resultSet.getString(2)+"</td>"
					    + "<td>"+resultSet.getString(3)+"</td>"
					    + "<td>"+resultSet.getString(4)+"</td>"
					    + "<td><a class='btn btn-success'href='EditServlet?id="+resultSet.getString(1)+"'>Edit</a>\r\n"
					    + "                                   <a class='btn btn-danger' href='DeleteServlet?id="+resultSet.getString(1)+"'>Delete</a> ");
				flag=0;                  
			}
			out.print("</table>\r\n"
					+ "               </div>\r\n"
					+ "          </div>");
			if(flag==1) {
				out.print("<div class=\"row\">\r\n"
						+ "               <div class=\"col\">\r\n"
						+ "                    <center><h4>No Record found</h4></center>\r\n"
						+ "               </div>\r\n"
						+ "          </div>");
			}
			out.print("<div class=\"row\">\r\n"
					+ "               <div class=\"col\">\r\n"
					+ "                    <center><a href=\"new.html\" class=\"btn btn-primary\">Add new Record</a></center>\r\n"
					+ "               </div>\r\n"
					+ "          </div>\r\n"
					+ "     </div>\r\n"
					+ "     \r\n"
					+ "     <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}