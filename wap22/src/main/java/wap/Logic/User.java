package wap.Logic;

import java.sql.Date;

public class User {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegistrationdate() {
		return registrationdate;
	}
	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public int getIsMod() {
		return isMod;
	}
	public void setIsMod(int isMod) {
		this.isMod = isMod;
	}
	public int getUserprofile_pk_userprofile() {
		return userprofile_pk_userprofile;
	}
	public void setUserprofile_pk_userprofile(int userprofile_pk_userprofile) {
		this.userprofile_pk_userprofile = userprofile_pk_userprofile;
	}
	
	
	public User(int id, String username, String password, String email, Date registrationdate, int isAdmin, int isMod,
			int userprofile_pk_userprofile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.registrationdate = registrationdate;
		this.isAdmin = isAdmin;
		this.isMod = isMod;
		this.userprofile_pk_userprofile = userprofile_pk_userprofile;
	}


	private int id;
	private String username;
	private String password;
	private String email;
	private Date registrationdate;
	private int isAdmin;
	private int isMod;
	private int userprofile_pk_userprofile;
	
}
