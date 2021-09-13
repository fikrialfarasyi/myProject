package com.axia.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axia.model.Barang;
import com.axia.model.Supplier;
import com.axia.model.User;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Long>{

	/*
	 * @NamedNativeQuery( name = "queryGetAllBarang", resultSetMapping =
	 * "mappingAllBarang", query =
	 * " SELECT b.*, s.nama_supplier, u.nama FROM barang b " +
	 * " JOIN supplier s ON s.id=b.id_supplier " +
	 * "	JOIN user u on u.id=b.id_user ")
	 * 
	 * @SqlResultSetMapping( name = "mappingAllBarang", entities = {
	 * 
	 * @EntityResult( entityClass = Supplier.class, fields = {
	 * 
	 * @FieldResult(name = "id", column = "s.id"),
	 * 
	 * @FieldResult(name = "namaSupplier", column = "s.nama_supplier") }) })
	 */
	
	@Query(nativeQuery = true,
			value = "SELECT * FROM barang ")
	List<Barang> getAllListBarang();

	@Query(nativeQuery = true,
			value = "SELECT * FROM barang "
					+ "WHERE id = :id")
	Barang getListBarangById(@Param("id") Long id);

	@Query(nativeQuery = true,
			value = "SELECT id FROM barang "
					+ "WHERE id = :id")
	Long getIdBarang(Long id);

	@Query(nativeQuery = true,
			value = " SELECT stok FROM barang "
					+ " WHERE id = :id ")
	Integer checkStok(@Param("id") long idBarang);

	@Modifying
	@Query(nativeQuery = true,
			value = " UPDATE barang "
					+ " SET stok = stok - :jumlah "
					+ " WHERE id = :id ")
	void updateStok(@Param("id") long idBarang, @Param("jumlah") Integer jumlah);

}
