package liujiawei.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cx.system.blogger.Blogger;
import jmk.system.comment.Article;
import jmk.system.comment.Comment;
import jmk.system.comment.PrivateLetter;
import jmk.system.dao.impl.ArticleDaoImp;
import jmk.system.dao.impl.CommentDaoImp;
import jmk.system.dao.impl.PrivateLetterDaoImp;

public class ContentMgr {

private static ContentMgr instance=null;
	
	ApplicationContext context =null;
	ArticleDaoImp articleDaoImp =null; 
	CommentDaoImp commentDaoImp=null;
	PrivateLetterDaoImp privateletterDaoImp=null;
	 
	private ContentMgr() {		
		 context = new ClassPathXmlApplicationContext("Beans.xml");
		 articleDaoImp = (ArticleDaoImp)context.getBean("articleDaoImp"); 
		 commentDaoImp=(CommentDaoImp)context.getBean("commentDaoImp");
		 privateletterDaoImp = (PrivateLetterDaoImp)context.getBean("privateletterDaoImp");  

	}
	
	public static ContentMgr getInstance() {
		if(instance==null){
			instance=new ContentMgr();			
		}
		return instance;
	}
	
	/*
	 * 插入一则博文
	 */
	public void addArticle(String title,String type,Blogger blogger,String content) {
		Article article = new Article(title,type,0,blogger.getName(),0,content,CommonService.getCurrentTime());  
	    articleDaoImp.addarticle(article);
	}
		
	public List<Article> getAllArticles() {
		List<Article> list_Article=articleDaoImp.allarticles();
		return list_Article;
	}
	
	/*
	 * 查找博主自己的文章
	 */
	public List<Article> getArticlesByBlogger(String bloggername) {
		List<Article> list_Article=articleDaoImp.seaarticle3(bloggername);
		return list_Article;
	}
	
	/*
	 * 查找博主好友的博文
	 */
	public List<Article> getArticlesByFriends(String bloggername) {
		List<Article> list_Article=articleDaoImp.getArticleByFriends(bloggername);
		return list_Article;
	}
	
	/*
	 * 查找推荐文章
	 */
	public List<Article> getArticleByRecomand() {
		List<Article> list_Article=articleDaoImp.getArticleByRecommand();
		return list_Article;
	}
	
	/*
	 * 根据编号删除一篇文章
	 */
	public void deleteOneArticleByNumber(int number) {
		articleDaoImp.delarticle(number);
	}
	
	/*
	 * 插入一条评论记录
	 */
	public  void addComment(String content,String sendBloggerName,String aimBloggerName,String bloggerName,int articleNumber) {
		Comment comment=new Comment(content, CommonService.getCurrentTime(), sendBloggerName, aimBloggerName, bloggerName, articleNumber);
		comment.display();
		commentDaoImp.addcomment(comment);
	}
	
	/*
	 * 获取某博文的所有评论
	 */
	public List<Comment> getAllCommentsByBlogid(int number){
		List<Comment> comments = commentDaoImp.seacomment2(number);  
		return comments;
	}
	
	/*
	 * 增加一个留言
	 */
	public void addLeaveLetter(String content,String sendbloggername,String aimbloggername,int readable) {
		PrivateLetter privateletter=new PrivateLetter(content,CommonService.getCurrentTime(),sendbloggername,aimbloggername,readable);
		privateletterDaoImp.addprivateletter(privateletter);
	}
	
	/*
	 * 查找有关博主的所有留言
	 */
	public  List<PrivateLetter> getAllPrivateLetterByName(String bloggername) {
		return privateletterDaoImp.seaprivateletter2(bloggername);
	}
	
}
