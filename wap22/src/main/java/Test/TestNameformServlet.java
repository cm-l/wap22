package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestNameformServlet
 */
@WebServlet("/TestNameformServlet")
public class TestNameformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String username = "root";
	private String password = "google666";
	private String databaseSchema = "wap_opg";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestNameformServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//establish db connectivity
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			
			 PreparedStatement st = con
	                   .prepareStatement("insert into wap_opg.user values(null, ?, ?, ?, ?, 0, 0, 1)");
			 
			 st.setString(1, request.getParameter("uname"));
			 st.setString(2, request.getParameter("pass"));
			 st.setString(3, request.getParameter("mail"));
			 st.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			 
			 st.executeUpdate();
	         // Close all the connections
	         st.close();
	         con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//content type
		response.setContentType("text/html"); //<- we are sending back a html page for the user
		
		//access printwriter
		PrintWriter out = response.getWriter(); //<- this will let us create the page
		
		//generate page
		out.println("<html></body>");
		
		out.println("Access Granted to: " + request.getParameter("uname") + request.getParameter("pass") + request.getParameter("mail"));

		
		out.println("</body></html>");
		
		//OR BETTER YET
		
		//redirect to a dynamically created jsp page
		//response.sendRedirect("test-accessgranted.jsp"); <- doesn't forward the req & rep
		//request.getRequestDispatcher("test-accessgranted.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
