package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Pago;
import com.example.services.PagoService;

@RestController
@RequestMapping("/rest/pago")
@CrossOrigin(origins = "http://localhost:4200")
public class PagoController {

	@Autowired
	private PagoService pagoService;
	
	
	

	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaActualizaPago(@RequestBody Pago obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Pago objSalida = pagoService.insertaActualizaPago(obj);
			if (objSalida == null) {
				salida.put("mensaje", com.example.utils.Constantes.MENSAJE_PAGO_ERROR_REGISTRAR);
			}else {
				salida.put("mensaje", com.example.utils.Constantes.MENSAJE_PAGO_REGISTRADO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.example.utils.Constantes.MENSAJE_PAGO_ERROR_REGISTRAR);
		}
		return ResponseEntity.ok(salida);
	}
}
