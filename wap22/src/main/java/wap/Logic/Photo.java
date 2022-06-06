package wap.Logic;

import java.sql.Blob;
import java.sql.Date;

public class Photo {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCameramodel() {
		return cameramodel;
	}
	public void setCameramodel(String cameramodel) {
		this.cameramodel = cameramodel;
	}
	public String getFileformat() {
		return fileformat;
	}
	public void setFileformat(String fileformat) {
		this.fileformat = fileformat;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public Date getDateofupload() {
		return dateofupload;
	}
	public void setDateofupload(Date dateofupload) {
		this.dateofupload = dateofupload;
	}
	public int getUser_pk_user() {
		return user_pk_user;
	}
	public void setUser_pk_user(int user_pk_user) {
		this.user_pk_user = user_pk_user;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Blob getFile() {
		return file;
	}
	public void setFile(Blob file) {
		this.file = file;
	}
	public String getFilelink() {
		return filelink;
	}
	public void setFilelink(String filelink) {
		this.filelink = filelink;
	}
	public String getEditingsoftware() {
		return editingsoftware;
	}
	public void setEditingsoftware(String editingsoftware) {
		this.editingsoftware = editingsoftware;
	}	
	
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	public Photo(int id, String title, int width, int height, String description, String cameramodel, String fileformat,
			String editingsoftware, long filesize, Date dateofupload, int user_pk_user, int score, Blob file,
			String filelink, String base64Image) {
		super();
		this.id = id;
		this.title = title;
		this.width = width;
		this.height = height;
		this.description = description;
		this.cameramodel = cameramodel;
		this.fileformat = fileformat;
		this.editingsoftware = editingsoftware;
		this.filesize = filesize;
		this.dateofupload = dateofupload;
		this.user_pk_user = user_pk_user;
		this.score = score;
		this.file = file;
		this.filelink = filelink;
		this.base64Image = base64Image;
	}

	public int id;
	public String title;
	public int width, height;
	public String description;
	public String cameramodel;
	public String fileformat;
	public String editingsoftware;
	public long filesize;
	public Date dateofupload;
	public int user_pk_user;
	public int score;
	public Blob file;
	public String filelink;
	public String base64Image;

}
