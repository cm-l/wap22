package wap.UploadImageServlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Test.DatabaseConnection;
import wap.Logic.DatabaseCrud;

/**
 * Servlet implementation class UploadPhotoServlet
 */
@WebServlet("/UploadPhotoServlet")
@MultipartConfig(maxFileSize = 16177215) // This has to be here so that the max upload size is up to 16mb
public class UploadPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadPhotoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Establish connection
			Connection con = DatabaseConnection.initializeDatabase();

			// Create DAO
			DatabaseCrud dao = new DatabaseCrud();

			// Variables we got from form
			String title = request.getParameter("title");
			int width = Integer.parseInt(request.getParameter("width"));
			int height = Integer.parseInt(request.getParameter("height"));
			String description = request.getParameter("description");

			int primkey = 0;

			// Debug
			System.out.println(request.getSession(false).getAttribute("name"));

			// Photo file from form
			InputStream inputStream = null;

			// Getting the photo
			Part filePart = request.getPart("photo");
			if (filePart != null) {
				// Debug code
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());

				// Assign to variable
				inputStream = filePart.getInputStream();

				// Create SQL statement
				String sql = "INSERT INTO wap_opg.picture (height, width, title, description, cameramodel, editingsoftware, fileformat, filesize, dateofupload, user_pk_user, score, file, filelink) VALUES (?, ?, ?, ?, \"Nikon 300\", \"Adobe PS\", \".RAW\", 200, ?, ?, 0, ?, \"linkurl\")";
				PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, width);
				statement.setInt(2, height);
				statement.setString(3, title);
				statement.setString(4, description);
				statement.setDate(5, new Date(System.currentTimeMillis()));
				statement.setInt(6, (int) request.getSession(false).getAttribute("pk_user"));

				// File upload if it can
				if (inputStream != null) {
					// Add "blob"
					statement.setBlob(7, inputStream);
				}

				// Execute it and check if works
				// int row = statement.executeUpdate();
				if (statement.executeUpdate() > 0) {
					ResultSet generatedKeys = statement.getGeneratedKeys();
					if (generatedKeys.next()) {
						generatedKeys.first();
						primkey = (int) generatedKeys.getLong(1);
					}

					request.setAttribute("pic_id", primkey);
					System.out.println("An image titled " + dao.getPhoto(primkey).getTitle()
							+ " has just been uploaded with PK = " + primkey); // for debug
					response.sendRedirect("/wap22/GrabImageServlet?pic_id=" + primkey);

				} else {
					response.getWriter().print("Something went wrong.");
				}

				// Close all the connections
				statement.close();
				con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().print("Something went wrong. You're meant to send a POST request.");
	}

}
