package wap.LoginServlets;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Test.DatabaseConnection;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served attt: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			//Establish connection
			Connection con = DatabaseConnection.initializeDatabase();

			//Prepare an insert statement
			PreparedStatement st = con.prepareStatement("insert into wap_opg.user values(null, ?, ?, ?, ?, 0, 0, 1)");

			//Refer to hasher to hash user's password
			String hashedPassword = HashThis.HashPassword(request.getParameter("pass"));
			
			//Set the values for the SQL query
			st.setString(1, request.getParameter("uname"));
			st.setString(2, hashedPassword);
			st.setString(3, request.getParameter("mail"));
			st.setDate(4, new java.sql.Date(System.currentTimeMillis()));

			//Execute it
			st.executeUpdate();
			// Close all the connections
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// content type
		response.setContentType("text/html");
		// generate page
		request.getRequestDispatcher("AccountCreated.jsp").forward(request, response);
	}

}
