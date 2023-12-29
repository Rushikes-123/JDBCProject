package com.AssigmentHospitalSet2;

import java.sql.Date;

public class Paitent {
	int pid;
	String pname;
	int age;
	float weight;
	String email;
	Date admissiondate;
	int docid;
	public Paitent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paitent(int pid, String pname, int age, float weight, String email,Date admissiondate, 
			int docid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.age = age;
		this.weight = weight;
		this.email = email;
		this.admissiondate=admissiondate;
		this.docid = docid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getAdmissiondate() {
		return admissiondate;
	}
	public void setAdmissiondate(Date admissiondate) {
		this.admissiondate = admissiondate;
	}
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	@Override
	public String toString() {
		return "Paitent [pid=" + pid + ", pname=" + pname + ", age=" + age +  ", weight=" + weight
				+ ", email=" + email + ", admissiondate=" + admissiondate + ", docid=" + docid + "]";
	}
	
	
}
