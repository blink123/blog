package liujiawei.recommand.dao;

import javax.sql.DataSource;

import liujiawei.recommand.entity.Recommand;

public interface RecommandDao {
	public void setdatasource(DataSource ds);
	public void addRecomand(Recommand recommand);
	public void delRecommandByArticleNumber(int articleNumber);
	public boolean findInRecommand(int articleNumber);
}
