package com.axia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "email", nullable = false, unique = true, length = 45)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@Column(name = "jenis_kelamin", nullable = false)
	private Integer jenisKelamin;
	
	@Column(name = "no_telp")
	private String noTelp;
	
	@Column(name = "alamat")
	private String alamat;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Integer getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(Integer jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public String getNoTelp() {
		return noTelp;
	}

	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
