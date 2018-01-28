package com.jspiders.project.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jspiders.project.DTO.RegisterDTO;

public class LoginDao
{
	Configuration cfg = null;
	SessionFactory factory = null;
	Session session = null;
	Query query = null;
	RegisterDTO dto = null;
	public RegisterDTO getDetails(String email,String password) {
		String hql = "select dto from RegisterDTO dto where reg_email=:email1";
		try {
			cfg = new Configuration();
			cfg.configure();
			factory = cfg.buildSessionFactory();
			session = factory.openSession();
			query = session.createQuery(hql);
			query.setString("email1", email);
			dto = (RegisterDTO) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(session != null)
			{
				session.close();
			}
		}
		return dto;
	}
}