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

import com.example.entity.Mascota;
import com.example.services.MascotaService;
import com.example.utils.Constantes;

@RestController
@RequestMapping("/rest/mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
	
	@Autowired
	private MascotaService service;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Mascota>> listar(){
		List<Mascota> lista = service.listaMascota();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaMascota(@RequestBody Mascota obj){
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Mascota objsalida = service.inserta(obj);
			if(objsalida == null){
				salida.put("mensaje", Constantes.MENSAJE_MASCOTA_ERROR_REGISTRAR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_MASCOTA_REGISTRADO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_MASCOTA_ERROR_REGISTRAR);
		}
		
		return ResponseEntity.ok(salida);
	}
	
	

}
