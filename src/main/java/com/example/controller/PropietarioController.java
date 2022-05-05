package com.example.controller;

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


import com.example.entity.Propietario;
import com.example.services.PropietarioService;

@RestController
@RequestMapping("/rest/propietario")
@CrossOrigin(origins = "http://localhost:4200")
public class PropietarioController {
	
	@Autowired
	private PropietarioService propietarioservice; 
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Propietario>> listaPropietario(){
		List<Propietario> lista = propietarioservice.listaPropietario();
		return ResponseEntity.ok(lista);
	}
	

	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaActualizaPropietario(@RequestBody Propietario obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Propietario objSalida = propietarioservice.insertaActualizaPropietario(obj);
			if (objSalida == null) {
				salida.put("mensaje", com.example.utils.Constantes.MENSAJE_PROPIETARIO_ERROR_REGISTRAR);
			}else {
				salida.put("mensaje", com.example.utils.Constantes.MENSAJE_PROPIETARIO_REGISTRADO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.example.utils.Constantes.MENSAJE_PROPIETARIO_ERROR_REGISTRAR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	
	

}
