package wap.Search;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import wap.Logic.DatabaseCrud;

/**
 * Servlet implementation class GrabUserServlet
 */
@WebServlet("/GrabUserServlet")
public class GrabUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrabUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Create DAO
		DatabaseCrud dao = new DatabaseCrud();

		// The photo
		wap.Logic.User user = null;

		// ID of given user
		int id = Integer.valueOf(request.getParameter("user_id"));

		// Put that image into an object
		try {
			user = dao.getUser(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		 //Put data into attributes
		request.setAttribute("username", user.getUsername());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("registrationdate", user.getRegistrationdate());
		request.setAttribute("isadmin", user.getIsAdmin());
		request.setAttribute("ismod", user.getIsMod());
		request.setAttribute("userprofile_pk_userprofile", user.getUserprofile_pk_userprofile());
		

		//Object just in case
		request.setAttribute("user", user);
		
		//Forward to page with the image
		request.getRequestDispatcher("/UserProfile.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
