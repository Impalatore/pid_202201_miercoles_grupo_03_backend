package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Boleta;
import com.example.entity.Causas;
import com.example.entity.Departamento;
import com.example.entity.Edificio;
import com.example.entity.Mascota;
import com.example.entity.Pago;
import com.example.entity.Propietario;
import com.example.entity.Servicio;
import com.example.entity.Ubigeo;
import com.example.entity.Usuario;
import com.example.entity.Visitante;
import com.example.services.BoletaService;
import com.example.services.CausaService;
import com.example.services.DepartamentoService;
import com.example.services.EdificioService;
import com.example.services.MascotaService;
import com.example.services.PagoService;
import com.example.services.PropietarioService;
import com.example.services.ServicioService;
import com.example.services.UbigeoService;
import com.example.services.UsuarioService;
import com.example.services.VisitanteService;

@RestController
@RequestMapping("/rest/util")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilsController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EdificioService edificioService;
	
	@Autowired
	private PropietarioService propietarioService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private MascotaService mascotaService;
	
	@Autowired
	private VisitanteService visitanteService;
	
	@Autowired
	private UbigeoService ubigeoService;
	
	@Autowired
	private BoletaService boletaService;
	
	@Autowired
	private ServicioService servicioService;
	
	@Autowired
	private PagoService pagoService;
	
	// Spring 4
	@Autowired
	private CausaService causasService;
	
	@GetMapping("/servicio")
	@ResponseBody
	public ResponseEntity<List<Servicio>> listaServicio(){
		List<Servicio> lista = servicioService.listaServicio();
		return ResponseEntity.ok(lista);
	}
	@GetMapping("/pago")
	@ResponseBody
	public ResponseEntity<List<Pago>> listaPago(){
		List<Pago> lista = pagoService.listaxtodos();
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/boleta")
	@ResponseBody
	public ResponseEntity<List<Boleta>> listaBoleta(){
		List<Boleta> lista = boletaService.listaxtodos();
		return ResponseEntity.ok(lista);
	}
	
	
	//  Combo Box Usuario para Formulario Departamento, Propietario, Visitante
	@GetMapping("/usuario")
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaUsuario(){
		List<Usuario> listau = usuarioService.listaUsuario();
		return ResponseEntity.ok(listau);
	}
	
//  Combo Box Edificio para Formulario Departamento 
	@GetMapping("/edificio")
	@ResponseBody
	public ResponseEntity<List<Edificio>> listaEdificio(){
		List<Edificio> listae = edificioService.listaEdificio();
		return ResponseEntity.ok(listae);
	}
	
//	Combo Box Propietario para Formulario Mascota, Visitante	
	@GetMapping("/propietario")
	@ResponseBody
	public ResponseEntity<List<Propietario>> listaPropietario(){
		List<Propietario> listap = propietarioService.listaPropietario();
		return ResponseEntity.ok(listap);
	}
	
// Combo Box Departamento para Formulario Mascota, Propietario
	@GetMapping("/departamento")
	@ResponseBody
	public ResponseEntity<List<Departamento>> listaDepartamento(){
		List<Departamento> listad = departamentoService.listaDepartamento();
		return ResponseEntity.ok(listad);
	}
	
	
	//Lista de Mascota para la Tabla M. en el Formulario M.
    @GetMapping("/mascota")
    @ResponseBody
    public ResponseEntity<List<Mascota>> listaMascota(){
        List<Mascota> listam = mascotaService.listaMascota();
        return ResponseEntity.ok(listam);
    }

	//Combo Box Visitante para Formulario Visita
    @GetMapping("/visitante")
    @ResponseBody
    public ResponseEntity<List<Visitante>> listaVisitante(){
        List<Visitante> listav = visitanteService.listaVisitante();
        return ResponseEntity.ok(listav);
    }
    @GetMapping("/listaDepartamentos")
	@ResponseBody
	public List<String> listaDepartamentos() {
		return ubigeoService.listaDepartamentos();
	}

	@GetMapping("/listaProvincias/{paramDep}")
	@ResponseBody
	public List<String> listaProvincias(@PathVariable("paramDep") String dep) {
		return ubigeoService.listaProvincias(dep);
	}

	@GetMapping("/listaDistritos/{paramDep}/{paramProv}")
	@ResponseBody
	public List<Ubigeo> listaDistritos(@PathVariable("paramDep") String dep, @PathVariable("paramProv") String prov) {
		return ubigeoService.listaDistritos(dep, prov);
	}
	
	// SPRING 04
	// Combo Box Causas para Formulario Incidente
	@GetMapping("/causas")
	@ResponseBody
	public ResponseEntity<List<Causas>> listaCausas(){
		List<Causas> listac = causasService.listaCausas();
		return ResponseEntity.ok(listac);		
	}
	
}
