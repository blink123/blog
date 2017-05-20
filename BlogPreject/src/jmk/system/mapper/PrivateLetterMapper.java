package jmk.system.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jmk.system.comment.PrivateLetter;

public class PrivateLetterMapper implements RowMapper<PrivateLetter> {
	 
	public PrivateLetter mapRow(ResultSet rs, int rownum) throws SQLException {  
		 PrivateLetter privateletter = new PrivateLetter();  
		 privateletter.setNumber(rs.getInt("number")); 
		 privateletter.setContent(rs.getString("content"));
		 privateletter.setTime(rs.getString("time"));
		 privateletter.setSendBloggerName(rs.getString("sendBloggerName"));
		 privateletter.setAimBloggerName(rs.getString("aimBloggerName"));
		privateletter.setReadflag(rs.getInt("readflag"));
	     return privateletter;       
	    }  
}
