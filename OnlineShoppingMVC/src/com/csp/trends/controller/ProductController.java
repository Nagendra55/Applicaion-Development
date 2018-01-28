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
import com.csp.trends.dto.CompanyDTO;
import com.csp.trends.dto.ProductDTO;
import com.csp.trends.dto.SubCategoryDTO;
import com.csp.trends.service.AdminService;

@WebServlet("/product")
public class ProductController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String productName = req.getParameter("productName");
		String  price =req.getParameter("productPrice");
		String quantity = req.getParameter("productQuantity");
		String cId  = req.getParameter("companyId");
		String ctyId  = req.getParameter("categoryId");
		String sCId  = req.getParameter("subCategoryId");
		String productDescription = req.getParameter("productDescription");
		AdminService adminService = new AdminService();
		if(productName!=null&&price!=null&&quantity!=null&&cId!=null&&ctyId!=null&&sCId!=null&&productDescription!=null)
		{
			double productPrice = Double.parseDouble(price);
			int productQuantity = Integer.parseInt(quantity);
			int companyId = Integer.parseInt(cId);
			int categoryId = Integer.parseInt(ctyId);
			int subCategoryId = Integer.parseInt(sCId);
		adminService.saveProduct(productName,  productPrice, productQuantity, companyId, categoryId, subCategoryId, productDescription);
		}
		List<ProductDTO> productDTOs = adminService.getProduct();
		List<CompanyDTO> companyDTOs = adminService.getCompany();
		List<CategoryDTO> categoryDTOs = adminService.getCategory();
		List<SubCategoryDTO> subCategoryDTOs = adminService.getSubCategory();
		req.setAttribute("products", productDTOs);
		req.setAttribute("companies", companyDTOs);
		req.setAttribute("categories", categoryDTOs);
		req.setAttribute("subcategories", subCategoryDTOs);
		RequestDispatcher rd = req.getRequestDispatcher("product.jsp");
		rd.forward(req, resp);
 	
	}
}
