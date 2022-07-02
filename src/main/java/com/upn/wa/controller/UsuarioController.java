package com.upn.wa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.upn.wa.model.Usuario;
import com.upn.wa.service.UsuarioService;

@RestController
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	//Obtener todos los datos
	@GetMapping(value="/todos")
	public ResponseEntity<List<Usuario>>obtenerTodosUsuarios()
	{
		return new ResponseEntity<List<Usuario>>(usuarioService.obtenerTodos(),HttpStatus.OK);
		
	}
	//Obtener datos por ID
	@GetMapping(value="/ObtenerxID/{id}")
	public Optional<Usuario> obtenerPorID(@PathVariable("id")String id) {
		return usuarioService.obtenerById(id);
	}
	//Guardar datos
	@PostMapping(value="/guardar")
	public ResponseEntity<Usuario>guardar(@RequestBody Usuario usuario)
	{
		return new ResponseEntity<Usuario>(usuarioService.guardar(usuario),HttpStatus.OK);
	}
	//Modificar datos
	@PutMapping(value="/modificarxID/{id}")
	public ResponseEntity<Usuario>modificabyID(@PathVariable("id")String id,@RequestBody Usuario usuario)
	{
		Usuario objusuario=usuarioService.buscarPorId(id);
		objusuario.setClave(usuario.getClave());
		objusuario.setEstado(usuario.getEstado());
		return new ResponseEntity<Usuario>(usuarioService.guardar(objusuario),HttpStatus.OK);
	}
	//eliminar datos
	@DeleteMapping(value="/eliminarxID/{id}")
	public String eliminarbyID(@PathVariable("id")String id)
	{
		usuarioService.eliminarPorId(id);
		
		return "Usuario eliminado - ID: "+id;
	}
}
