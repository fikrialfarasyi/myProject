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
import com.axia.model.Supplier;
import com.axia.service.SupplierService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/supplier")
public class SupplierController {

	public SupplierService supplierService;

	public SupplierController(SupplierService supplierService) {
		super();
		this.supplierService = supplierService;
	}

	// Add Supplier
	@PostMapping("/add")
	public Supplier addBarang(@RequestBody Supplier supplier) {
		Supplier result = supplierService.addSupplier(supplier);

		return result;

	}
	
	@GetMapping("/listSupplier")
	public List<Supplier> getAllListSupplier(){
		
		List<Supplier> result = supplierService.getAllListSupplier();
		
		return result;
	}
	
	@GetMapping("/listSupplierById")
	public Supplier getListSupplierById(@RequestParam Long id){
		
		Supplier result = supplierService.getListSupplierById(id);
		
		return result;
	}
	
	@PutMapping("/updateSupplier")
	public Supplier updateSupplierById(@RequestBody Supplier supplier, @RequestParam Long id){
		
		Supplier result = supplierService.updateSupplierById(supplier, id);
		
		return result;
		
	}
	
	@DeleteMapping("/deleteSupplier")
	public Long deleteSupplier(@RequestParam Long id){
		Long result = supplierService.deleteSupplier(id);
		
		return result;
		
	}

}
