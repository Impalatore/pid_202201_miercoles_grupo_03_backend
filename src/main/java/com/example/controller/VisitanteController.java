package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Visitante;
import com.example.services.VisitanteService;
import com.example.utils.Constantes;

@RestController
@RequestMapping("/rest/visitante")
@CrossOrigin(origins = "http://localhost:4200")
public class VisitanteController {

	
	@Autowired
	private VisitanteService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Visitante>> listar(){
		List<Visitante> lista = service.listaVisitante();
		return ResponseEntity.ok(lista);
		
	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaVisitante(@RequestBody Visitante obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Visitante objsalida = service.inserta(obj);
			if(objsalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_VISITANTE_ERROR_REGISTRAR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_VISITANTE_REGISTRADO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_VISITANTE_ERROR_REGISTRAR);
		}
		
		return ResponseEntity.ok(salida);
	}
		
	@GetMapping("/listaVisitanteConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaVisitanteDni(
			@RequestParam(name = "dni", required = true) String dni){
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Visitante> lista = service.listaVisitantePorDNI(dni);
			if(CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existe dicho Visitante con DNI: "+dni+" Registrarse nuevamente");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existe dicho Visitante con DNI "+dni);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_VISITANTE_ERROR_REGISTRAR);
		}
		
		return ResponseEntity.ok(salida);
	}
	
	
}
