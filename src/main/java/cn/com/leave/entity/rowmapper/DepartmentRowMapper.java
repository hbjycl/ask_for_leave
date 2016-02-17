package cn.com.leave.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.com.leave.entity.Department;

public class DepartmentRowMapper implements RowMapper<Department> {
	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department obj = new Department();
		obj.setDepartmentId(rs.getString("department_id"));
		obj.setDepartmentName(rs.getString("department_name"));
		return obj;
	}
}
