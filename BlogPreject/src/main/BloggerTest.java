package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cx.system.blogger.Blogger;
import cx.system.dao.impl.BloggerDaoImp;

public class BloggerTest {
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		BloggerDaoImp bloggerDaoImp = (BloggerDaoImp)context.getBean("BloggerDaoImp");
	    String[] name = { "Wang", "Hui", "Yu", "Yuan", "Chen", "Yang"};
	    String[] password = {"123", "456", "789", "12", "34", "56"};
	    int[] likenumber = { 16, 18, 20, 20, 22, 21 }; 
	    int[] rewardnumber = { 16, 18, 20, 20, 22, 21 }; 
	    String[] headpicture = { "Wang", "Hui", "Yu", "Yuan", "Yuan", "Yang"};
	    String[] time = { "Wang", "Hui", "Yu", "Yuan", "Yuan", "Yang"};
	    
	    Blogger blogger = null;
	    List<Blogger> bloggers = null;
	    
		System.out.println("---------addblogger-------------");
		for(int i=0; i<name.length; i++){
			blogger = new Blogger(name[i],password[i],likenumber[i],rewardnumber[i],headpicture[i],time[i]);
		    bloggerDaoImp.addBlogger(blogger);
	    }
		bloggerDaoImp.displayall();
		
		System.out.println("---------updateblogger-------------");
		blogger = new Blogger("wang","741",45,54,"Li","Li");
		bloggerDaoImp.updBlogger(blogger);
		bloggerDaoImp.displayall();
		
		System.out.println("---------search blogger by name-------------");
		bloggers = bloggerDaoImp.findBloggerByName("Yu");
		for(Blogger b:bloggers)
		{
			b.display();
		}
		
		System.out.println("---------delete-------------");
		bloggerDaoImp.delBloggerByName("Hui");
		bloggerDaoImp.displayall();
	}
}
