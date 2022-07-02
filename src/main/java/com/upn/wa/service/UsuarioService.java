package com.upn.wa.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upn.wa.model.Usuario;
import com.upn.wa.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private EntityManager em=null;
	
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Obtener todos los datos
	public List<Usuario>obtenerTodos()
	{
		return usuarioRepository.findAll();
	}
	//Obtener por ID
	public Optional<Usuario> obtenerById(String id)
	{
		return usuarioRepository.findById(id);
	}
	//Guardar objeto usuario
	public Usuario guardar(Usuario usuario)
	{
		return usuarioRepository.save(usuario);
	}
	//Buscar por ID
	public Usuario buscarPorId(String id)
	{
		return (Usuario) em.createQuery("select a from Usuario a where a.id= :p1")
				.setParameter("p1", id).getSingleResult();
	}
	//Eliminar por ID
	public void eliminarPorId(String id)
	{
		usuarioRepository.deleteById(id);
	}
	
}
 