package com.yfsanchez.monedas.app.models.dao;

import java.util.List;

import com.yfsanchez.monedas.app.models.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();

}
