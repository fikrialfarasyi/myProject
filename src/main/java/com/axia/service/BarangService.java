package com.axia.service;

import java.util.List;

import com.axia.model.Barang;

public interface BarangService {

	Barang addBarang(Barang barang);

	List<Barang> getAllListBarang();

	Barang getListBarangById(Long id);

	Barang updateBarangById(Barang barang, Long id);

	Long deleteBarang(Long id);

}
