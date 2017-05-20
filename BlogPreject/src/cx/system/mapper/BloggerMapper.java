package cx.system.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cx.system.blogger.Blogger;

public class BloggerMapper implements RowMapper<Blogger>{

	@Override
	public Blogger mapRow(ResultSet rs, int rownum) throws SQLException {
		// TODO Auto-generated method stub
		Blogger blogger = new Blogger();
		blogger.setName(rs.getString("name"));
		blogger.setPassword(rs.getString("password"));
		blogger.setLikeNumber(rs.getInt("likenumber"));
		blogger.setRewardNumber(rs.getInt("rewardnumber"));
		blogger.setHeadpicture(rs.getString("headpicture"));
		blogger.setDatetime(rs.getString("time"));
		return blogger;
	}

}
