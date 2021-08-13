package com.yfsanchez.monedas.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yfsanchez.monedas.app.models.entity.Cliente;
import com.yfsanchez.monedas.app.models.service.ClienteServiceInterface;


@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteServiceInterface clienteService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		
		model.addAttribute("titulo","Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "cliente/listar";
	}
	
	@RequestMapping(value = "/crear")
	public String crear(Map<String, Object> model) {
		Cliente client = new Cliente();
		
		model.put("cliente", client);
		model.put("titulo", "Crear Cliente");
		return "cliente/crear";
	}
	
	@RequestMapping(value = "/crear/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Cliente client = null;
		if (id > 0) {
			client = clienteService.findOne(id);
		} else {
			return "redirect:listar";
		}
		model.put("cliente", client);
		model.put("titulo", "Editar Cliente");
		return "cliente/crear";
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id > 0) {
			clienteService.delete(id);
		} 
		
		return "redirect:/cliente/listar";
	}
	
	
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute("cliente") Cliente client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			
			return "cliente/crear";
		}
		clienteService.save(client);
		return "redirect:listar";
	}

}
