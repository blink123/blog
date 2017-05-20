package cx.system.dao;

import java.util.List;

import javax.sql.DataSource;

import cx.system.blogger.Blogger;
import cx.system.blogger.Friend;

public interface FriendDao {
	public void setdatasource(DataSource ds);
	public void addFriend(Friend friend);
	public void delFriend(Friend friend);
	public void updFriend(Friend friend,String bloggername,String friendname);
	public List<Friend> findAllfrendsByName(String bloggername);//ͨ�������������Ҳ������к���
	public List<Friend> findFriendByTwoName(String bloggerName,String aimBlogger);
}
