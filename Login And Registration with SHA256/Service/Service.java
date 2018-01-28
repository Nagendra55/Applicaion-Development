package com.jspiders.project.Service;

import com.jspiders.project.DAO.RegisterDAO;
import com.jspiders.project.DTO.RegisterDTO;

public class Service {
	RegisterDAO dao = new RegisterDAO();
	public void serviceMethod(RegisterDTO dto) {
		dao.save(dto);
	}
}
