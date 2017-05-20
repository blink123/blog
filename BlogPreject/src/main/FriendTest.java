package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cx.system.blogger.Blogger;
import cx.system.blogger.Friend;
import cx.system.dao.impl.BloggerDaoImp;
import cx.system.dao.impl.FriendDaoImp;

public class FriendTest {
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		FriendDaoImp friendDaoImp = (FriendDaoImp)context.getBean("FriendDaoImp");
	    String[] bloggername = { "Wang", "Yu", "Yuan", "Chen", "Yang"};
	    String[] friendname = { "Yu", "Yang", "Yu", "Wang", "Chen"};
	    
	    Friend friend = null;
	    List<Friend> friends = null;
	    
		System.out.println("---------addfriend-------------");
		for(int i=0; i<bloggername.length; i++){
			friend = new Friend(bloggername[i],friendname[i]);
		    friendDaoImp.addFriend(friend);
	    }
		friendDaoImp.displayall();
		
		System.out.println("---------updatefriend------------");
		friend = new Friend("Yu","Chen");
		friendDaoImp.updFriend(friend,"Yu","Yang");
		friendDaoImp.displayall();
		
		System.out.println("---------search blogger by name-------------");
		friends = friendDaoImp.findAllfrendsByName("Yu");
		for(Friend f:friends)
		{
			f.display();
		}
		
		System.out.println("---------delete-------------");
		friendDaoImp.delFriend(friend);
		friendDaoImp.displayall();
	}
}
