package com.axia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axia.model.Transaksi;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {

	@Query(nativeQuery = true,
			value = " SELECT * FROM transaksi ")
	List<Transaksi> getAllListTransaksi();

	@Query(nativeQuery = true,
			value = " SELECT * FROM transaksi "
					+ " WHERE id = :id ")
	Transaksi getTransaksiById(@Param("id") Long id);

	@Query(nativeQuery = true,
			value = "SELECT id FROM transaksi "
					+ "WHERE id = :id")
	Long getIdTransaksi(Long id);

}
