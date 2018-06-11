package com.test.algorithm.runner.elgaml;

import com.test.algorithm.runner.auth.Response;

public interface ElgamalService {
	Response ecnrypt(String plainText, String secretKey);

	Response decrypt(int id, String secretKey);

	Elgamal generateKey(String secret);
}
