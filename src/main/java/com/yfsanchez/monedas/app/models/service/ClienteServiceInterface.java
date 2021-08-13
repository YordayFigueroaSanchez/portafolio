package com.yfsanchez.monedas.app.models.service;

import java.util.List;

import com.yfsanchez.monedas.app.models.entity.Cliente;


public interface ClienteServiceInterface {

	public List<Cliente> findAll();

	public void save(Cliente cliente);

	public Cliente findOne(Long id);

	public void delete(Long id);

}
