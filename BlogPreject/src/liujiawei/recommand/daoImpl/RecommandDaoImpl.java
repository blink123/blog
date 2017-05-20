package liujiawei.recommand.daoImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import cx.system.blogger.Blogger;
import cx.system.mapper.BloggerMapper;
import liujiawei.recommand.dao.RecommandDao;
import liujiawei.recommand.entity.Recommand;
import liujiawei.recommand.mapper.RecommandMaper;

public class RecommandDaoImpl implements RecommandDao {
	
	private DataSource datasource;  
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setdatasource(DataSource ds) {
		// TODO Auto-generated method stub
		this.datasource = ds;  
        this.jdbcTemplateObject = new JdbcTemplate(datasource);
	}

	@Override
	public void addRecomand(Recommand recommand) {
		System.out.println("将要插入数据"+recommand.getArticlenumber());
		// TODO Auto-generated method stub
		String sql = "INSERT INTO recommand(articlenumber) VALUES(?)";  
	     jdbcTemplateObject.update(sql,recommand.getArticlenumber());  
	     return ;
	}

	@Override
	public void delRecommandByArticleNumber(int articleNumber) {
		// TODO Auto-generated method stub
		System.out.println("将要删除数据"+articleNumber);
		String sql = "DELETE FROM recommand WHERE articlenumber=?";  
        jdbcTemplateObject.update(sql,articleNumber);  
        return ;
	}

	@Override
	public boolean findInRecommand(int articleNumber) {
		System.out.println("将要查询推荐"+articleNumber);
		// TODO Auto-generated method stub
		List<Recommand> list_Recommand = null;  
        String sql = "SELECT * FROM recommand WHERE articlenumber=?";  
        list_Recommand = jdbcTemplateObject.query(sql, new Object[]{articleNumber}, new RecommandMaper());  
        if(list_Recommand!=null&&list_Recommand.size()>0){
        	return true;
        }else{
        	return false;
        }
	}

}
