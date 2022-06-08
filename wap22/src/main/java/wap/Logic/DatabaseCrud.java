package wap.Logic;

import java.awt.print.Book;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import Test.DatabaseConnection;

public class DatabaseCrud {

	public boolean insertPhoto(Photo photo) throws SQLException, ClassNotFoundException {
		// Insert statement
		String sql = "INSERT INTO wap_opg.picture (height, width, title, description, cameramodel, editingsoftware, fileformat, filesize, dateofupload, user_pk_user, score, file, filelink) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// Establish connection
		Connection con = DatabaseConnection.initializeDatabase();

		// Fill out the statement with object data
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setLong(1, photo.getHeight());
		statement.setLong(2, photo.getWidth());
		statement.setString(3, photo.getTitle());
		statement.setString(4, photo.getDescription());
		statement.setString(5, photo.getCameramodel());
		statement.setString(6, photo.getEditingsoftware());
		statement.setString(7, photo.getFileformat());
		statement.setLong(8, photo.getFilesize());
		statement.setDate(9, photo.getDateofupload());
		statement.setLong(10, photo.getUser_pk_user());
		statement.setLong(11, photo.getScore());
		statement.setBlob(12, photo.getFile());
		statement.setString(13, photo.getFilelink());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.close();
		return rowInserted;
	}

//     
//    public List<Book> listAllBooks() throws SQLException {
//        List<Book> listBook = new ArrayList<>();
//         
//        String sql = "SELECT * FROM wap_opg.picture";
//         
//    	// Establish connection
//    	Connection con = DatabaseConnection.initializeDatabase();
//         
//        Statement statement = con.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//         
//        while (resultSet.next()) {
//            int id = resultSet.getInt("book_id");
//            String title = resultSet.getString("title");
//            String author = resultSet.getString("author");
//            float price = resultSet.getFloat("price");
//             
//            Book book = new Book(id, title, author, price);
//            listBook.add(book);
//        }
//         
//        resultSet.close();
//        statement.close();
//         
//        con.close();
//         
//        return listBook;
//    }
//     
//    public boolean deleteBook(Book book) throws SQLException {
//        String sql = "DELETE FROM book where book_id = ?";
//         
//    	// Establish connection
//    	Connection con = DatabaseConnection.initializeDatabase();
//         
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setInt(1, book.getId());
//         
//        boolean rowDeleted = statement.executeUpdate() > 0;
//        statement.close();
//        con.close();
//        return rowDeleted;     
//    }
//     
//    public boolean updateBook(Book book) throws SQLException {
//        String sql = "UPDATE book SET title = ?, author = ?, price = ?";
//        sql += " WHERE book_id = ?";
//        
//    	// Establish connection
//    	Connection con = DatabaseConnection.initializeDatabase();
//         
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setString(1, book.getTitle());
//        statement.setString(2, book.getAuthor());
//        statement.setFloat(3, book.getPrice());
//        statement.setInt(4, book.getId());
//         
//        boolean rowUpdated = statement.executeUpdate() > 0;
//        statement.close();
//        con.close();
//        return rowUpdated;     
//    }
//  
	// Return a SINGLE photo matching the provided primary key (id)
	public Photo getPhoto(int id) throws SQLException, ClassNotFoundException, IOException {
		Photo photo = null;
		String sql = "SELECT * FROM picture WHERE pk_picture = ?";

		// Establish connection
		Connection con = DatabaseConnection.initializeDatabase();

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		// Get data about this particular picture
		if (resultSet.next()) {
			int height = (resultSet.getInt("height"));
			int width = (resultSet.getInt("width"));
			String title = (resultSet.getString("title"));
			String description = (resultSet.getString("description"));
			String cameramodel = (resultSet.getString("cameramodel"));
			String editingsoftware = (resultSet.getString("editingsoftware"));
			String fileformat = (resultSet.getString("fileformat"));
			Long filesize = (resultSet.getLong("filesize"));
			Date dateofupload = (resultSet.getDate("dateofupload"));
			int user_pk_user = (resultSet.getInt("user_pk_user"));
			int score = (resultSet.getInt("score"));
			Blob file = (resultSet.getBlob("file"));
			String filelink = (resultSet.getString("filelink"));

			// Imagefile
			InputStream inputStream = file.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			byte[] imageBytes = outputStream.toByteArray();

			String base64Image = Base64.getEncoder().encodeToString(imageBytes);

			inputStream.close();
			outputStream.close();

			// And put it into an object
			photo = new Photo(id, title, width, height, description, cameramodel, fileformat, editingsoftware, filesize,
					dateofupload, user_pk_user, score, file, filelink, base64Image);
		}

		resultSet.close();
		statement.close();
		con.close();

		return photo;
	}

	// Return EVERY photo from database
public List<Photo> listEveryPhoto() throws SQLException, ClassNotFoundException, IOException {
    List<Photo> listPhotos = new ArrayList<>();
    
    //Query
    String sql = "SELECT * FROM wap_opg.picture";
    
	// Establish connection
	Connection con = DatabaseConnection.initializeDatabase();
	
	//Statement
	Statement statement = con.createStatement();
	ResultSet resultSet = statement.executeQuery(sql);
     
    while (resultSet.next()) {
		int id = (resultSet.getInt("pk_picture"));
    	int height = (resultSet.getInt("height"));
		int width = (resultSet.getInt("width"));
		String title = (resultSet.getString("title"));
		String description = (resultSet.getString("description"));
		String cameramodel = (resultSet.getString("cameramodel"));
		String editingsoftware = (resultSet.getString("editingsoftware"));
		String fileformat = (resultSet.getString("fileformat"));
		Long filesize = (resultSet.getLong("filesize"));
		Date dateofupload = (resultSet.getDate("dateofupload"));
		int user_pk_user = (resultSet.getInt("user_pk_user"));
		int score = (resultSet.getInt("score"));
		Blob file = (resultSet.getBlob("file"));
		String filelink = (resultSet.getString("filelink"));

		// Imagefile
		InputStream inputStream = file.getBinaryStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}

		byte[] imageBytes = outputStream.toByteArray();

		String base64Image = Base64.getEncoder().encodeToString(imageBytes);

		inputStream.close();
		outputStream.close();

		// And put it into an object
		Photo photo = new Photo(id, title, width, height, description, cameramodel, fileformat, editingsoftware, filesize,
				dateofupload, user_pk_user, score, file, filelink, base64Image);
        listPhotos.add(photo);
    }
     
	resultSet.close();
	statement.close();
	con.close();

	return listPhotos;
	
}

public List<Photo> listMatchingPhoto(String criteria, String queried) throws SQLException, ClassNotFoundException, IOException {
    List<Photo> listPhotos = new ArrayList<>();
    
    //Query by provided criteria
    String sql = "SELECT * FROM wap_opg.picture WHERE " + criteria + " LIKE '%" + queried + "%'";
    
	// Establish connection
	Connection con = DatabaseConnection.initializeDatabase();
	
	//Statement
	Statement statement = con.createStatement();
	ResultSet resultSet = statement.executeQuery(sql);
     
    while (resultSet.next()) {
		int id = (resultSet.getInt("pk_picture"));
    	int height = (resultSet.getInt("height"));
		int width = (resultSet.getInt("width"));
		String title = (resultSet.getString("title"));
		String description = (resultSet.getString("description"));
		String cameramodel = (resultSet.getString("cameramodel"));
		String editingsoftware = (resultSet.getString("editingsoftware"));
		String fileformat = (resultSet.getString("fileformat"));
		Long filesize = (resultSet.getLong("filesize"));
		Date dateofupload = (resultSet.getDate("dateofupload"));
		int user_pk_user = (resultSet.getInt("user_pk_user"));
		int score = (resultSet.getInt("score"));
		Blob file = (resultSet.getBlob("file"));
		String filelink = (resultSet.getString("filelink"));

		// Imagefile
		InputStream inputStream = file.getBinaryStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}

		byte[] imageBytes = outputStream.toByteArray();

		String base64Image = Base64.getEncoder().encodeToString(imageBytes);

		inputStream.close();
		outputStream.close();

		// And put it into an object
		Photo photo = new Photo(id, title, width, height, description, cameramodel, fileformat, editingsoftware, filesize,
				dateofupload, user_pk_user, score, file, filelink, base64Image);
        listPhotos.add(photo);
    }
     
	resultSet.close();
	statement.close();
	con.close();

	return listPhotos;
	
}
}