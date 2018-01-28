package com.csp.trends.tester;

import java.util.List;

import com.csp.trends.dao.ProductDAO;
import com.csp.trends.dto.ProductDTO;

public class GetTester {
public static void main(String[] args) {
	
	ProductDAO productDAO = new ProductDAO();
	List<ProductDTO> productDTO = productDAO.get();
	for(ProductDTO productDTO2:productDTO )
	{
	System.out.println(productDTO2.getProductName());
	}
}
}
