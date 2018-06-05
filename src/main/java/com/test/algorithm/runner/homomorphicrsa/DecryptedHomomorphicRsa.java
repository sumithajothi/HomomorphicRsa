/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.homomorphicrsa;

import java.math.BigInteger;

/**
 * 
 * @author Sumitha Jothiramalingam DTO object that holds Decrypted Homomorphic
 *         RSA specific fields
 */
public class DecryptedHomomorphicRsa {
	/**
	 * Generated Unique ID - Retrieved From DB
	 */
	int id;
	/**
	 * Decrypted value one
	 */
	BigInteger valueOne;
	/**
	 * Decrypted value Two
	 */
	BigInteger valueTwo;
	/**
	 * Decrypted HomomorphicData
	 */
	BigInteger decryptedHomomorphicData;

	public DecryptedHomomorphicRsa() {
	}

	public DecryptedHomomorphicRsa(int id, BigInteger valueOne, BigInteger valueTwo,
			BigInteger decryptedHomomorphicData) {
		super();
		this.id = id;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
		this.decryptedHomomorphicData = decryptedHomomorphicData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getValueOne() {
		return valueOne;
	}

	public void setValueOne(BigInteger valueOne) {
		this.valueOne = valueOne;
	}

	public BigInteger getValueTwo() {
		return valueTwo;
	}

	public void setValueTwo(BigInteger valueTwo) {
		this.valueTwo = valueTwo;
	}

	public BigInteger getDecryptedHomomorphicData() {
		return decryptedHomomorphicData;
	}

	public void setDecryptedHomomorphicData(BigInteger decryptedHomomorphicData) {
		this.decryptedHomomorphicData = decryptedHomomorphicData;
	}

}
