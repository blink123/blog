package jmk.system.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import jmk.system.comment.Article;
import jmk.system.dao.ArticleDao;
import jmk.system.mapper.ArticleMapper;

public class ArticleDaoImp implements ArticleDao{
	private DataSource datasource;  
	private JdbcTemplate jdbcTemplateObject;
	
	public void setdatasource(DataSource ds) { 
		this.datasource = ds;  
        this.jdbcTemplateObject = new JdbcTemplate(datasource);
	}

	@Override
	public void addarticle(Article article) {
		 String sql = "INSERT INTO article(title,content,type,time,bloggername,readcount)VALUES(?,?,?,?,?,?)";  
	     jdbcTemplateObject.update(sql, article.getTitle(),article.getContent(),article.getType(),article.getTime(),article.getBloggerName(),article.getReadCount());  
	     return ; 
		
	}

	@Override
	public void delarticle(int number) {
		String sql = "DELETE FROM article WHERE number=?";  
        jdbcTemplateObject.update(sql,number);  
        return ;
		
	}

	@Override
	public void updarticle(Article article) {
		String sql = "UPDATE article set title=?,content=?,type=?,time=?,bloggername=?,readcount=? WHERE number=?";  
        jdbcTemplateObject.update(sql,article.getTitle(),article.getContent(),article.getType(),article.getTime(),article.getBloggerName(),article.getReadCount(), article.getNumber());  
        return ; 
		
	}

	@Override
	public List<Article> seaarticle(int number) {
		List<Article> articles = null;  
        String sql = "SELECT * FROM article WHERE number=?";  
        articles = jdbcTemplateObject.query(sql, new Object[]{number}, new ArticleMapper());  
        return articles;
	}

	public void displayall() {  
		        List<Article> articles = allarticles();  
		        for(Article s : articles){  
		            s.display();  
		        }  
		
	}

	public List<Article> allarticles() {
		List<Article> articles = null;  
        String sql = "SELECT * FROM article order by time desc";  
        articles = jdbcTemplateObject.query(sql, new ArticleMapper());  
        return articles;  
	}

	@Override
	public List<Article> seaarticle2(String type) {
		List<Article> articles = null;  
        String sql = "SELECT * FROM article WHERE type=?";  
        articles = jdbcTemplateObject.query(sql, new Object[]{type}, new ArticleMapper());  
        return articles;
	}
	
	@Override
	public List<Article> seaarticle3(String bloggername) {
		List<Article> articles = null;  
        String sql = "SELECT * FROM article WHERE bloggername=? order by time desc";  
        articles = jdbcTemplateObject.query(sql, new Object[]{bloggername}, new ArticleMapper());  
        return articles;
	}
	
	@Override
	public List<Article> getArticleByFriends(String bloggername) {
		List<Article> articles = null;  
        String sql = "select * from article where article.bloggername in (select friends.friendname from friends where bloggername=?) order by time desc";  
        articles = jdbcTemplateObject.query(sql, new Object[]{bloggername}, new ArticleMapper());  
        return articles;
	}
	
	/*
	 * 查找推荐文章
	 */
	@Override
	public List<Article> getArticleByRecommand(){
		List<Article> articles = null;  
        String sql = "SELECT * FROM article where number in (select articlenumber from recommand) order by time desc";  
        articles = jdbcTemplateObject.query(sql, new ArticleMapper());  
        return articles;  
	}
	
}
