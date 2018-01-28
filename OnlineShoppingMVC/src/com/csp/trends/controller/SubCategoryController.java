package com.csp.trends.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csp.trends.dto.CategoryDTO;
import com.csp.trends.dto.SubCategoryDTO;
import com.csp.trends.service.AdminService;

@WebServlet("/subcategory")
public class SubCategoryController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subCategoryName = req.getParameter("subCategoryName");
		String  id  =  req.getParameter("categoryId");
		AdminService adminService = new AdminService();
		if(subCategoryName!=null&&id!=null)
		{
			Integer categoryId  = Integer.parseInt(id);
			adminService.saveSubCategory( subCategoryName, categoryId);
		}
	
		List<SubCategoryDTO> subCategoryDTOs = adminService.getSubCategory();
		List<CategoryDTO> categoryDTOs = adminService.getCategory();
		req.setAttribute("subcategories", subCategoryDTOs);
		req.setAttribute("categories", categoryDTOs);
		RequestDispatcher rd = req.getRequestDispatcher("subcategory.jsp");
		rd.forward(req, resp);
	
	}
}
