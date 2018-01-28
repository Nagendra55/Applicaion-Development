package com.jspiders.project.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.jspiders.project.Util.Systime;
@Entity
@Table(name = "Register_Table")
public class RegisterDTO implements Serializable {
	public RegisterDTO() {
		System.out.println(this.getClass().getSimpleName());
	}
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "reg_id")
	private int id;
	
	@Column(name = "reg_username")
	private String username;
	
	@Column(name = "reg_email")
	private String email;
	
	@Column(name = "reg_password")
	private String password;
	
	@Column(name = "reg_gender")
	private String gender;
	
	@Column(name = "reg_date")
	private String date;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
