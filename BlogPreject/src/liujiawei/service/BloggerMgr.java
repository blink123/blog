package liujiawei.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.javafx.binding.StringFormatter;
import com.sun.org.apache.regexp.internal.recompile;

import cx.system.blogger.Blogger;
import cx.system.blogger.Friend;
import cx.system.dao.FriendDao;
import cx.system.dao.impl.BloggerDaoImp;
import cx.system.dao.impl.FriendDaoImp;
import liujiawei.recommand.daoImpl.RecommandDaoImpl;
import liujiawei.recommand.entity.Recommand;

public class BloggerMgr {
	
	private static BloggerMgr instance=null;
	
	ApplicationContext context =null;
	BloggerDaoImp bloggerDaoImp = null;
	FriendDaoImp friendDaoImp=null;
	RecommandDaoImpl recommandDaoImpl=null;
	
	String headPictureInitPath="";
	
	private BloggerMgr() {		
		 context = new ClassPathXmlApplicationContext("Beans.xml");
		 bloggerDaoImp = (BloggerDaoImp)context.getBean("BloggerDaoImp");
		 friendDaoImp=(FriendDaoImp)context.getBean("FriendDaoImp");
		 recommandDaoImpl=(RecommandDaoImpl)context.getBean("RecommandDaoImpl");
	}
	
	public static BloggerMgr getInstance() {
		if(instance==null){
			instance=new BloggerMgr();			
		}
		return instance;
	}
	
	/*
	 * 添加用户
	 */
	public Blogger addBlogger(String username,String password) {
		List<Blogger> bloggers = bloggerDaoImp.findBloggerByName(username);
		//如果查询为空，就插入一条博主记录
		if(bloggers==null||bloggers.isEmpty()){			
			Blogger blogger=new Blogger(username,password,0,0,headPictureInitPath,CommonService.getCurrentTime());
			bloggerDaoImp.addBlogger(blogger);
			return blogger;
		}
		return null;
	}
	
	/*
	 * 检查用户登录
	 */
	public  Blogger checkBlogger(String username,String password) {
		List<Blogger> bloggers = bloggerDaoImp.findBloggerByName(username);
		if(bloggers==null||bloggers.isEmpty()){			
			return null;
		}
		else {
			if(bloggers.get(0).getPassword().equals(password)){
				return bloggers.get(0);
			}
		}
		return null;
	}
	
	/*
	 * 根据博主名称获取博主实例
	 */
	public Blogger getBkiggerByName(String name) {
		List<Blogger> bloggers = bloggerDaoImp.findBloggerByName(name);
		if(bloggers==null||bloggers.isEmpty()){			
			return null;
		}
		else {		
			return bloggers.get(0);
		}
	}
	
	/*
	 * 获取所有的博主
	 */
	public List<Blogger> getAllBlogger(){
		List<Blogger> bloggers = bloggerDaoImp.allbloggers();
		if(bloggers==null||bloggers.isEmpty()){			
			return null;
		}
		else {		
			return bloggers;
		}
	}
	
	/*
	 * 删除博主
	 */
	public void deleteBlogger(String name) {
		bloggerDaoImp.delBloggerByName(name);
	}
	
	/*
	 * 增加一个朋友
	 */
	public void addFriend(String bloggerName,String friendName) {
		Friend friend=new Friend(bloggerName,friendName);
		friendDaoImp.addFriend(friend);
	}
	
	/*
	 * 删除一个朋友
	 */
	public void delFriend(String bloggerName,String friendName) {
		Friend friend=new Friend(bloggerName,friendName);
		friendDaoImp.delFriend(friend);
	}
	
	/*
	 * 根据名称获取好友
	 */
	public boolean checkFriendByName(String bloggerName,String friendName){
		List<Friend> list_Friend=friendDaoImp.findFriendByTwoName(bloggerName, friendName);
		if(list_Friend==null||list_Friend.isEmpty()){
			return false;
		}
		return true;
	}
	
	/*
	 * 增加一个推荐
	 */
	public void addOneRecommand(int articleNumber) {
		Recommand recommand=new Recommand(articleNumber);
		recommandDaoImpl.addRecomand(recommand);
	}
	
	/*
	 * 删除一个推荐
	 */
	public void deleteOneRecommand(int articleNumber) {
		recommandDaoImpl.delRecommandByArticleNumber(articleNumber);
	}
	
	/*
	 * 查找一个文章在不在推荐列
	 */
	public boolean isInRecommand(int articleNumber) {
		return recommandDaoImpl.findInRecommand(articleNumber);
	}
	
}
