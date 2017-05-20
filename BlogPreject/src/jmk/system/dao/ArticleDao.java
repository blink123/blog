package jmk.system.dao;

import java.util.List;

import javax.sql.DataSource;

import jmk.system.comment.Article;

public interface ArticleDao {
	public void setdatasource(DataSource ds);
	public void addarticle(Article article);
	public void delarticle(int number);
	public void updarticle(Article article);
	public List<Article> seaarticle(int number);//ͨ��number��ѯ����
	public List<Article> seaarticle2(String type);//ͨ��type��ѯ����
	public List<Article> seaarticle3(String bloggername);//ͨ�����߲�ѯ����
	public List<Article> getArticleByFriends(String bloggername);
	public List<Article> getArticleByRecommand();
}
