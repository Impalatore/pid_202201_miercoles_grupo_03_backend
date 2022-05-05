package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Opcion;
import com.example.entity.Rol;
import com.example.entity.Usuario;
import com.example.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario inserta(Usuario obj) {
		
		return repository.save(obj);
	}

	@Override
	public List<Usuario> listaUsuario() {
		
		return repository.findAll();
	}

	@Override
	public List<Opcion> traerEnlacesDeUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return repository.traerEnlacesDeUsuario(idUsuario);
	}

	@Override
	public List<Rol> traerRolesDeUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return repository.traerRolesDeUsuario(idUsuario);
	}

	@Override
	public Usuario buscaPorLogin(String login) {
		// TODO Auto-generated method stub
		return repository.findByLogin(login);
	}

	

}
