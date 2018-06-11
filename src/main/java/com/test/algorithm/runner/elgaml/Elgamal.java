package com.test.algorithm.runner.elgaml;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Elgamal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * Generated Unique ID
	 */
	private int id;
	String propablePrime;
	String modPow;
	String secretKey;
	String valueB;
	String rValue;
	String encryptedData;
	String moduloData;
	String cypherModuloPrime;
	String dValue;
	String decryptedValue;

	public Elgamal() {
	}

	public Elgamal(String propablePrime, String modPow, String secretKey, String valueB, String rValue,
			String encryptedData, String moduloData, String cypherModuloPrime, String dValue, String decryptedValue) {
		super();
		this.propablePrime = propablePrime;
		this.modPow = modPow;
		this.secretKey = secretKey;
		this.valueB = valueB;
		this.rValue = rValue;
		this.encryptedData = encryptedData;
		this.moduloData = moduloData;
		this.cypherModuloPrime = cypherModuloPrime;
		this.dValue = dValue;
		this.decryptedValue = decryptedValue;
	}

	public String getPropablePrime() {
		return propablePrime;
	}

	public void setPropablePrime(String propablePrime) {
		this.propablePrime = propablePrime;
	}

	public String getModPow() {
		return modPow;
	}

	public void setModPow(String modPow) {
		this.modPow = modPow;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getValueB() {
		return valueB;
	}

	public void setValueB(String valueB) {
		this.valueB = valueB;
	}

	public String getrValue() {
		return rValue;
	}

	public void setrValue(String rValue) {
		this.rValue = rValue;
	}

	public String getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	public String getModuloData() {
		return moduloData;
	}

	public void setModuloData(String moduloData) {
		this.moduloData = moduloData;
	}

	public String getCypherModuloPrime() {
		return cypherModuloPrime;
	}

	public void setCypherModuloPrime(String cypherModuloPrime) {
		this.cypherModuloPrime = cypherModuloPrime;
	}

	public String getdValue() {
		return dValue;
	}

	public void setdValue(String dValue) {
		this.dValue = dValue;
	}

	public String getDecryptedValue() {
		return decryptedValue;
	}

	public void setDecryptedValue(String decryptedValue) {
		this.decryptedValue = decryptedValue;
	}

}
