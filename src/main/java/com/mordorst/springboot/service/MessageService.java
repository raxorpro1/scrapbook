package com.mordorst.springboot.service;


import java.util.List;

import com.mordorst.springboot.model.Message;

public interface MessageService {
	
	Message findById(Long id);

	Message findByAutor(String name);

	void saveUser(Message message);

	void updateUser(Message message);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<Message> findAllUsers();

	boolean isUserExist(Message message);
}