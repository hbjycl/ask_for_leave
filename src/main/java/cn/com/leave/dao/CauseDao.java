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
import cn.com.leave.entity.Staff;
import cn.com.leave.entity.rowmapper.StaffRowMapper;

/**
 * @author chenlu
 * @date 2015年10月21日
 */
@Repository
public class CauseDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void add(String causeId, Staff staff,String context, Date createTime) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert INTO " + AppTables.TBL_CAUSE + " (cause_id,staff_id,department_id,context,create_time) VALUES (?,?,?,?,?)");
		jdbcTemplate.update(sql.toString(), new Object[] { causeId, staff.getStaffId(),staff.getDepartmentId(), context, createTime });
	}

}
