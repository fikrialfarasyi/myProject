package com.axia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.data.repository.query.Param;
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
import com.axia.model.Transaksi;
import com.axia.service.TransaksiService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/transaksi")
public class TransaksiController {
	
	public TransaksiService transaksiService;

	public TransaksiController(TransaksiService transaksiService) {
		super();
		this.transaksiService = transaksiService;
	}
	
	@PostMapping("/addTransaksi")
	public Integer addTransaksi(@RequestBody Transaksi transaksi){
		
		Integer result = transaksiService.addTransaksi(transaksi);
		
		
		return result;
		
	}
	
	@GetMapping("/listTransaksi")
	public List<Transaksi> getAllListTransaksi(){
		List<Transaksi> result = transaksiService.getAllListBarang();
		
		return result;
	}
	
	@GetMapping("/transaksiById")
	public Transaksi getTransaksi(@RequestParam Long id) {
		
		Transaksi result = transaksiService.getTransaksiById(id);
		
		return result;
	}
	
	@PutMapping("/updateById")
	public Transaksi updateTransaksi(@RequestBody Transaksi transaksi, @RequestParam Long id){
		
		Transaksi result = transaksiService.updateTransaksi(transaksi, id);
		
		return result;
		
	}
	
	@DeleteMapping("/deleteTransaksi")
	public Long deleteTransaksi(@RequestParam Long id){
		Long result = transaksiService.deleteTransaksi(id);
		
		return result;
		
	}

}
