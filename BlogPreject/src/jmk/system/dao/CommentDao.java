package jmk.system.dao;

import java.util.List;

import javax.sql.DataSource;

import jmk.system.comment.Comment;

public interface CommentDao {
	public void setdatasource(DataSource ds);
	public void addcomment(Comment comment);
	public void delcomment(int number);
	public void updcomment(Comment comment);
	public List<Comment> seacomment(int number);//通过number查询评论
	public List<Comment> seacomment2(int articlenumber);//通过article number查询评论
}
