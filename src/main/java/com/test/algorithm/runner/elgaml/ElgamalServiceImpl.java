package com.test.algorithm.runner.elgaml;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.algorithm.runner.auth.Response;

@Service
public class ElgamalServiceImpl implements ElgamalService {
	@Autowired
	ElgamalRepository elgamalRepository;

	@Override
	public Response ecnrypt(String plainText, String secretKey) {
		Response response = new Response();
		try {
			Elgamal elgaml = generateKey(secretKey);
			elgaml.setId(-1);
			Random sc = new SecureRandom();
			BigInteger X = new BigInteger(plainText);
			BigInteger r = new BigInteger(64, sc);
			BigInteger EC = X
					.multiply(new BigInteger(elgaml.getModPow()).modPow(r, new BigInteger(elgaml.getPropablePrime())))
					.mod(new BigInteger(elgaml.getPropablePrime()));
			BigInteger brmodp = new BigInteger(elgaml.getValueB()).modPow(r, new BigInteger(elgaml.getPropablePrime()));
			elgaml.setrValue("" + r);
			elgaml.setEncryptedData("" + EC);
			elgaml.setModuloData("" + brmodp);
			elgaml = elgamalRepository.save(elgaml);
			response.setResponseData(elgaml);
			response.setIsException(false);
			response.setResponseMessage("Successfully Encrypted");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(true);
			response.setExceptionMessage("Failed To Encrypt");
			return response;
		}
	}

	@Override
	public Response decrypt(int id, String secretKey) {
		Response response = new Response();
		try {
			Elgamal elgaml = elgamalRepository.findById(id);
			BigInteger crmodp = new BigInteger(elgaml.getModuloData()).modPow(new BigInteger(secretKey),
					new BigInteger(elgaml.getPropablePrime()));
			BigInteger d = crmodp.modInverse(new BigInteger(elgaml.getPropablePrime()));
			BigInteger ad = d.multiply(new BigInteger(elgaml.getEncryptedData()))
					.mod(new BigInteger(elgaml.getPropablePrime()));

			elgaml.setCypherModuloPrime("" + crmodp);
			elgaml.setdValue("" + d);
			elgaml.setDecryptedValue("" + ad);
			response.setResponseData(elgaml);
			response.setIsException(false);
			response.setResponseMessage("Successfully Decrypted");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(true);
			response.setExceptionMessage("Failed To Decrypt");
			return response;
		}
	}

	@Override
	public Elgamal generateKey(String secret) {
		BigInteger p, b, c, secretKey;
		Random sc = new SecureRandom();
		secretKey = new BigInteger(secret);
		p = BigInteger.probablePrime(64, sc);
		b = new BigInteger("3");
		c = b.modPow(secretKey, p);

		Elgamal elgaml = new Elgamal();
		elgaml.setModPow("" + c);
		elgaml.setPropablePrime("" + p);
		elgaml.setSecretKey("" + secretKey);
		elgaml.setValueB("" + b);
		return elgaml;
	}

}
