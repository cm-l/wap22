package wap.Logic;

import java.sql.Date;

public class Comment {
	public int getPk_comment() {
		return pk_comment;
	}
	public void setPk_comment(int pk_comment) {
		this.pk_comment = pk_comment;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPicture_pk_picture() {
		return picture_pk_picture;
	}
	public void setPicture_pk_picture(int picture_pk_picture) {
		this.picture_pk_picture = picture_pk_picture;
	}
	public Date getDateposted() {
		return dateposted;
	}
	public void setDateposted(Date dateposted) {
		this.dateposted = dateposted;
	}
	public Comment(int pk_comment, int votes, String content, int picture_pk_picture, Date dateposted) {
		super();
		this.pk_comment = pk_comment;
		this.votes = votes;
		this.content = content;
		this.picture_pk_picture = picture_pk_picture;
		this.dateposted = dateposted;
	}
	private int pk_comment;
	private int votes;
	private String content;
	private int picture_pk_picture;
	private Date dateposted;
}
