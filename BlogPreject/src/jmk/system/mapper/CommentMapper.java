package jmk.system.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jmk.system.comment.Comment;

public class CommentMapper implements RowMapper<Comment>{

	 public Comment mapRow(ResultSet rs, int rownum) throws SQLException {  
	    	Comment comment = new Comment();  
	    	comment.setNumber(rs.getInt("number")); 
	    	comment.setContent(rs.getString("content"));
	    	comment.setTime(rs.getString("time"));
	    	comment.setSendBloggerName(rs.getString("sendBloggername"));
	    	comment.setAimBloggerName(rs.getString("aimBloggername"));
	    	comment.setBloggerName(rs.getString("bloggername"));
	    	comment.setArticleNumber(rs.getInt("articlenumber"));
	        return comment;       
	    }  

}
