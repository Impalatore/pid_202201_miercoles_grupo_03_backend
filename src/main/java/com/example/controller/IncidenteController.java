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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Incidente;
import com.example.services.IncidenteService;

@RestController
@RequestMapping("/rest/incidente")
@CrossOrigin(origins = "http://localhost:4200")
public class IncidenteController {
	
	@Autowired
	private IncidenteService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Incidente>> listar(){
		List<Incidente> lista = service.listaIncidente();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaIncidenteConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaIncidentePorEdiDepaEstaCausa(
			@RequestParam(name = "codedificio", required = false, defaultValue = "-1") int codedificio, 
			@RequestParam(name = "coddepartamento", required = false, defaultValue = "-1") int coddepartamento, 
			@RequestParam(name = "estado", required = false, defaultValue = "-1") int estado, 
			@RequestParam(name = "codcausas", required = false, defaultValue = "-1") int codcausas){
		Map<String, Object> salida = new HashMap<>();	
		try {
			List<Incidente> lista = service.listaIncidentePorEdiDepaEstaCausa(codedificio, coddepartamento, estado, codcausas);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " registros para mostrar");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al listar dicha Lista de Incidente");
		}
		
		return ResponseEntity.ok(salida);
	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> registraIncidente(@RequestBody Incidente obj){
		Map<String, Object> salida = new HashMap<>();
		
		try {
			java.util.Date utilDate = new java.util.Date();
			long lnMilisegundos = utilDate.getTime();
			java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
			java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
			
			obj.setEstado(1);
			obj.setHora(sqlTime);
			obj.setFechaAtencion(sqlDate);
			
			Incidente objsalida = service.regitra(obj);
			if (objsalida == null) {
				salida.put("mensaje", "Error al registrar dicho Incidente de codigo: "+ obj.getCodincidente());
			} else {
				salida.put("mensaje", "Se registro dicho Incidente de codigo: "+ obj.getCodincidente());
			}	
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registro Incidente correctamente");
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaIncidente(@RequestBody Incidente obj){
		Map<String, Object> salida = new HashMap<>();
		
		try {
//			java.util.Date utilDate = new java.util.Date();
//			long lnMilisegundos = utilDate.getTime();
//			java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
//			
//			obj.setHora(sqlTime);
			Incidente objsalida = service.actualiza(obj);
			if (objsalida == null) {
				salida.put("mensaje", "Error al actualizar dicho Incidente de codigo: "+ obj.getCodincidente());
			} else {
				salida.put("mensaje", "Se actualizo dicho Incidente de codigo: "+ obj.getCodincidente());
			}	
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se actualizo Incidente correctamente");
		}
		
		return ResponseEntity.ok(salida);
	}

}
