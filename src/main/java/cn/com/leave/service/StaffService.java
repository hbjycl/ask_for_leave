package cn.com.leave.service;

import java.util.Date;
import java.util.List;

import cn.com.leave.entity.Staff;

public interface StaffService {
	
	public List<Staff> getAll(String departmentId);
}
