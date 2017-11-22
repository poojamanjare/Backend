package com.collaborate.DAO;

import java.util.List;

import com.collaborate.model.BlogComment;

public interface BlogCommentDAO 
{
	void addBlogComment(BlogComment blogComment);

	List<BlogComment> getBlogComments(int blogId);

}
