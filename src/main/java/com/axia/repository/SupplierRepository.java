package com.axia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axia.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	@Query(nativeQuery = true,
			value = " SELECT * FROM supplier "
					+ " WHERE id = :id ")
	Supplier getSupplierById(@Param("id") Long id);

	@Query(nativeQuery = true,
			value = "SELECT id FROM supplier "
					+ "WHERE id = :id")
	Long getIdBarang(Long id);

}
