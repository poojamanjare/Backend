package com.collaborate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class BlogComment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogCommentId;
	
	private String commentText;
	
	@ManyToOne
	@JoinColumn(name="username")
	private Users commentedBy;	//here name of FK column is username
	
	private Date commentedOn;
	
	@ManyToOne
	private BlogPost blogPost; //here name of FK column is blogPost_blogId(we not give join colunm name here)
	public int getBlogCommentId() {
		return blogCommentId;
	}
	public void setBlogCommentId(int blogCommentId) {
		this.blogCommentId = blogCommentId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Users getCommentedBy() {
		return commentedBy;
	}
	public void setCommentedBy(Users commentedBy) {
		this.commentedBy = commentedBy;
	}
	public Date getCommentedOn() {
		return commentedOn;
	}
	public void setCommentedOn(Date commentedOn) {
		this.commentedOn = commentedOn;
	}
	public BlogPost getBlogPost() {
		return blogPost;
	}
	public void setBlogPost(BlogPost blogPost) {
		this.blogPost = blogPost;
	}

}