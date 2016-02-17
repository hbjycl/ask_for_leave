package cn.com.leave.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.com.leave.entity.Cause;

public class CauseRowMapper implements RowMapper<Cause> {

	@Override
	public Cause mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cause obj = new Cause();
		obj.setStaffId(rs.getString("staff_id"));
		obj.setDeparmentId(rs.getString("department_id"));
		obj.setCauseId(rs.getString("cause_id"));
		obj.setContext(rs.getString("context"));
		obj.setCreatTime(rs.getTimestamp("create_time"));
		return obj;
	}

}