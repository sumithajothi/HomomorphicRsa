/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.rsa;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import com.test.algorithm.runner.auth.Response;

public interface RSAService {

	KeyPair buildKeyPair() throws NoSuchAlgorithmException;

	/**
	 * Encrypts a given message with a generated private key, stores the private key
	 * and encrypted string return encrypted string as bytes
	 */
	byte[] encrypt(PrivateKey privateKey, String message) throws Exception;

	/**
	 * Decrypts an encrypted string with the pre-generated public key returns
	 * decrypted string as bytes
	 */
	byte[] decrypt(PublicKey publicKey, byte[] encrypted) throws Exception;

	/**
	 * Encrypts a given plain text with RSA Algorithm, stores into the cloud and
	 * returns the id with which the record can be fetched for decryption
	 * 
	 * @param plainText
	 *            Plain text as user input
	 * @return {@link Response} object with response data that contains record
	 *         stored in the cloud, status and exceptions if any
	 * @throws Exception
	 */
	Response buildAndProcessRsa(String plainText) throws Exception;

	/**
	 * Decrypts a stored encrypted string with public and private key
	 * 
	 * @param id
	 *            Identifier that was returned as a result of encryption response
	 * @return {@link Response} object with decrypted plain text as response data,
	 *         status and exceptions if any
	 * @throws Exception
	 */
	Response getPlainText(int id) throws Exception;

}
