package com.axia.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axia.exception.ResourceNotFoundException;
import com.axia.model.Barang;
import com.axia.model.Transaksi;
import com.axia.repository.BarangRepository;
import com.axia.repository.TransaksiRepository;
import com.axia.service.TransaksiService;

@Service
@Transactional
public class TransaksiServiceImpl implements TransaksiService {
	
	public TransaksiRepository transaksiRepository;
	public BarangRepository barangRepository;
	
	public TransaksiServiceImpl(TransaksiRepository transaksiRepository, BarangRepository barangRepository) {
		super();
		this.transaksiRepository = transaksiRepository;
		this.barangRepository = barangRepository;
	}

	@Override
	public Integer addTransaksi(Transaksi transaksi) {
		
		try {
			Integer stok = barangRepository.checkStok(transaksi.getIdBarang());
			
			if(stok > 0 && stok > transaksi.getJumlah()) {
				//Update Stok
				barangRepository.updateStok(transaksi.getIdBarang(), transaksi.getJumlah());
				//Save Transaksi
				Transaksi val = transaksiRepository.save(transaksi);
				
				return 1;
			}else {
				
				return 2;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return 0;
		}
		
	}

	@Override
	public List<Transaksi> getAllListBarang() {
		try {
			List<Transaksi> result = transaksiRepository.getAllListTransaksi();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}

	@Override
	public Transaksi getTransaksiById(Long id) {
		try {
			Transaksi result = transaksiRepository.getTransaksiById(id);
			
			return result;
		} catch (Exception e) {
			
			return null;
		}
	}

	@Override
	public Transaksi updateTransaksi(Transaksi transaksi, Long id) {
		try {
			Transaksi result = transaksiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
			
			result.setIdBarang(transaksi.getIdBarang());
			result.setIdUser(transaksi.getIdUser());
			result.setJumlah(transaksi.getJumlah());
			result.setKeterangan(transaksi.getKeterangan());
			result.setTanggal(transaksi.getTanggal());
			
			transaksiRepository.save(result);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}

	@Override
	public Long deleteTransaksi(Long id) {
		try {
			Long result = transaksiRepository.getIdTransaksi(id);
			
			transaksiRepository.deleteById(result);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			new ResourceNotFoundException(id);
			
			return null;
		}
	}

}
