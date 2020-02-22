package com.jquispeluyo.micrometer.mongo;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsuarioRepo extends MongoRepository<Usuario, String> {
	
	Usuario findByNombre(String nombre);
}
