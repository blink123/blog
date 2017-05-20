package jmk.system.dao;

import java.util.List;

import javax.sql.DataSource;

import jmk.system.comment.PrivateLetter;


public interface PrivateLetterDao {
	public void setdatasource(DataSource ds);
	public void addprivateletter(PrivateLetter privateletter);
	public void delprivateletter(int number);
	public void updprivateletter(PrivateLetter privateletter);
	public List<PrivateLetter> seaprivateletter(int number);//通过number查询私信、留言
	public List<PrivateLetter> seaprivateletter2(String aimBloggerName);//通过接受者查询私信，留言
}
