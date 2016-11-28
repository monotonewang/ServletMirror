package com.demo.jdbc.bean;

public class Student {
	int flowID;
	int type;
	String idCard;
	String examStudent;
	String studentName;
	String location;
	int gradle;
	
	public int getFlowID() {
		return flowID;
	}
	public void setFlowID(int flowID) {
		this.flowID = flowID;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getExamStudent() {
		return examStudent;
	}
	public void setExamStudent(String examStudent) {
		this.examStudent = examStudent;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getGradle() {
		return gradle;
	}
	public void setGradle(int gradle) {
		this.gradle = gradle;
	}
	@Override
	public String toString() {
		return "Student [flowID=" + flowID + ", type=" + type + ", idCard=" + idCard + ", examStudent=" + examStudent
				+ ", studentName=" + studentName + ", location=" + location + ", gradle=" + gradle + "]";
	}

	
}
