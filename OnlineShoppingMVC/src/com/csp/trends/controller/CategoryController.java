package com.csp.trends.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csp.trends.dao.AdminDAO;
import com.csp.trends.dto.CategoryDTO;
import com.csp.trends.service.AdminService;

@WebServlet("/category")
public class CategoryController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AdminService adminService = new AdminService();
		String categoryName = req.getParameter("categoryName");
		if(categoryName!=null)
		{
	    adminService.saveCategory(categoryName);
		}
	
	    List<CategoryDTO> categoryDTOs = adminService.getCategory();
	    req.setAttribute("categories", categoryDTOs);
	    RequestDispatcher rd = req.getRequestDispatcher("category.jsp");
		rd.forward(req, resp);
	}

}
