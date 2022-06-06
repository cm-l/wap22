package wap.LoginServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Test.DatabaseConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//POST because it's the user sending stuff
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Create a HTML page
		response.setContentType("text/html");
		//Access writer
		PrintWriter out = response.getWriter();
		//Print navigation bar
		getServletContext().getRequestDispatcher("/link.html").include(request, response);
		
		//Variables for ease of access
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		
		try {
			//Establish connection to database
			Connection con = DatabaseConnection.initializeDatabase();
			
			//Prepare a SQL statement
			 PreparedStatement st = con
	                   .prepareStatement("SELECT `username`, `pk_user`  FROM `user` WHERE `username` = ? AND `password` = ?");
			 
			//Refer to hasher to hash user's password
			String hashedPassword = HashThis.HashPassword(password);
			 
			 //Set username to what user wrote in the 1st textfield
			 st.setString(1, name);
			 //Set password to the hashed version of what user wrote in the 2nd textfield
			 st.setString(2, hashedPassword);
			 
			 //Execute the SQL query
			 ResultSet rs = st.executeQuery();
			 
			 //If there is a matching record for the provided username/password combination 
			 if(rs.next()) {
				 	
				 	int uid = rs.getInt("pk_user");
				 
				 	//Greet the user
					out.print("Your user ID is " + uid + ". Welcome, " + name);
					//Create a session named after the user
					HttpSession session = request.getSession();
					session.setAttribute("name", name);
					session.setAttribute("pk_user", uid);
			 } else {
				 //Don't let the user in
				 out.print("Sorry, username or password error! Please try again.");
				 request.getRequestDispatcher("login.jsp").include(request, response);
			 }

	         // Close all the connections
	         st.close();
	         con.close();
			 
		} catch (Exception e) {
			//Print error if any
			e.printStackTrace();
		}
		
		//Close writer
		out.close();
	}

}
