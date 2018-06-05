/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.homomorphicrsa;

import java.math.BigInteger;

import com.test.algorithm.runner.auth.Response;

public interface HomomorphicRsaService {
	/**
	 * Encrypts a given message with the provided Public Key and modulus that was
	 * calculated during operations
	 */
	BigInteger encrypt(BigInteger message, BigInteger publicKey, BigInteger modulus);

	/**
	 * Decrypts a given encrypted message with the provided Private Key and modulus
	 * that was calculated during operations
	 */
	BigInteger decrypt(BigInteger encrypted, BigInteger privateKey, BigInteger modulus);

	/**
	 * Encrypts two values with Homomorphic RSA technique after storing the same
	 * into cloud Database
	 * 
	 * @param valueOne
	 *            - First User Input Value
	 * @param valueTwo
	 *            - Second User Input Value
	 * @return - a {@link Response} object with response data that contains ID of
	 *         encrypted record stored in the cloud, status and exceptions if any
	 */
	Response encryptData(BigInteger valueOne, BigInteger valueTwo);

	/**
	 * 
	 * @param id
	 *            - The ID that was returned during encryption - This indicates the
	 *            record identifier of encrypted data stored in the cloud DB
	 * @return - {@link Response} object with response data, status and exceptions
	 *         if any
	 */
	Response decryptData(int id);
}
