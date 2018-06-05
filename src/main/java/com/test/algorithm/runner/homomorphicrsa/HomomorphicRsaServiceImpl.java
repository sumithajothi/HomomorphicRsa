/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.homomorphicrsa;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.algorithm.runner.auth.Response;

@Service
public class HomomorphicRsaServiceImpl implements HomomorphicRsaService {
	@Autowired
	HomomorphicRsaRepository homomorphicRsaRepository;

	@Override
	public BigInteger encrypt(BigInteger message, BigInteger publicKey, BigInteger modulus) {
		return message.modPow(publicKey, modulus);
	}

	@Override
	public Response encryptData(BigInteger valueOne, BigInteger valueTwo) {
		Response response = new Response();
		try {
			HomomorphicRsa homomorphicRsa = getNthBit(100);
			BigInteger enc_x1 = encrypt(valueOne, new BigInteger(homomorphicRsa.getPublicKey()),
					new BigInteger(homomorphicRsa.getModulusData()));
			BigInteger enc_x2 = encrypt(valueTwo, new BigInteger(homomorphicRsa.getPublicKey()),
					new BigInteger(homomorphicRsa.getModulusData()));
			BigInteger homomorphic = enc_x1.multiply(enc_x2);
			homomorphicRsa.setEncryptedDataOne("" + enc_x1);
			homomorphicRsa.setEncryptedDataTwo("" + enc_x2);
			homomorphicRsa.setHomomorphicEncryptedData("" + homomorphic);
			response.setIsException(false);
			homomorphicRsa = homomorphicRsaRepository.save(homomorphicRsa);
			response.setResponseData(homomorphicRsa);
			response.setResponseMessage("Successfully Encrypted");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(true);
			response.setExceptionMessage("Failed to Encrypt");
			return response;
		}
	}

	@Override
	public Response decryptData(int id) {
		Response response = new Response();
		try {
			HomomorphicRsa homomorphicRsa = homomorphicRsaRepository.findById(id);
			BigInteger dec_x1 = decrypt(new BigInteger(homomorphicRsa.getEncryptedDataOne()),
					new BigInteger(homomorphicRsa.getPrivateKey()), new BigInteger(homomorphicRsa.getModulusData()));
			BigInteger dec_x2 = decrypt(new BigInteger(homomorphicRsa.getEncryptedDataTwo()),
					new BigInteger(homomorphicRsa.getPrivateKey()), new BigInteger(homomorphicRsa.getModulusData()));
			BigInteger dec_h = decrypt(new BigInteger(homomorphicRsa.getHomomorphicEncryptedData()),
					new BigInteger(homomorphicRsa.getPrivateKey()), new BigInteger(homomorphicRsa.getModulusData()));
			DecryptedHomomorphicRsa decryptedHomomorphicRsa = new DecryptedHomomorphicRsa(homomorphicRsa.getId(),
					dec_x1, dec_x2, dec_h);
			response.setIsException(false);
			response.setResponseData(decryptedHomomorphicRsa);
			response.setResponseMessage("Successfully Decrypted");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(true);
			response.setExceptionMessage("Failed to Decrypt");
			return response;
		}
	}

	@Override
	public BigInteger decrypt(BigInteger encrypted, BigInteger privateKey, BigInteger modulus) {
		return encrypted.modPow(privateKey, modulus);
	}

	private HomomorphicRsa getNthBit(int N) {
		BigInteger one = new BigInteger("1");
		SecureRandom random = new SecureRandom();
		BigInteger p = BigInteger.probablePrime(N / 2, random);
		BigInteger q = BigInteger.probablePrime(N / 2, random);
		BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
		BigInteger modulus = p.multiply(q);
		BigInteger publicKey = new BigInteger("65537"); // common value in practice = 2^16 + 1
		BigInteger privateKey = publicKey.modInverse(phi);
		HomomorphicRsa homomorphicRsa = new HomomorphicRsa(-1, "" + privateKey, "" + publicKey, "" + modulus, "0", "0",
				"0");
		return homomorphicRsa;
	}
}
