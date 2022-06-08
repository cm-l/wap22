package wap.DatabaseServlets;

import java.io.IOException;
import java.io.Writer;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wap.Logic.DatabaseCrud;
import wap.Logic.Photo;

/**
 * Servlet implementation class GrabImageServlet
 */
@WebServlet("/GrabImageServlet")
public class GrabImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GrabImageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Create DAO
		DatabaseCrud dao = new DatabaseCrud();

		// The photo
		Photo photo = null;

		// ID of image
		int id = Integer.valueOf(request.getParameter("pic_id"));

		// Put that image into an object
		try {
			photo = dao.getPhoto(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		 //Put data into attributes
		request.setAttribute("height", photo.getHeight());
		request.setAttribute("width", photo.getWidth());
		request.setAttribute("title", photo.getTitle());
		request.setAttribute("description", photo.getDescription());
		request.setAttribute("cameramodel", photo.getCameramodel());
		request.setAttribute("editingsoftware", photo.getEditingsoftware());
		request.setAttribute("fileformat", photo.getFileformat());
		request.setAttribute("filesize", photo.getFilesize());
		request.setAttribute("dateofupload", photo.getDateofupload());
		request.setAttribute("user_pk_user", photo.getUser_pk_user());
		request.setAttribute("score", photo.getScore());
		request.setAttribute("file", photo.getFile());
		request.setAttribute("filelink", photo.getFilelink());
		request.setAttribute("base64Image", photo.getBase64Image());
		request.setAttribute("pic_id", request.getParameter("pic_id"));
		

		//Object just in case
		request.setAttribute("pic", photo);
		
		//Forward to page with the image
		request.getRequestDispatcher("/DisplayImage.jsp").forward(request, response);
	}

}
