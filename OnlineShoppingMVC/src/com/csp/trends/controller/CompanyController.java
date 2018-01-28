package com.csp.trends.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csp.trends.dto.CompanyDTO;
import com.csp.trends.service.AdminService;

@WebServlet(urlPatterns="/company")
public class CompanyController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String companyName  = req.getParameter("companyName");
		AdminService adminService =  new  AdminService();
		if(companyName!=null)
		{
		adminService.saveCompany(companyName);
		}
	
		List<CompanyDTO> companyDTOs=adminService.getCompany();
		req.setAttribute("companies", companyDTOs);
		RequestDispatcher rd = req.getRequestDispatcher("company.jsp");
		rd.forward(req, resp);
	}

}
