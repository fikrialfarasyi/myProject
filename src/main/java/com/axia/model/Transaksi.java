package com.axia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "transaksi")
public class Transaksi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "id_barang")
	private long idBarang;
	
	@Column(name = "id_user")
	private long idUser;
	
	@Column(name = "tanggal")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date tanggal;
	
	@Column(name = "keterangan")
	private String keterangan;
	
	@Column(name = "jumlah")
	private Integer jumlah;

	public Transaksi() {
	}

	public Transaksi(long idBarang, long idUser, Date tanggal, String keterangan, Integer jumlah) {
		super();
		this.idBarang = idBarang;
		this.idUser = idUser;
		this.tanggal = tanggal;
		this.keterangan = keterangan;
		this.jumlah = jumlah;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdBarang() {
		return idBarang;
	}

	public void setIdBarang(long idBarang) {
		this.idBarang = idBarang;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public Integer getJumlah() {
		return jumlah;
	}

	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}

}
