package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.NewUserDAO;
import com.example.lesson04.model.NewUser;

@Service
public class NewUserBO {
	
	@Autowired
	private NewUserDAO newUserDAO;
	
	//select - void(리턴값 없음, 수행만)            insert, update, delete - int(몇행이 성공했는지)
	public void addNewUser(String name, String yyyymmdd, String email, String introduce) {
		newUserDAO.insertNewUser(name, yyyymmdd, email, introduce);
	}
	
	public NewUser getLastNewUser() {
		return newUserDAO.selectLastNewUser();
	}
}
