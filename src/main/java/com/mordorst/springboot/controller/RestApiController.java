package com.mordorst.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mordorst.springboot.model.Message;
import com.mordorst.springboot.service.MessageService;
import com.mordorst.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/recados")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	MessageService messageService; //Service which will do all data retrieval/manipulation work

	// -------------------Pega lista de Mensagens---------------------------------------------

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Message>> listAllUsers() {
		List<Message> messages = messageService.findAllUsers();
		if (messages.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
	}

	// -------------------Retorna uma mensagem------------------------------------------

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long id) {
		logger.info("Carregando mensagem com id {}", id);
		Message message = messageService.findById(id);
		if (message == null) {
			logger.error("mensagem {} não encontrada.", id);
			return new ResponseEntity(new CustomErrorType("mensagem com id " + id 
					+ " não encontrada"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}

	// -------------------Cria mensagem-------------------------------------------

	@RequestMapping(value = "/", method = RequestMethod.POST)

	public ResponseEntity<?> createUser(@RequestBody Message message, UriComponentsBuilder ucBuilder) {
		logger.info("Criando usuario : {}", message);

		if (messageService.isUserExist(message)) {
			logger.error("Erro ao criar. Usuário {} já existe", message.getAutor());
			return new ResponseEntity(new CustomErrorType("Erro ao criar. Usuário " + 
			message.getAutor() + " já existe."),HttpStatus.CONFLICT);
		}
		messageService.saveUser(message);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/recados/{id}").buildAndExpand(message.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Atualiza mensagem ------------------------------------------------

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody Message message) {
		logger.info("Atualizando mensagem com id {}", id);

		Message currentUser = messageService.findById(id);

		if (currentUser == null) {
			logger.error("Falha ao atualizar. Mensagem {} Não encontrada.", id);
			return new ResponseEntity(new CustomErrorType("Falha ao atualizar. Mensagem com id " + id + " não encontrada."),
					HttpStatus.NOT_FOUND);
		}

		currentUser.setAutor(message.getAutor());
		currentUser.setTitulo(message.getTitulo());
		currentUser.setContato(message.getContato());
		currentUser.setMensagem(message.getMensagem());

		messageService.updateUser(currentUser);
		return new ResponseEntity<Message>(currentUser, HttpStatus.OK);
	}

	// ------------------- Deleta mensagem-----------------------------------------

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		logger.info("carregando e apagando mensagem com id {}", id);

		Message message = messageService.findById(id);
		if (message == null) {
			logger.error("Erro ao apagar. Mensagem {} não encontrada.", id);
			return new ResponseEntity(new CustomErrorType("Erro ao apagar. Mensagem " + id + " não encontrada."),
					HttpStatus.NOT_FOUND);
		}
		messageService.deleteUserById(id);
		return new ResponseEntity<Message>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Deleta todas mensagens-----------------------------

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<Message> deleteAllUsers() {
		logger.info("Apagando todas as mensagens");

		messageService.deleteAllUsers();
		return new ResponseEntity<Message>(HttpStatus.NO_CONTENT);
	}

}