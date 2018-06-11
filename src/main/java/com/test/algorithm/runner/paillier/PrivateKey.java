package com.test.algorithm.runner.paillier;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * A class that represents the private part of the Paillier key pair.
 */
class PrivateKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private final BigInteger lambda;
	private final BigInteger preCalculatedDenominator;

	PrivateKey(BigInteger lambda, BigInteger preCalculatedDenominator) {
		this.lambda = lambda;

		this.preCalculatedDenominator = preCalculatedDenominator;
	}

	public BigInteger getLambda() {
		return lambda;
	}

	public BigInteger getPreCalculatedDenominator() {
		return preCalculatedDenominator;
	}
}
