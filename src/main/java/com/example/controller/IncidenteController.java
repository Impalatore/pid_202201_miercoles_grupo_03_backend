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

import com.example.entity.Incidente;
import com.example.services.IncidenteService;
import com.example.utils.Constantes;

@RestController
@RequestMapping("/rest/incidente")
@CrossOrigin(origins = "http://localhost:4200")
public class IncidenteController {

	@Autowired
	private IncidenteService service;
	
	@GetMapping("/listaincidente")
	@ResponseBody
	public ResponseEntity<List<Incidente>> listar(){
		List<Incidente> lista = service.listaIncidente();
		return ResponseEntity.ok(lista);
	}

	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaIncidente(@RequestBody Incidente obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Incidente objsalida = service.insertaActualiza(obj);
			if(objsalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_INCIDENTE_ERROR_REGISTRAR);
			}else{
				salida.put("mensaje", Constantes.MENSAJE_INCIDENTE_REGISTRADO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_INCIDENTE_ERROR_REGISTRAR);
		}
		
		return ResponseEntity.ok(salida);
	}
	
}