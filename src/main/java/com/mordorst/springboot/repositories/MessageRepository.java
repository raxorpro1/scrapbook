package com.mordorst.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mordorst.springboot.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Message findByAutor(String autor);

}
