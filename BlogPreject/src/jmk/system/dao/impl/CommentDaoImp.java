package jmk.system.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import jmk.system.comment.Article;
import jmk.system.comment.Comment;
import jmk.system.dao.CommentDao;
import jmk.system.mapper.ArticleMapper;
import jmk.system.mapper.CommentMapper;

public class CommentDaoImp implements CommentDao {
	private DataSource datasource;  
	private JdbcTemplate jdbcTemplateObject;
	
	public void setdatasource(DataSource ds) { 
		this.datasource = ds;  
        this.jdbcTemplateObject = new JdbcTemplate(datasource);
	}


	@Override
	public void addcomment(Comment comment) {
		 String sql = "INSERT INTO comment(content,time,sendbloggername,aimbloggername,"
		 		+ "bloggername,articlenumber)VALUES(?,?,?,?,?,?)";  
	     jdbcTemplateObject.update(sql, comment.getContent(),comment.getTime(),
	    		 comment.getSendBloggerName(),comment.getAimBloggerName(),comment.getBloggerName(),
	    		 comment.getArticleNumber());  
	     return ; 		
	}

	@Override
	public void delcomment(int number) {
		String sql = "DELETE FROM comment WHERE number=?";  
        jdbcTemplateObject.update(sql,number);  
        return ;
		
	}

	@Override
	public void updcomment(Comment comment) {
		String sql = "UPDATE comment set content=?,time=?,sendbloggername=?,aimbloggername=?,bloggername=?,articlenumber=? WHERE number=?";  
        jdbcTemplateObject.update(sql,comment.getContent(),comment.getTime(),
	    		 comment.getSendBloggerName(),comment.getAimBloggerName(),comment.getBloggerName(),
	    		 comment.getArticleNumber(),comment.getNumber());  
        return ;
		
	}

	@Override
	public List<Comment> seacomment(int number) {
		List<Comment> comments = null;  
        String sql = "SELECT * FROM comment WHERE number=?";  
        comments = jdbcTemplateObject.query(sql, new Object[]{number}, new CommentMapper());  
        return comments;
	}


	@Override
	public List<Comment> seacomment2(int articlenumber) {
		List<Comment> comments = null;  
        String sql = "SELECT * FROM comment WHERE articlenumber=?";  
        comments = jdbcTemplateObject.query(sql, new Object[]{articlenumber}, new CommentMapper());  
        return comments;
	}


	public void displayall() {
		List<Comment> comments = allcomments();  
        for(Comment s : comments){  
            s.display();  
        }  
	}
        private List<Comment> allcomments() {
    		List<Comment> comments = null;  
            String sql = "SELECT * FROM comment";  
            comments = jdbcTemplateObject.query(sql, new CommentMapper());  
            return comments;  
    	}
	

}
