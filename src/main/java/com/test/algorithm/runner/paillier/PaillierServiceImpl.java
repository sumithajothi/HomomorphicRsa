package com.test.algorithm.runner.paillier;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.algorithm.runner.auth.Response;

@Service
public class PaillierServiceImpl implements PaillierService {
	@Autowired
	PaillierRepository paillierRepository;

	@Override
	public KeyPair buildKeyPair() {
		KeyPairBuilder keygen = new KeyPairBuilder();
		KeyPair keyPair = keygen.generateKeyPair();
		return keyPair;
	}

	@Override
	public BigInteger encrypt(BigInteger data, KeyPair keyPair) {
		PublicKey publicKey = keyPair.getPublicKey();
		BigInteger ciphertext = publicKey.encrypt(data);
		return ciphertext;
	}

	@Override
	public BigInteger decrypt(KeyPair keyPair, BigInteger cypherText) {
		BigInteger decryptedData = keyPair.decrypt(cypherText);
		return decryptedData;
	}

	@Override
	public BigInteger homomorphicPaillierEncryption(BigInteger plainA, BigInteger plainB, KeyPair keyPair) {
		BigInteger encryptedA = keyPair.getPublicKey().encrypt(plainA);
		BigInteger encryptedB = keyPair.getPublicKey().encrypt(plainB);
		BigInteger encryptedProduct = encryptedA.multiply(encryptedB).mod(keyPair.getPublicKey().getnSquared());
		return encryptedProduct;
	}

	@Override
	public BigInteger homomorphicPaillierDecryption(BigInteger encryptedData, KeyPair keyPair) {
		BigInteger additionResult = keyPair.decrypt(encryptedData);
		return additionResult;
	}

	@Override
	public Response encryptWithPaillier(BigInteger data) {
		Response response = new Response();
		try {
			KeyPair keyPair = buildKeyPair();
			BigInteger encryptedData = encrypt(data, keyPair);
			Paillier paillier = new Paillier(-1, keyPair, "" + encryptedData);
			paillier = paillierRepository.save(paillier);
			response.setIsException(false);
			response.setResponseData(paillier);
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
	public Response decryptWithPaillier(int id) {
		Response response = new Response();
		try {
			Paillier paillier = paillierRepository.findById(id);
			response.setIsException(false);
			response.setResponseData(decrypt(paillier.getKeyPair(), new BigInteger(paillier.getEncryptedData())));
			response.setResponseMessage("Successfully Decrypted");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(true);
			response.setExceptionMessage("Failed to Decrypt");
			return response;
		}
	}

}
