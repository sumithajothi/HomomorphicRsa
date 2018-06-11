package com.test.algorithm.runner.paillier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Paillier {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Type(type = "serializable")
	KeyPair keyPair;
	@Type(type = "text")
	String encryptedData;

	public Paillier() {
	}

	public Paillier(int id, KeyPair keyPair, String encryptedData) {
		super();
		this.id = id;
		this.keyPair = keyPair;
		this.encryptedData = encryptedData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public KeyPair getKeyPair() {
		return keyPair;
	}

	public void setKeyPair(KeyPair keyPair) {
		this.keyPair = keyPair;
	}

	public String getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
