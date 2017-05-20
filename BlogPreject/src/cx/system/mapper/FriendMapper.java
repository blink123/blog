package cx.system.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cx.system.blogger.Blogger;
import cx.system.blogger.Friend;

public class FriendMapper implements RowMapper<Friend>{

	@Override
	public Friend mapRow(ResultSet rs, int rownum) throws SQLException {
		// TODO Auto-generated method stub
		Friend friend = new Friend();
		friend.setBloggername(rs.getString("bloggername"));
		friend.setFriendname(rs.getString("friendname"));
		return friend;
		
	}

}
