package cn.com.leave.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.leave.dao.StaffDao;
import cn.com.leave.entity.Staff;
import cn.com.leave.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

	@Resource
	private StaffDao staffdao;

	@Override
	public List<Staff> getAll(String departmentId) {
		return staffdao.getAll(departmentId);
	}


}
