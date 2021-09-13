package com.axia.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axia.exception.ResourceNotFoundException;
import com.axia.model.Barang;
import com.axia.model.Supplier;
import com.axia.repository.SupplierRepository;
import com.axia.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{
	
	public SupplierRepository supplierRepository;
	
	public SupplierServiceImpl(SupplierRepository supplierRepository) {
		super();
		this.supplierRepository = supplierRepository;
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		
		try {
			Supplier result = supplierRepository.save(supplier);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
	}

	@Override
	public List<Supplier> getAllListSupplier() {
		try {
			List<Supplier> result = supplierRepository.findAll();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}

	@Override
	public Supplier getListSupplierById(Long id) {
		try {
			Supplier result = supplierRepository.getSupplierById(id);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			new ResourceNotFoundException(id);
			
			return null;
		}
	}

	@Override
	public Supplier updateSupplierById(Supplier supplier, Long id) {
		try {
			Supplier result = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
			
			result.setNamaSupplier(supplier.getNamaSupplier());
			result.setNoTelp(supplier.getNoTelp());
			result.setAlamat(supplier.getAlamat());
			
			supplierRepository.save(result);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}

	@Override
	public Long deleteSupplier(Long id) {
		try {
			Long result = supplierRepository.getIdBarang(id);
			
			supplierRepository.deleteById(result);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			new ResourceNotFoundException(id);
			
			return null;
		}
	}

}
