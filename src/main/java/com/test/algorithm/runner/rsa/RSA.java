/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.rsa;

import java.security.PrivateKey;
import java.security.PublicKey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

/**
 * 
 * @author Sumitha Jothiramalingam Entity object that holds RSA specific fields
 */
@Entity
public class RSA {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * Generated Unique ID
	 */
	private int id;
	@Type(type = "serializable")
	/**
	 * Public Key is Serialized and Stored into cloud via this param param
	 */
	PublicKey publicKey;
	@Type(type = "serializable")
	/**
	 * Private Key is Serialized and Stored into cloud via this param
	 */
	PrivateKey privateKey;
	/**
	 * The Encrypted text is Serialized and Stored into cloud via this param
	 */
	byte[] encryptedText;

	/**
	 * Default Constructor
	 */
	public RSA() {
	}

	/**
	 * Constructor With Arguments
	 * 
	 * @param id
	 *            - Generated Value
	 * @param publicKey
	 *            - Generated Public Key
	 * @param privateKey-
	 *            Generated Private Key
	 * @param encryptedText
	 *            - Text that is encrypted with RSA Algorithm with the appended keys
	 */
	public RSA(int id, PublicKey publicKey, PrivateKey privateKey, byte[] encryptedText) {
		super();
		this.id = id;
		this.publicKey = publicKey;
		this.privateKey = privateKey;
		this.encryptedText = encryptedText;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	public byte[] getEncryptedText() {
		return encryptedText;
	}

	public void setEncryptedText(byte[] encryptedText) {
		this.encryptedText = encryptedText;
	}

}
