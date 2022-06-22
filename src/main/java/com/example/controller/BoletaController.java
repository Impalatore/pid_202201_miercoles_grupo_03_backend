package com.example.controller;

import java.util.Date;
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


import com.example.entity.Boleta;
import com.example.services.BoletaService;
import com.example.utils.Constantes;

@RestController
@RequestMapping("/rest/boleta")
@CrossOrigin(origins = "http://localhost:4200")
public class BoletaController {
	
	@Autowired
	private BoletaService boletaService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Boleta>> listaBoleta(){
		List<Boleta> lista = boletaService.listaxtodos();
		return ResponseEntity.ok(lista);
	}
	
	
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaActualizaBoleta(@RequestBody Boleta obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			/*	for (int i = 0; i < 12; i++) {
			//obj..setFechaemision(lstfecha.get(i));
		    //service.setBoleta(objBoleta);
	        }*/

			obj.setEstado(1);
			obj.setFechaemision(new Date());
			Boleta objSalida = boletaService.insertaActualizaBoleta(obj);
			if (objSalida == null) {
				salida.put("mensaje", com.example.utils.Constantes.MENSAJE_BOLETA_ERROR_REGISTRAR);
			}else {
				salida.put("mensaje", com.example.utils.Constantes.MENSAJE_BOLETA_REGISTRADO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.example.utils.Constantes.MENSAJE_BOLETA_ERROR_REGISTRAR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@GetMapping("/listaBoletaConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaBoletaNombreDni(
			@RequestParam(name = "nom", required = false, defaultValue = "") String nombre,
			@RequestParam(name = "dni", required = false, defaultValue = "") String dni){
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Boleta> lista = boletaService.listaxdnixnombre(nombre, dni);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_BOLETA_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	@PutMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaBoleta(@RequestBody Boleta obj){
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Boleta objsalida = boletaService.insertaActualizaBoleta(obj);
			if(objsalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_BOLETA_ERROR_ACTUALIZAR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_BOLETA_ACTUALIZADO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_BOLETA_ERROR_ACTUALIZAR);
		}
		
		return ResponseEntity.ok(salida);
	}
}
