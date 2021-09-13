package com.axia.service;

import java.util.List;

import com.axia.model.Supplier;

public interface SupplierService {

	Supplier addSupplier(Supplier supplier);

	List<Supplier> getAllListSupplier();

	Supplier getListSupplierById(Long id);

	Supplier updateSupplierById(Supplier supplier, Long id);

	Long deleteSupplier(Long id);

}
