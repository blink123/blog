package jmk.system.dao;

import java.util.List;

import javax.sql.DataSource;

import jmk.system.comment.PrivateLetter;


public interface PrivateLetterDao {
	public void setdatasource(DataSource ds);
	public void addprivateletter(PrivateLetter privateletter);
	public void delprivateletter(int number);
	public void updprivateletter(PrivateLetter privateletter);
	public List<PrivateLetter> seaprivateletter(int number);//ͨ��number��ѯ˽�š�����
	public List<PrivateLetter> seaprivateletter2(String aimBloggerName);//ͨ�������߲�ѯ˽�ţ�����
}
