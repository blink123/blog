package cx.system.dao;

import java.util.List;
import javax.sql.DataSource;
import cx.system.blogger.Blogger;

public interface BloggerDao {
	public void setdatasource(DataSource ds);
	public void addBlogger(Blogger blogger);
	public void delBloggerByName(String name);
	public void updBlogger(Blogger blogger);
	public List<Blogger> findBloggerByName(String name);
	public List<Blogger> allbloggers();
}
