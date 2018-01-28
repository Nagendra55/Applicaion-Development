package com.jspiders.project.service;

import javax.servlet.annotation.WebServlet;

import com.jspiders.project.DAO.LoginDao;
import com.jspiders.project.DTO.RegisterDTO;
import com.jspiders.project.encrypt.Sha256;
import com.jspiders.project.logincontroller.LoginController;
import org.hibernate.Session;
@WebServlet("/service")
public class Service {
	LoginDao dao = new LoginDao();
	Sha256 sha = new Sha256();
public boolean get(String email,String password) {
	RegisterDTO dto = dao.getDetails(email,password);
	String dbpassword = dto.getPassword();
	System.out.println("dbpassword "+dbpassword);
	String date = dto.getDate();
	System.out.println("date "+date);
	String encryptpassword = sha.encrypt(date, password);
	System.out.println("encryptpassword "+encryptpassword);
	if(dbpassword.equals(encryptpassword))
	{
		return true;
	}
	else
	{
		return false;
	}
}
}
