package com.mordorst.springboot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="APP_USER")	
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2966704200290943399L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name="AUTOR", nullable=false)
	private String autor;
	
	@Column(name="TITULO", nullable=false)
	private String titulo;

	@Column(name="CONTATO", nullable=false)
	private String contato;
	
	@Column(name="MENSAGEM", nullable=true)
	private String mensagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Message message = (Message) o;

		if (message.titulo.equals(titulo) && message.titulo!= null) return false;	
		if (message.mensagem.equals(mensagem) && message.mensagem!= null) return false;
		if (id != null ? !id.equals(message.id) : message.id != null) return false;
		if (autor != null ? !autor.equals(message.autor) : message.autor != null) return false;
		return contato != null ? contato.equals(message.contato) : message.contato == null;
	}


}
