package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Visita;
import com.example.services.VisitaService;
import com.example.utils.Constantes;

@RestController
@RequestMapping("/rest/visita")
@CrossOrigin(origins = "http://localhost:4200")
public class VisitaController {

	@Autowired
	private VisitaService service;
	
		
	@GetMapping("/listaVisitaConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaVisitaPorDNIXNOMBRE(
			@RequestParam(name = "nom", required =  false, defaultValue = "-1")String nombre,
			@RequestParam(name = "dni", required =  false, defaultValue = "-1")String dni){
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Visita> lista = service.listaVisitaxDNINOMBRE(nombre, dni);
			if(CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size()+" registros para mostrar");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_VISITA_ERROR_REGISTRAR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaVisita(@RequestBody Visita obj){
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Visita objsalida = service.registra(obj);
			if(objsalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_VISITA_ERROR_ACTUALIZAR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_VISITA_ACTUALIZADO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_VISITA_ERROR_ACTUALIZAR);
		}
		
		return ResponseEntity.ok(salida);
	}
	
}
