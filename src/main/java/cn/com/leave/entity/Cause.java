package cn.com.leave.entity;

import java.util.Date;

public class Cause {

	private String causeId;
	private String staffId;
	private String context;
	private Date creatTime;
	private String deparmentId;

	public String getCauseId() {
		return causeId;
	}

	public void setCauseId(String causeId) {
		this.causeId = causeId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getDeparmentId() {
		return deparmentId;
	}

	public void setDeparmentId(String deparmentId) {
		this.deparmentId = deparmentId;
	}

}
