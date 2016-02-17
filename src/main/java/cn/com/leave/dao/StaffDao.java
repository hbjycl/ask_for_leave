/**
 * 
 */
package cn.com.leave.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import cn.com.leave.entity.AppTables;
import cn.com.leave.entity.Staff;
import cn.com.leave.entity.rowmapper.StaffRowMapper;

/**
 * @author chenlu
 * @date 2015年10月21日
 */
@Repository
public class StaffDao {
	JdbcTemplate jdbcTemplate;

    public List<Staff> getAll(String departmentId) {
	StringBuilder sql = new StringBuilder();
	sql.append("select * from " + AppTables.TBL_STAFF + " where  1=1");
	List<Object> params = new ArrayList<Object>();
	if(StringUtils.isNotBlank(departmentId))
	{
		sql.append(" and departmentId = ?");
		params.add(departmentId);
	}
	return jdbcTemplate.query(sql.toString(),params.toArray(),new StaffRowMapper());
    }

}
