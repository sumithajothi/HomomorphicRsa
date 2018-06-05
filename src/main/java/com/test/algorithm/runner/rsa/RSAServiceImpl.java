/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.algorithm.runner.auth.Response;

@Service
public class RSAServiceImpl implements RSAService {
	@Autowired
	RSARepository rsaRepository;

	@Override
	public Response buildAndProcessRsa(String plainText) throws Exception {
		Response response = new Response();

		try {
			KeyPair keyPair = buildKeyPair();
			PublicKey pubKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			byte[] encrypted = encrypt(privateKey, plainText);
			RSA rsa = new RSA(-1, pubKey, privateKey, encrypted);
			response.setResponseData(new RSADto(rsaRepository.save(rsa).getId(), plainText, new String(encrypted)));
			response.setIsException(false);
			response.setResponseMessage("Succesfully Saved");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(false);
			response.setResponseMessage("Failed to Encrypt");
			return response;
		}
	}

	@Override
	public Response getPlainText(int id) throws Exception {
		Response response = new Response();
		try {
			RSA rsa = rsaRepository.findById(id);
			if (rsa != null) {
				byte[] secret = decrypt(rsa.getPublicKey(), rsa.getEncryptedText());
				response.setResponseData(new String(secret));
				response.setIsException(false);
				response.setResponseMessage("Succesfully Fetched");
				return response;
			} else {
				response.setIsException(false);
				response.setResponseMessage("ID Does Not Exist");
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(false);
			response.setResponseMessage("Succesfully Fetched");
			return response;
		}
	}

	@Override
	public KeyPair buildKeyPair() throws NoSuchAlgorithmException {
		final int keySize = 2048;
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(keySize);
		return keyPairGenerator.genKeyPair();
	}

	@Override
	public byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);

		return cipher.doFinal(message.getBytes());
	}

	@Override
	public byte[] decrypt(PublicKey publicKey, byte[] encrypted) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, publicKey);

		return cipher.doFinal(encrypted);
	}

}
