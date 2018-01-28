package com.jspiders.project.registercontroller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspiders.project.DTO.RegisterDTO;
import com.jspiders.project.Service.Service;
import com.jspiders.project.Util.Systime;
import com.jspiders.project.encrypt.Sha256;
@WebServlet("/rc")
public class RegisterController extends HttpServlet {
	RegisterDTO dto = new RegisterDTO();
	Systime st = new Systime();
	Service ser = new Service();
	Sha256 sha = new Sha256();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String unencryptpassword = req.getParameter("password");
		String date = st.getDate();
		String encriptpassword = sha.encrypt(date,unencryptpassword );
		String gender = req.getParameter("gender");
		dto.setUsername(username);
		dto.setEmail(email);
		dto.setPassword(encriptpassword);
		dto.setGender(gender);
		dto.setDate(date);
		ser.serviceMethod(dto);
		HttpSession session = req.getSession(true);
		session.setAttribute("name", username);
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}
}
