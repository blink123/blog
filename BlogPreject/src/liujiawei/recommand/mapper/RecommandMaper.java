package liujiawei.recommand.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import liujiawei.recommand.entity.Recommand;

public class RecommandMaper implements RowMapper<Recommand> {
	@Override
	public Recommand mapRow(ResultSet rs, int rownum) throws SQLException {
		// TODO Auto-generated method stub
		Recommand recommand = new Recommand();
		recommand.setNumber(rs.getInt("number"));
		recommand.setArticlenumber(rs.getInt("articlenumber"));
		return recommand;
	}
}
