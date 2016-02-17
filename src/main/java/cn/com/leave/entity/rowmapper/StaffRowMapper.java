package cn.com.leave.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import cn.com.leave.entity.Staff;

public class StaffRowMapper implements RowMapper<Staff> {

	@Override
	public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
		Staff obj = new Staff();
		obj.setStaffId(rs.getString("staff_id"));
		obj.setDepartmentId(rs.getString("department_id"));
		obj.setName(rs.getString("name"));
		return obj;
	}

}