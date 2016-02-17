package cn.com.leave.entity;

public class Staff {
	private String staffId;
	private String name;
	private String departmentId;

	public Staff(){
		
	}
	
	public Staff(String staffId, String name, String departmentId) {
		super();
		this.staffId = staffId;
		this.name = name;
		this.departmentId = departmentId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

}
