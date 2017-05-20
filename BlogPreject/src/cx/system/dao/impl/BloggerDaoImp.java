package cx.system.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import cx.system.blogger.Blogger;
import cx.system.dao.BloggerDao;
import cx.system.mapper.BloggerMapper;

public class BloggerDaoImp implements BloggerDao{
	private DataSource datasource;  
	private JdbcTemplate jdbcTemplateObject;
	@Override
	public void setdatasource(DataSource ds) {
		// TODO Auto-generated method stub
		this.datasource = ds;  
        this.jdbcTemplateObject = new JdbcTemplate(datasource);
	}

	@Override
	public void addBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO blogger(name,password,likenumber,rewardnumber,headpicture,time)VALUES(?,?,?,?,?,?)";  
	     jdbcTemplateObject.update(sql,blogger.getName(),blogger.getPassword(),blogger.getLikeNumber(),blogger.getRewardNumber(),blogger.getHeadpicture(),blogger.getDatetime());  
	     return ; 
		
	}

	@Override
	public void updBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		String sql = "UPDATE blogger set name=?,password=?,likenumber=?,rewardnumber=?,headpicture=?,time=? WHERE name=?";  
        jdbcTemplateObject.update(sql,blogger.getName(),blogger.getPassword(),blogger.getLikeNumber(),blogger.getRewardNumber(),blogger.getHeadpicture(),blogger.getDatetime(),blogger.getName());  
        return ; 
	}

	@Override
	public List<Blogger> findBloggerByName(String name) {
		// TODO Auto-generated method stub
		List<Blogger> bloggers = null;  
        String sql = "SELECT * FROM blogger WHERE name=?";  
        bloggers = jdbcTemplateObject.query(sql, new Object[]{name}, new BloggerMapper());  
        return bloggers;
	}
	
	

	@Override
	public void delBloggerByName(String name) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM blogger WHERE name=?";  
        jdbcTemplateObject.update(sql,name);  
        return ;
		
	}
	@Override
    public List<Blogger> allbloggers()
    {
    	List<Blogger> bloggers = null;
        String sql = "SELECT * FROM blogger";  
        bloggers = jdbcTemplateObject.query(sql, new BloggerMapper());  
        return bloggers;  
	}

    public void displayall() {  
        List<Blogger> bloggers = allbloggers();  
        for(Blogger b:bloggers){  
            b.display();  
        }  

}
}
