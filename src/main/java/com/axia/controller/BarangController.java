package com.axia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axia.model.Barang;
import com.axia.service.BarangService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/barang")
public class BarangController {
	
	public BarangService barangService;

	public BarangController(BarangService barangService) {
		super();
		this.barangService = barangService;
	}
	
	//Add Barang
	@PostMapping("/add")
	public Barang addBarang(@RequestBody Barang barang){
		Barang result = barangService.addBarang(barang);
		
		return result;
		
	}
	
	@GetMapping("/listBarang")
	public List<Barang> getAllListBarang(){
		
		List<Barang> result = barangService.getAllListBarang();
		
		return result;
	}
	
	@GetMapping("/listBarangById")
	public Barang getListBarangById(@RequestParam Long id){
		
		Barang result = barangService.getListBarangById(id);
		
		return result;
	}
	
	@PutMapping("/updateBarang")
	public Barang updateBarangById(@RequestBody Barang barang, @RequestParam Long id){
		
		Barang result = barangService.updateBarangById(barang, id);
		
		return result;
		
	}
	
	@DeleteMapping("/deleteBarang")
	public Long deleteBarang(@RequestParam Long id){
		Long result = barangService.deleteBarang(id);
		
		return result;
		
	}

}
