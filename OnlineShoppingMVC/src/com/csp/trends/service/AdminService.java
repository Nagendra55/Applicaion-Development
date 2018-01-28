package com.csp.trends.service;

import java.util.List;

import com.csp.trends.dao.AdminDAO;
import com.csp.trends.dto.CategoryDTO;
import com.csp.trends.dto.CompanyDTO;
import com.csp.trends.dto.ProductDTO;
import com.csp.trends.dto.SubCategoryDTO;

public class AdminService {

	AdminDAO adminDAO = new AdminDAO();
	CategoryDTO categoryDTO = new CategoryDTO();


	public void saveCategory(String categoryName) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryName(categoryName);
		adminDAO.saveCategory(categoryDTO);
	}


	public void saveSubCategory(String subCategoryName, int categoryId) {
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
		subCategoryDTO.setSubCategoryName(subCategoryName);
		categoryDTO.setCategoryId(categoryId);
		subCategoryDTO.setCategoryDTO(categoryDTO);
		adminDAO.saveSubCategory(subCategoryDTO);
	}


	public void saveCompany(String companyName) {

		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setCompanyName(companyName);
		adminDAO.saveCompany(companyDTO);
	}


	public void saveProduct(String productName, double productPrice, int productQuantity, int companyId, int categoryId,
			int subCategoryId, String productDescription) {

		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName(productName);
		productDTO.setProductPrice(productPrice);
		productDTO.setProductQuantity(productQuantity);
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setCompanyId(companyId);
		productDTO.setCompanyDTO(companyDTO);
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(subCategoryId);
		productDTO.setCategoryDTO(categoryDTO);
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
		subCategoryDTO.setSubCategoryId(subCategoryId);
		productDTO.setSubCategoryDTO(subCategoryDTO);
		productDTO.setDescription(productDescription);
		adminDAO.saveProduct(productDTO);
	}

	public List<CompanyDTO> getCompany() {
		List<CompanyDTO> list = adminDAO.getCompany();
		return list;
	}
	
	public List<CategoryDTO> getCategory() {
		List<CategoryDTO> list = adminDAO.getCategory();
		return list;
	}

	public List<SubCategoryDTO> getSubCategory() {

		List<SubCategoryDTO> list = adminDAO.getSubCategory();
		return list;
	}
	
	public List<ProductDTO> getProduct() {
		List<ProductDTO> list =adminDAO.getProduct();
		return list;
	}
}


