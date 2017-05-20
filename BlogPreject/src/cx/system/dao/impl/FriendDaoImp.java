package cx.system.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.javafx.binding.StringFormatter;

import cx.system.blogger.Blogger;
import cx.system.blogger.Friend;
import cx.system.dao.FriendDao;
import cx.system.mapper.BloggerMapper;
import cx.system.mapper.FriendMapper;

public class FriendDaoImp implements FriendDao{
	private DataSource datasource;  
	private JdbcTemplate jdbcTemplateObject;
	@Override
	public void setdatasource(DataSource ds) {
		// TODO Auto-generated method stub
		this.datasource = ds;  
        this.jdbcTemplateObject = new JdbcTemplate(datasource);
	}

	@Override
	public void addFriend(Friend friend) {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO friends(bloggername,friendname)VALUES(?,?)";  
	     jdbcTemplateObject.update(sql,friend.getBloggername(),friend.getFriendname());  
	     return ; 
	}

	@Override
	public void delFriend(Friend friend) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM friends WHERE bloggername=? and friendname=?";  
        jdbcTemplateObject.update(sql,friend.getBloggername(),friend.getFriendname());  
        return ;
	}

	@Override
	public void updFriend(Friend friend,String bloggername,String friendname) {
		// TODO Auto-generated method stub
		String sql = "UPDATE friends set bloggername=?,friendname=? where bloggername=? and friendname = ?";  
        jdbcTemplateObject.update(sql,friend.getBloggername(),friend.getFriendname(),bloggername,friendname);  
        return ; 
	}

	@Override
	public List<Friend> findAllfrendsByName(String bloggername) {
		// TODO Auto-generated method stub
		List<Friend> friends = null;  
        String sql = "SELECT * FROM friends WHERE bloggername=?";  
        friends = jdbcTemplateObject.query(sql, new Object[]{bloggername}, new FriendMapper());  
        return friends;
	}
	
	@Override
	public List<Friend> findFriendByTwoName(String bloggerName,String aimBlogger){
		List<Friend> friends = null;  
        String sql = "SELECT * FROM friends WHERE bloggername=? and friendname=?";  
        friends = jdbcTemplateObject.query(sql, new Object[]{bloggerName,aimBlogger},new FriendMapper());  
        return friends;
	}
	
    public List<Friend> allrelations()
    {
    	List<Friend> friends = null;
        String sql = "SELECT * FROM friends";  
        friends = jdbcTemplateObject.query(sql, new FriendMapper());  
        return friends;  
	}

    public void displayall() {  
        List<Friend> friends = allrelations();  
        for(Friend f:friends){  
            f.display();  
        }  
    }
}
