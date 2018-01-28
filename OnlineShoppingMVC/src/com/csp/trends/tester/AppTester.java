package com.csp.trends.tester;

import java.util.ArrayList;
import java.util.List;

import com.csp.trends.dao.ProductDAO;
import com.csp.trends.dto.CategoryDTO;
import com.csp.trends.dto.CompanyDTO;
import com.csp.trends.dto.ProductDTO;
import com.csp.trends.dto.SubCategoryDTO;

public class AppTester {
	public static void main(String[] args) {
		
		ProductDTO productDTO = new ProductDTO();
		CompanyDTO companyDTO = new CompanyDTO();
		CategoryDTO categoryDTO = new CategoryDTO();
		/*SubCategoryDTO subCategoryDTO = new SubCategoryDTO();*/
		List<ProductDTO> productDTOs = new ArrayList<>();
		productDTOs.add(productDTO);
 		companyDTO.setCompanyName("HP");
		companyDTO.setProductDTO(productDTOs);
		
		categoryDTO.setCategoryName("Electronics");
		/*SubCategoryDTO subCategoryDTO1 = new SubCategoryDTO();
		subCategoryDTO1.setSubCategoryName("Mobiles");
		subCategoryDTO1.setProductDTO(productDTO);*/
		SubCategoryDTO subCategoryDTO2 = new SubCategoryDTO();
		subCategoryDTO2.setSubCategoryName("Laptops");
		subCategoryDTO2.setProductDTO(productDTOs);
		/*SubCategoryDTO subCategoryDTO3 = new SubCategoryDTO();
		subCategoryDTO3.setSubCategoryName("Accessories");
		subCategoryDTO3.setProductDTO(productDTO);*/
		
		/*subCategoryDTO1.setCategoryDTO(categoryDTO);*/
		subCategoryDTO2.setCategoryDTO(categoryDTO);
		/*subCategoryDTO3.setCategoryDTO(categoryDTO);*/
		
		List<SubCategoryDTO> subCategoryDTOs = new ArrayList<SubCategoryDTO>();
		/*subCategoryDTOs.add(subCategoryDTO1);*/
		subCategoryDTOs.add(subCategoryDTO2);
		/*subCategoryDTOs.add(subCategoryDTO3);*/
		
		categoryDTO.setSubCategoryDTO(subCategoryDTOs);
		
		productDTO.setProductName("Pavilion");
		productDTO.setProductPrice(50000);
		productDTO.setProductQuantity(300);
		productDTO.setCompanyDTO(companyDTO);
		productDTO.setCategoryDTO(categoryDTO);
		productDTO.setSubCategoryDTO(subCategoryDTO2);
		productDTO.setDescription("Curved display >> 6 inch >> water resistent");
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.save(productDTO);
	}

}
