package com.model;

public class Employee {
	private String empid;
	private String empname;
	private String empmail;
	private String empcontact;
	public Employee(String empid, String empname, String empmail, String empcontact) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empmail = empmail;
		this.empcontact = empcontact;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpmail() {
		return empmail;
	}
	public void setEmpmail(String empmail) {
		this.empmail = empmail;
	}
	public String getEmpcontact() {
		return empcontact;
	}
	public void setEmpcontact(String empcontact) {
		this.empcontact = empcontact;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empmail=" + empmail + ", empcontact="
				+ empcontact + "]";
	}
}
