package com.axia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axia.exception.ResourceNotFoundException;
import com.axia.model.Barang;
import com.axia.repository.BarangRepository;
import com.axia.service.BarangService;

@Service
public class BarangServiceImpl implements BarangService {
	
	@Autowired
	private BarangRepository barangRepository;
	
	@Override
	public Barang addBarang(Barang barang) {
		try {
			Barang result = barangRepository.save(barang);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
	}

	@Override
	public List<Barang> getAllListBarang() {
		try {
			List<Barang> result = barangRepository.getAllListBarang();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
	}


	@Override
	public Barang getListBarangById(Long id) {
		try {
			Barang result = barangRepository.getListBarangById(id);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}


	@Override
	public Barang updateBarangById(Barang barang, Long id) {
		try {
			Barang result = barangRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
			
			result.setNamaBarang(barang.getNamaBarang());
			result.setHarga(barang.getHarga());
			result.setStok(barang.getStok());
			result.setIdUser(barang.getIdUser());
			result.setIdSupplier(barang.getIdSupplier());
			
			barangRepository.save(result);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
	}


	@Override
	public Long deleteBarang(Long id) {
		try {
			Long result = barangRepository.getIdBarang(id);
			
			barangRepository.deleteById(result);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			new ResourceNotFoundException(id);
			
			return null;
		}
	}

}
