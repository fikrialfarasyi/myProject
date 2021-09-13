package com.axia.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "barang")
public class Barang {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nama_barang")
	private String namaBarang;
	
	@Column(name = "harga")
	private BigDecimal harga;
	
	@Column(name = "stok")
	private Integer stok;
	
	@Column(name = "id_supplier")
	private long idSupplier;
	
	@Column(name = "id_user")
	private long idUser;
	
//	private String namaSupplier;
//	
//	private String namaUser;
	

	public Barang() {
	}
	

	public Barang(String namaBarang, BigDecimal harga, Integer stok, long idSupplier, long idUser) {
		super();
		this.namaBarang = namaBarang;
		this.harga = harga;
		this.stok = stok;
		this.idSupplier = idSupplier;
		this.idUser = idUser;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNamaBarang() {
		return namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}

	public BigDecimal getHarga() {
		return harga;
	}

	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}

	public Integer getStok() {
		return stok;
	}

	public void setStok(Integer stok) {
		this.stok = stok;
	}

	public long getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(long idSupplier) {
		this.idSupplier = idSupplier;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	

}
