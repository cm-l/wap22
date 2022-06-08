package wap.DatabaseServlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Test.DatabaseConnection;
import wap.LoginServlets.HashThis;

/**
 * Servlet implementation class PostComment
 */
@WebServlet("/PostComment")
public class PostComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			//Establish connection
			Connection con = DatabaseConnection.initializeDatabase();

			//Prepare an insert statement
			PreparedStatement st = con.prepareStatement("insert into wap_opg.comment values(null, 0, ?, ?, ?)");

			
			//Set the values for the SQL query
			st.setString(1, request.getParameter("comment"));
			st.setString(2, request.getParameter("picId"));
			st.setDate(3, new java.sql.Date(System.currentTimeMillis()));

			//Execute it
			st.executeUpdate();
			// Close all the connections
			st.close();
			con.close();
			
			//redirect back instantly
			response.sendRedirect("/wap22/GrabImageServlet?pic_id=" + request.getParameter("picId"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
