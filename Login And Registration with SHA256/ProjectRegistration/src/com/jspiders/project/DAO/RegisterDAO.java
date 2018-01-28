package com.jspiders.project.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

import com.jspiders.project.DTO.RegisterDTO;

public class RegisterDAO {
	Configuration cfg = null;
	SessionFactory factory = null;
	Session session = null;
	Transaction tx = null;
	public void save(RegisterDTO dto) {
		cfg = new Configuration();
		cfg.configure();
		factory = cfg.buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();
	}
}
