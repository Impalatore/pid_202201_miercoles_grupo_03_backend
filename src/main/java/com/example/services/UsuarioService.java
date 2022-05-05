package com.example.services;

import java.util.List;

import com.example.entity.Opcion;
import com.example.entity.Rol;
import com.example.entity.Usuario;


public interface UsuarioService {
	
	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	public abstract Usuario buscaPorLogin(String login);

	public abstract Usuario inserta(Usuario obj);
	
	public abstract List<Usuario> listaUsuario();
}
