package com.csp.trends.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.csp.trends.dto.ProductDTO;
import com.csp.trends.util.HibernateUtil;

public class ProductDAO {

	Session session =HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
	String hql = "from ProductDTO";
	
	public void save(ProductDTO productDTO) {

		tx = session.beginTransaction();
		session.save(productDTO);
		tx.commit();
	}
	
	public List<ProductDTO> get()
	{
		/*ProductDTO productDTO = new ProductDTO();
		ProductDTO productDTO2 = session.get(ProductDTO.class, 1);*/
		Query query = session.createQuery(hql);
		List<ProductDTO> lst = query.list();
		return lst;
		
	}
	
}
