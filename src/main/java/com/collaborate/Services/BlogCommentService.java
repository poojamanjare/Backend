package com.collaborate.Services;

import java.util.List;

import com.collaborate.model.BlogComment;

public interface BlogCommentService 
{
	void addBlogComment(BlogComment blogComment);

	List<BlogComment> getBlogComments(int blogId);
}
