/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.homomorphicrsa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Sumitha Jothiramalingam Entity object that holds Homomorphic RSA
 *         specific fields
 */
@Entity
public class HomomorphicRsa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * Generated Unique ID
	 */
	private int id;
	/**
	 * Private Key that is stored as String
	 */
	private String privateKey;
	/**
	 * Public Key that is stored as String
	 */
	private String publicKey;
	/**
	 * After Modulo operation during encryption the data is persisted into this
	 * param
	 */
	private String modulusData;
	/**
	 * First Data encrypted with the provided keys and modulo operation is stored
	 * into this param
	 */
	private String encryptedDataOne;
	/**
	 * Second Data encrypted with the provided keys and modulo operation is stored
	 * into this param
	 */
	private String encryptedDataTwo;
	/**
	 * Data Encrypted with Homomorphic algorithm is persisted with this param
	 */
	private String homomorphicEncryptedData;

	public HomomorphicRsa() {
	}

	public HomomorphicRsa(int id, String privateKey, String publicKey, String modulusData, String encryptedDataOne,
			String encryptedDataTwo, String homomorphicEncryptedData) {
		super();
		this.id = id;
		this.privateKey = privateKey;
		this.publicKey = publicKey;
		this.modulusData = modulusData;
		this.encryptedDataOne = encryptedDataOne;
		this.encryptedDataTwo = encryptedDataTwo;
		this.homomorphicEncryptedData = homomorphicEncryptedData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getModulusData() {
		return modulusData;
	}

	public void setModulusData(String modulusData) {
		this.modulusData = modulusData;
	}

	public String getEncryptedDataOne() {
		return encryptedDataOne;
	}

	public void setEncryptedDataOne(String encryptedDataOne) {
		this.encryptedDataOne = encryptedDataOne;
	}

	public String getEncryptedDataTwo() {
		return encryptedDataTwo;
	}

	public void setEncryptedDataTwo(String encryptedDataTwo) {
		this.encryptedDataTwo = encryptedDataTwo;
	}

	public String getHomomorphicEncryptedData() {
		return homomorphicEncryptedData;
	}

	public void setHomomorphicEncryptedData(String homomorphicEncryptedData) {
		this.homomorphicEncryptedData = homomorphicEncryptedData;
	}

}
