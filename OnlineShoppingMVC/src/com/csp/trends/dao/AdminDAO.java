package com.csp.trends.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.csp.trends.dto.CategoryDTO;
import com.csp.trends.dto.CompanyDTO;
import com.csp.trends.dto.ProductDTO;
import com.csp.trends.dto.SubCategoryDTO;
import com.csp.trends.util.HibernateUtil;

public class AdminDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	String hqlGetCompany = "from CompanyDTO";
	String hqlGetCategory = "from CategoryDTO";
	String hqlGetSubCategory = "from SubCategoryDTO";
	String hqlGetProduct = "from ProductDTO";

	public void saveCategory(CategoryDTO categoryDTO) {

		Transaction tx = session.beginTransaction();
		session.save(categoryDTO);
		tx.commit();
	}

	public void saveSubCategory(SubCategoryDTO subCategoryDTO) {

		Transaction tx = session.beginTransaction();
		session.save(subCategoryDTO);
		tx.commit();
	}

	public void saveCompany(CompanyDTO companyDTO) {

		Transaction tx = session.beginTransaction();
		session.save(companyDTO);
		tx.commit();
	}

	public void saveProduct(ProductDTO productDTO) {

		Transaction tx = session.beginTransaction();
		session.save(productDTO);
		tx.commit();
	}
	
	public List<CompanyDTO> getCompany() {

		Query query = session.createQuery(hqlGetCompany);
		List<CompanyDTO> list = query.list();
		return list;
	}
	public List<CategoryDTO> getCategory() {

		Query query = session.createQuery(hqlGetCategory);
		List<CategoryDTO> list = query.list();
		return list;
	}
	public List<SubCategoryDTO> getSubCategory() {

		Query query = session.createQuery(hqlGetSubCategory);
		List<SubCategoryDTO> list = query.list();
		return list;
	}
	public List<ProductDTO> getProduct() {

		Query query = session.createQuery(hqlGetProduct);
		List<ProductDTO> list = query.list();
		return list;
	}
}
