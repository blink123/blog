package liujiawei.test;

import java.util.ArrayList;
import java.util.List;

import cx.system.blogger.Blogger;
import jmk.system.comment.Article;
import jmk.system.comment.Comment;

public class BlogTest {
	
	static List<Blogger> list_blogger=new ArrayList<Blogger>();
	
	static List<Article> list_Article=new ArrayList<Article>();
	
	static List<Comment> list_Comment=new ArrayList<Comment>();
	
	public  static void AddUser(Blogger blogger) {
		list_blogger.add(blogger);
	}
	
	public  static boolean hasBlogger(Blogger blogger) {
		for(Blogger bl:list_blogger){
			if(bl.getName().equals(blogger.getName())){
				return true;
			}
		}
		return false;
	}
	
	public  static boolean login(Blogger blogger) {
		if(list_blogger.isEmpty()){
			list_blogger.add(new Blogger("123", "123",0,0,"",""));
		}
		for(Blogger blogger2 : list_blogger){
			if(blogger2.getName().equals(blogger.getName())&&blogger2.getPassword().equals(blogger.getPassword())){
				return true;
			}
		}
		return false;
	}
	
	public  static void addArticle(Article article) {
		list_Article.add(article);
	}
	
	public  static int getArticleNumber(Article article) {
		return list_Article.indexOf(article);
	}
	
	public  static List<Article> getArticles() {
		return list_Article;
	}
	
	public static Comment getCommentByArticleid(int articleid) {
		for(Comment comment : list_Comment){
			if(comment.getArticleNumber()==articleid){
				Comment comment2=comment;
				return comment2;
			}
		}
		return null;
	}
	
}
