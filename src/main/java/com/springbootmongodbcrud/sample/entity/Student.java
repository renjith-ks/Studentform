package com.springbootmongodbcrud.sample.entity;
import java.time.LocalDate;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="stud")
public class Student {
	
	public static final  String SEQUNCE_NAME="Stud_Sequence";

	@Id
	private String stud_roll;
	private String name;
	private String date;
	private String list1;
	private String division;
	private String  gender;
	public String getId() {
		return stud_roll;
	}
	public void setId(String id) {
		this.stud_roll = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getList1() {
		return list1;
	}
	public void setList1(String list1) {
		this.list1 = list1;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
	