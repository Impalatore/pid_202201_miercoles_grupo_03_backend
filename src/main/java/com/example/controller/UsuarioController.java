package com.example.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Usuario;
import com.example.services.UsuarioService;


@RestController
@RequestMapping("/rest/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService; 
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaUsuarios(){
		List<Usuario> lista = usuarioService.listaUsuario();
		return ResponseEntity.ok(lista);
	}
	

	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaActualizaUsuario(@RequestBody Usuario obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setEstado(true);
			obj.setFechareg(new Date());
			Usuario objSalida = usuarioService.inserta(obj);
			if (objSalida == null) {
				salida.put("mensaje", com.example.utils.Constantes.MENSAJE_USUARIO_ERROR_REGISTRAR);
			}else {
				salida.put("mensaje", com.example.utils.Constantes.MENSAJE_USUARIO_REGISTRADO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.example.utils.Constantes.MENSAJE_USUARIO_ERROR_REGISTRAR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	

}
