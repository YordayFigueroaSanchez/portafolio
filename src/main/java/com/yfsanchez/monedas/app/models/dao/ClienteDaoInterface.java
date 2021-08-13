package com.yfsanchez.monedas.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.yfsanchez.monedas.app.models.entity.Cliente;

public interface ClienteDaoInterface extends CrudRepository<Cliente, Long>{

	
}
