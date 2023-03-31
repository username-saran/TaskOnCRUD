package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String eid = request.getParameter("id");
		PrintWriter out = response.getWriter();
		
		try {
			Employee employee = GetEmployee.getEmployeeById(eid);
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
					+ "          .container{\r\n"
					+ "               padding: 25px;\r\n"
					+ "               border-radius: 5px;\r\n"
					+ "               margin-top: 100px;\r\n"
					+ "               background-color: white;\r\n"
					+ "               width: 60%;\r\n"
					+ "          }\r\n"
					+ "          \r\n"
					+ "     </style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "     <div class=\"container\">\r\n"
					+ "          <div class=\"row\">\r\n"
					+ "               <div class=\"col\">\r\n"
					+ "                    <h2><center>Enter Details</b></center></h2>\r\n"
					+ "                    <br>\r\n"
					+ "               </div>\r\n"
					+ "          </div>\r\n"
					+ "          <div class=\"row\">\r\n"
					+ "               <div class=\"col\">\r\n"
					+ "                    <form action='updateServlet' method='get'>\r\n"
					+ "                         <table class=\"table table-borderless\">\r\n"
					+ "<tr>\r\n"
					+ "                                   <td>Enter Employee ID</td>\r\n"
					+ "                                   <td>\r\n"
					+ "                                        <input type='text' name='eid' id='eid' class=\"form-control\" value="+employee.getEmpid()+" >\r\n"
					+ "                                   </td>\r\n"
					+ "                              </tr>"
					+ "                              <tr>\r\n"
					+ "                                   <td>Enter Employee Name</td>\r\n"
					+ "                                   <td>\r\n"
					+ "                                        <input type='text' name='name' id='name' class=\"form-control\" value="+employee.getEmpname()+" >\r\n"
					+ "                                   </td>\r\n"
					+ "                              </tr>\r\n"
					+ "                              <tr>\r\n"
					+ "                                   <td>\r\n"
					+ "                                        Enter Employee Email\r\n"
					+ "                                   </td>\r\n"
					+ "                                   <td>\r\n"
					+ "                                        <input type='email' name='email' id=''email class=\"form-control\" value="+employee.getEmpmail()+">\r\n"
					+ "                                   </td>\r\n"
					+ "                              </tr>\r\n"
					+ "                              <tr>\r\n"
					+ "                                   <td>\r\n"
					+ "                                        Enter Employee Contact\r\n"
					+ "                                   </td>\r\n"
					+ "                                   <td>\r\n"
					+ "                                        <input type=\"text\" name='contact' id=\"contact\" class=\"form-control\" value="+employee.getEmpcontact()+">\r\n"
					+ "                                   </td>\r\n"
					+ "                              </tr>\r\n"
					+ "                              <tr>\r\n"
					+ "                                   <td colspan=\"2\">\r\n"
					+ "                                        <input type=\"submit\" value=\"Update\" class=\"form-control btn btn-primary\">\r\n"
					+ "                                   </td>\r\n"
					+ "                              </tr>\r\n"
					+ "                         </table>\r\n"
					+ "                    </form>\r\n"
					+ "               </div>\r\n"
					+ "          </div>\r\n"
					+ "     </div>\r\n"
					+ "     \r\n"
					+ "     <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			
			
		} catch (ClassNotFoundException | SQLException e) {
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