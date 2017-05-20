//这是一个将SQL数据与Article对象映射的类ArticleMapper.java

package jmk.system.mapper;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;

import jmk.system.comment.Article;  
  
public class ArticleMapper implements RowMapper<Article> {  
  
    public Article mapRow(ResultSet rs, int rownum) throws SQLException {  
    	Article article = new Article();  
    	article.setTitle(rs.getString("title"));  
    	article.setType(rs.getString("type"));
    	article.setReadCount(rs.getInt("readcount"));
    	article.setBloggerName(rs.getString("bloggername"));
    	article.setNumber(rs.getInt("number"));
    	article.setContent(rs.getString("content"));
    	article.setTime(rs.getString("time"));
        return article;       
    }  
} 