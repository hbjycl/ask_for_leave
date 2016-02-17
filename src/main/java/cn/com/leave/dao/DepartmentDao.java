/**
 * 
 */
package cn.com.leave.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import cn.com.leave.entity.AppTables;
import cn.com.leave.entity.Department;
import cn.com.leave.entity.Staff;
import cn.com.leave.entity.rowmapper.DepartmentRowMapper;
import cn.com.leave.entity.rowmapper.StaffRowMapper;

/**
 * @author chenlu
 * @date 2015年10月21日
 */
@Repository
public class DepartmentDao {
	JdbcTemplate jdbcTemplate;

    public List<Department> getAll() {
	StringBuilder sql = new StringBuilder();
	sql.append("select * from " + AppTables.TBL_DEPARTMENT + " where  1=1");
	return jdbcTemplate.query(sql.toString(),new DepartmentRowMapper());
    }

}
