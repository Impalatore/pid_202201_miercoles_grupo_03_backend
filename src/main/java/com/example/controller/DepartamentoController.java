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

import com.example.entity.Departamento;
import com.example.services.DepartamentoService;
import com.example.utils.Constantes;

@RestController
@RequestMapping("/rest/departamento")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;
	
	@GetMapping
	@ResponseBody // --> Significa que me va retornar datos en Json
	public ResponseEntity<List<Departamento>> listar(){
		List<Departamento> lista = service.listaDepartamento();
		return ResponseEntity.ok(lista);
	}
	
//	// Registrar Departamento -- SIN MENSAJES DE ERROR
//	@PostMapping
//	@ResponseBody // ---> @RequestBody Va recibir datos en formato Json
//	public ResponseEntity<Departamento> inserta(@RequestBody  Departamento obj){
//		Departamento objSalida = service.insertaActualiza(obj);
//		return ResponseEntity.ok(objSalida);
//	}
	
	// Registrar Departamento -- CON MENSAJES DE ERROR
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaDepartamento(@RequestBody Departamento obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Departamento objsalida = service.insertaActualiza(obj);
			if(objsalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_DEPARTAMENTO_ERROR_REGISTRAR);
			}else{
				salida.put("mensaje", Constantes.MENSAJE_DEPARTAMENTO_REGISTRADO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_DEPARTAMENTO_ERROR_REGISTRAR);
		}
		
		return ResponseEntity.ok(salida);
	}
	
}
