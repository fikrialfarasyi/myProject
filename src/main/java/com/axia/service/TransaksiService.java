package com.axia.service;

import java.util.List;

import com.axia.model.Transaksi;

public interface TransaksiService {

	Integer addTransaksi(Transaksi transaksi);

	List<Transaksi> getAllListBarang();

	Transaksi getTransaksiById(Long id);

	Transaksi updateTransaksi(Transaksi transaksi, Long id);

	Long deleteTransaksi(Long id);

}
