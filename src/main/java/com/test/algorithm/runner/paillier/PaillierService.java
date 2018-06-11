package com.test.algorithm.runner.paillier;

import java.math.BigInteger;

import com.test.algorithm.runner.auth.Response;

public interface PaillierService {
	Response encryptWithPaillier(BigInteger data);

	Response decryptWithPaillier(int id);

	KeyPair buildKeyPair();

	BigInteger encrypt(BigInteger data, KeyPair keyPair);

	BigInteger decrypt(KeyPair keyPair, BigInteger cypherText);

	BigInteger homomorphicPaillierEncryption(BigInteger plainA, BigInteger plainB, KeyPair keyPair);

	BigInteger homomorphicPaillierDecryption(BigInteger encryptedData, KeyPair keyPair);
}
