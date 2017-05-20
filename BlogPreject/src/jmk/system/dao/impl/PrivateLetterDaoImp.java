package jmk.system.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import jmk.system.comment.Comment;
import jmk.system.comment.PrivateLetter;
import jmk.system.dao.PrivateLetterDao;
import jmk.system.mapper.CommentMapper;
import jmk.system.mapper.PrivateLetterMapper;



public class PrivateLetterDaoImp implements  PrivateLetterDao{
	private DataSource datasource;  
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setdatasource(DataSource ds) {
		this.datasource = ds;  
        this.jdbcTemplateObject = new JdbcTemplate(datasource);
		
	}

	@Override
	public void addprivateletter(PrivateLetter privateletter) {
		String sql = "INSERT INTO privateletter(content,time,sendbloggername,aimbloggername,readflag)VALUES(?,?,?,?,?)";  
	     jdbcTemplateObject.update(sql, privateletter.getContent(),privateletter.getTime(),
	    		 privateletter.getSendBloggerName(),privateletter.getAimBloggerName(),privateletter.getReadflag());  
	     return ; 
		
	}

	@Override
	public void delprivateletter(int number) {
		String sql = "DELETE FROM privateletter WHERE number=?";  
        jdbcTemplateObject.update(sql,number);  
        return ;
		
	}

	@Override
	public void updprivateletter(PrivateLetter privateletter) {
		String sql = "UPDATE privateletter set content=?,time=?,sendbloggername=?,aimbloggername=?,readflag=? WHERE number=?";  
        jdbcTemplateObject.update(sql,privateletter.getContent(),privateletter.getTime(),
        		privateletter.getSendBloggerName(),privateletter.getAimBloggerName(),privateletter.getReadflag(),
        		privateletter.getNumber()); 
		
	}

	@Override
	public List<PrivateLetter> seaprivateletter(int number) {
		List<PrivateLetter> privateletters = null;  
        String sql = "SELECT * FROM privateletter WHERE number=?";  
        privateletters = jdbcTemplateObject.query(sql, new Object[]{number}, new PrivateLetterMapper());  
        return privateletters;
	}

	public void displayall() {
		List<PrivateLetter> privateletters = allprivateletters();  
        for(PrivateLetter s : privateletters){  
            s.display();  
        }  
	}
        private List<PrivateLetter> allprivateletters() {
    		List<PrivateLetter> privateletters = null;  
            String sql = "SELECT * FROM privateletter";  
            privateletters = jdbcTemplateObject.query(sql, new PrivateLetterMapper());  
            return privateletters;  
    	}

		@Override
		public List<PrivateLetter> seaprivateletter2(String aimBloggerName) {
			List<PrivateLetter> privateletters = null;  
	        String sql = "SELECT * FROM privateletter WHERE aimBloggerName=?";  
	        privateletters = jdbcTemplateObject.query(sql, new Object[]{aimBloggerName}, new PrivateLetterMapper());  
	        return privateletters;
		}	


}
