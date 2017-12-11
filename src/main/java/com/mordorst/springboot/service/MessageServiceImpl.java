package com.mordorst.springboot.service;

import java.util.List;

import com.mordorst.springboot.model.Message;
import com.mordorst.springboot.repositories.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageRepository messageRepository;

	public Message findById(Long id) {
		return messageRepository.findOne(id);
	}

	public Message findByAutor(String autor) {
		return messageRepository.findByAutor(autor);
	}

	public void saveUser(Message message) {
		messageRepository.save(message);
	}

	public void updateUser(Message message){
		saveUser(message);
	}

	public void deleteUserById(Long id){
		messageRepository.delete(id);
	}

	public void deleteAllUsers(){
		messageRepository.deleteAll();
	}

	public List<Message> findAllUsers(){
		return messageRepository.findAll();
	}

	public boolean isUserExist(Message message) {
		return findByAutor(message.getAutor()) != null;
	}

}
