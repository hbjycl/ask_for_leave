package cn.com.leave.dao;

import cn.com.leave.entity.AppTables;
import cn.com.leave.entity.User;
import cn.com.leave.entity.rowmapper.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by chenlu on 2016/2/1.
 */
@Repository
public class UserDao{
    @Resource
    private JdbcTemplate jdbcTemplate;

    public User login(String username,String password)
    {
        String sql = "SELECT * FROM "+ AppTables.TBL_ADMIN+" WHERE username = ? AND password = ?";
        User user  = this.jdbcTemplate.queryForObject(sql,new Object[] {username,password},new UserRowMapper());
        return user;
    }

    public User getByUsername(String username)
    {
        String sql = "SELECT * FROM "+ AppTables.TBL_ADMIN + "WHERE username = ?";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserRowMapper());
    }
}

